
package net.ladstatt.sierpinski

import android.content.Context
import android.graphics._
import android.util.{AttributeSet, SparseArray}
import android.view.{MotionEvent, View}

import scala.Option

/**
  * Implements a view which displays a sierpinski triangle.
  *
  * @param context
  * @param attrs
  */
class SierpinskiView (val context: Context, val attrs: AttributeSet) extends View(context, attrs) {

  override def onDraw(canvas: Canvas) {

    super.onDraw(canvas)    //super

    val width: Int = canvas.getWidth                
    val height: Float = (Math.sqrt(3)/2 * width).toFloat
    val p= new Paint(Color.BLACK)


    def draw(x: Float, y: Float, width: Float, height: Float)
    {
      canvas.drawLine(x + width, y, x + (width / 2), y + height, p)
      canvas.drawLine(x, y, x + width, y, p)
      canvas.drawLine(x, y, x + (width / 2), y + height, p)
    }

    def sierpinski(x: Float, y: Float, width: Float, height: Float, depth: Int){
      draw(x,y,width,height)
      if (depth <= 8) {
        val nWidth = width / 2
        val nHeight = height / 2
        sierpinski(x, y, nWidth, nHeight, depth + 1)
        sierpinski(x + nWidth / 2, y + nHeight, nWidth, nHeight, depth + 1)
        sierpinski(x + nWidth, y, nWidth, nHeight, depth + 1)
      }
    }


    sierpinski (0, height / 3, width, height, 0)    //sierpinski start at 0









  }
}