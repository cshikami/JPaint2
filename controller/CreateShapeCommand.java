package controller;

import model.CreateEllipse;
import model.Ellipse;
import model.Point;
import model.Shape;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;

public class CreateShapeCommand implements ICommand {

	private Point startPoint;
	private Point endPoint;
	private IApplicationState applicationState;
	private Shape shape;
	

	public CreateShapeCommand(Point startPoint, Point endPoint, IApplicationState applicationState) {
		// TODO Auto-generated constructor stub
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.applicationState = applicationState;
	}

	@Override
	public void run() {
		System.out.println("In CreateShapeCommand!");
		System.out.println("startPoint: (" + startPoint.getX() + "," + startPoint.getY() + ")");
		System.out.println("endPoint: " + endPoint.getX() + "," + endPoint.getY() + ")");
		System.out.println("Active Shape Type: " + applicationState.getActiveShapeType());
		
		//shapeFactory.createShape()
		
		shape = null;
		
		if(applicationState.getActiveShapeType() == ShapeType.ELLIPSE) {
			
			shape = new Ellipse();
			//shapeList.add(shape);
		}
	}

}
