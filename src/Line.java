import java.awt.*;
import java.util.List;

public class Line extends Sharp{

    private Point _location1 = new Point(-1,-1);
    private Point _location2 = new Point(-1,-1);
    private Point _location3 = new Point(-1,-1);
    private Point _location4 = new Point(-1,-1);
    private List<Point> lstPoint;
    private ILineStrategy _lineStrategy;

    public void set_location1(Point _location1) {
        this._location1 = _location1;
    }


    Line(Point location1) {
        super(location1);
        _location1 = location1;
        generateLineStrategy(0);
    }

    Line(Point location1 ,Point location2) {
        super(location1);
        _location1 = location1;
        _location2 = location2;
        generateLineStrategy(1);
    }

    Line(Point location1 ,Point location2, Point location3) {
        super(location1);
        _location1 = location1;
        _location2 = location2;
        _location3 = location3;
        generateLineStrategy(2);
    }

    Line(Point location1 ,Point location2, Point location3, Point location4) {
        super(location1);
        _location1 = location1;
        _location2 = location2;
        _location3 = location3;
        _location4 = location4;
        generateLineStrategy(3);
    }

    @Override
    void draw(Graphics g) {

        if(_lineStrategy != null){

            switch (_lineStrategy.doGetLine()){

                case 2:
                    if(_location1.getX() != -1 && _location1.getY() != -1) {
                        g.setColor(Color.GREEN);
                        g.fillOval(_location1.getX(), _location1.getY(), 5, 5);
                    }
                 break;

                case 4:
                    if(_location1.getX() != -1 && _location1.getY() != -1
                            && _location2.getX() != -1 && _location2.getY() != -1) {
                        g.setColor(Color.blue);
                        doDrawLine(g,_location1, _location2);
                    }
                    break;

                case 6:
                    if((_location1.getX() != -1 && _location1.getY() != -1
                            && _location2.getX() != -1 && _location2.getY() != -1
                            && _location3.getX() != -1 && _location3.getY() != -1)){
                        g.setColor(Color.BLUE);
                        doDrawLine(g, _location1, _location2);
                        doDrawLine(g, _location2, _location3);
                        doDrawLine(g, _location3, _location1);
                    }
                    break;

                case 8:
                    if((_location1.getX() != -1 && _location1.getY() != -1
                            && _location2.getX() != -1 && _location2.getY() != -1
                            && _location3.getX() != -1 && _location3.getY() != -1)
                            && _location4.getX() != -1 && _location4.getY() != -1){
                        g.setColor(Color.BLUE);
                        doDrawLine(g, _location1, _location2);
                        doDrawLine(g, _location2, _location3);
                        doDrawLine(g, _location3, _location1);
                        doDrawLine(g,_location4,_location1);
                    }
                    break;
            }

        }
        else {
            System.out.println("LineStrategy is null");
        }

    }

    public void doDrawLine(Graphics g, Point StartPoint,Point EndPoint){
        g.drawLine(StartPoint.getX(),StartPoint.getY(),EndPoint.getX(),EndPoint.getY());
    }

    public void setLineStrategy(ILineStrategy lineStrategy){
        _lineStrategy = lineStrategy;
    }

    public int getLineToDraw(){
        return  -1;
    }

    public void generateLineStrategy(int index){

        switch (index){
            case 0: _lineStrategy = new OneLine();
            break;
            case 1: _lineStrategy = new TowLine();
            break;
            case 2: _lineStrategy = new ThreeLine();
            break;
            case 3: _lineStrategy = new FourLine();
            break;
            default:
                System.out.println("index not found");
                break;
        }

    }

    public void logGetLineDetails(){

    }



}
