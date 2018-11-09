package view.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.CreateShapeCommand;
import model.Point;
import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;

public class UserMouseHandler extends MouseAdapter {
	private Point startPoint;
    private Point endPoint;
    private IApplicationState applicationState;
    
    public UserMouseHandler(IApplicationState applicationState) {
    	this.applicationState = applicationState;
    }
    
    public void mousePressed(MouseEvent e) {
    	startPoint = new Point(e.getX(), e.getY());
    	System.out.println("Point startPoint: (" + startPoint.getX() +"," + startPoint.getY() + ")");
    }
    
    public void mouseReleased(MouseEvent e) {
    	endPoint = new Point(e.getX(), e.getY());
    	System.out.println("Point endPoint: (" + endPoint.getX()  + ","+ endPoint.getY() + ")");
    	ICommand shape = null;
    	if (applicationState.getActiveStartAndEndPointMode() == StartAndEndPointMode.DRAW) {
    		shape = new CreateShapeCommand(startPoint, endPoint, applicationState);
    	}
    	shape.run();
    }
    
    
}