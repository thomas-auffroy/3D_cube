/**
 * A Vector class object.
 * @author Pasteak
 */

public class Vector {
	private double x = 0.0, y = 0.0, z = 0.0; // coordinates for the current Vector object
	
	/**
	 * Construct a Vector from two Points object.
	 * @see Point
	 * @param A - starting Point object A
	 * @param B - ending Point object B
	 */
	public Vector(Point A, Point B) {
		// TODO Auto-generated constructor stub
		this.x = B.getCoordinates3D()[0] - A.getCoordinates3D()[0];
		this.y = B.getCoordinates3D()[1] - A.getCoordinates3D()[0];
		this.z = B.getCoordinates3D()[2] - A.getCoordinates3D()[0];
	}
	
	/**
	 * Construct a Vector object with its coordinates.
	 * @param a - x coordinates
	 * @param b - y coordinates
	 * @param c - z coordinates
	 */
	public Vector(double a, double b, double c) {
		// TODO Auto-generated constructor stub
		this.x = a;
		this.y = b;
		this.z = c;
	}
	
	/**
	 * Compute the Euclidean norm of the current vector.
	 * @return Euclidean norm.
	 */
	public double computeNorm() {
		return Math.pow(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2), 0.5);
	}
	
	/**
	 * Compute the scalar product between the current vector and an other one.
	 * @param u - vector u
	 * @return the 3-dimensional scalar product between the current vector and u.
	 */
	public double computeScalarProduct(Vector u) {
		return this.x * u.getX() + this.y * u.getY() + this.z * u.getZ();
	}
	
	/**
	 * Compute the angle between the current vector and an other one. 
	 * <br> It used the scalar product formula.
	 * @param u - vector u
	 * @return angle between the current vector and u
	 */
	public double computeAngle(Vector u) {
		return Math.acos(this.computeScalarProduct(u) / (this.computeNorm()*u.computeNorm()));
	}
	
	/**
	 * Get the x coordinates of the current vector u(x,y,z).
	 * @return x coordinates
	 */	
	public double getX() {
		return this.x;
	}
	
	/**
	 * Get the y coordinates of the current vector u(x,y,z).
	 * @return y coordinates
	 */	
	public double getY() {
		return this.y;
		}
	
	/**
	 * Get the z coordinates of the current vector u(x,y,z).
	 * @return z coordinates
	 */
	public double getZ() {
		return this.z;
	}
	
	// Overwrites the toString() Method for the class Vector.
	public String toString() {
		System.out.println("(" + this.x + ";" + this.y + ";" + this.z + ")");
		return "";
	}	
}