import java.awt.*;

abstract class Sharp {
  protected Point _location;

  Sharp(Point location){
      _location = location;
  }
  abstract void draw(Graphics g);

}
