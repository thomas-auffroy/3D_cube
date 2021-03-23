/**
 * A Point class object.
 * @author Thomas
 */

public class Point {
	private Matrix coordinates3D = new Matrix(1,3); // Initiate a Matrix object to match with the 3D coordinates.
	private Matrix coordinates2D = new Matrix(1,3); // Initiate a Matrix object to match with the 2D coordinates.
	
	/**
	 * Construct a Point object with the given coordinates (x,y,z).
	 * @param a - x coordinates.
	 * @param b - y coordinates.
	 * @param c - z coordinates.
	 */
	public Point(double a, double b, double c) {
		// TODO Auto-generated constructor stub
		double[][] M = {	{a,b,c}
						};
		this.coordinates3D.setMatrix(M);
	}
	
	/**
	 * Transform the coordinates, from 3D to 2D, of the current Point object.
	 * <br> It uses a linear transformation and matrix multiplication.
	 * <br> Useful to display the Point object in a 2D graphic.
	 * @throws SizeException if the size do not correspond for a matrix multiplication.
	 */
	public void transform3Dto2D(double zoom) throws SizeException {
		double[][] M = {	{1*zoom,0},
							{0,-1*zoom},
							{0,0}
						};		
		Matrix linearTransform = new Matrix(M);
		this.coordinates2D = this.coordinates3D.matrixMul(linearTransform);
	}
	
	/**
	 * Rotate the coordinates, with a specific axis and angle, of the current Point object.
	 * <br> It uses a rotation transformation and matrix multiplication.
	 * @param axis - the rotation will occur around this axis. For example, a rotation around the x axis, will change only the coordinates of y and z.
	 * 				<br> Enable values: <code>'x'</code>, <code>'y'</code>, <code>'z'</code>.
	 * @param theta - the value for the rotation angle. 
	 * @throws SizeException if the size do not correspond for a matrix multiplication.
	 */
	public void rotate3D(char axis, double theta) throws SizeException{
		double[][] P = null;

		if (axis == 'x') {
			double[][] M = {	{1, 0, 0},
								{0, Math.cos(theta), -Math.sin(theta)},
								{0, Math.sin(theta), Math.cos(theta)}
							};	
			P = M.clone();
			
		}else if (axis == 'y') {
			double[][] M = {	{Math.cos(theta), 0, Math.sin(theta)},
								{0, 1, 0},
								{-Math.sin(theta),0, Math.cos(theta)}	
			};	
			P = M.clone();
			
		}else if (axis == 'z'){
			double[][] M = {	{Math.cos(theta), -Math.sin(theta), 0},
								{Math.sin(theta), Math.cos(theta), 0},
								{0,0, 1}	
			};	
			P = M.clone();
		}
		
		Matrix rotateTransform = new Matrix(P);		
		this.coordinates3D = this.coordinates3D.matrixMul(rotateTransform);
	}
	
	/**
	 * Get the 2D coordinates of the current Point object, as a 1D Array. 
	 * @return 1D Array, where the 1st value correspond to the <b>x</b> component and the 2nd to the <b>y</b> component.
	 */
	public double[] getCoordinates2D() {
		double[] coord = new double[2];
		coord[0] = coordinates2D.getValue(0, 0);
		coord[1] = coordinates2D.getValue(0, 1);
		return coord;
	}
	
	/**
	 * Get the 3D coordinates of the current Point object, as a 1D Array. 
	 * @return 1D Array, where the 1st value correspond to the <b>x</b> component, the 2nd to the <b>y</b> component and the 3rd to the <b>z</b> component..
	 */
	public double[] getCoordinates3D() {
		double[] coord = new double[3];
		coord[0] = coordinates3D.getValue(0, 0);
		coord[1] = coordinates3D.getValue(0, 1);
		coord[2] = coordinates3D.getValue(0, 2);
		return coord;
	}
}
