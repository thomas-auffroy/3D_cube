/**
 * A Matrix class object.
 * @author Pasteak
 */
public class Matrix {
	private double[][] M; // M represents the current Matrix object as a 2D Array
	
	private int sizeI, sizeJ; // Size of the columns and the rows
	
	/**
	 * Construct a blank Matrix object with n columns and m rows.
	 * @param n - size for the columns.
	 * @param m - size for the rows.
	 */
	public Matrix(int n, int m) {
		// TODO Auto-generated constructor stub
		// Empty matrix
		this.sizeI = n;
		this.sizeJ = m;
		this.M = new double[n][m];
	}
	
	/**
	 * Construct a Matrix object with a given aArray.
	 * @param P - 2D Array.
	 */
	public Matrix(double [][] P) {
		// TODO Auto-generated constructor stub
		this.sizeI = P.length;
		this.sizeJ = P[1].length;
		this.M = P.clone();		
	}
	
	/**
	 * Set the current Matrix object with the given 2D Array.
	 * @param x - 2D Array
	 */
	public void setMatrix(double[][] x) {
		this.M = x.clone();
	}
	
	/**
	 * Set the value for the current Matrix object at the index (n,m) with the value x.
	 * @param n - nth column of the current Matrix object.
	 * @param m - mth row of the current Matrix object.
	 * @param x - new value to set at.
	 */
	public void setMatrix(int n, int m, double x) {
		this.M[n][m] = x;
	}
	
	/**
	 * Return the value of the current Matrix object at the nth column and mth row.
	 * @param n - nth column of the current Matrix object.
	 * @param m - mth row of the current Matrix object.
	 * @return the value at the index (n,m).
	 */
	public double getValue(int n, int m) {
		return this.M[n][m];
	}

	/**
	 * Compute the multiplication of the current Matrix object with an other one.
	 * @param P - the Matrix object P, which will be multiply by the current Matrix object.
	 * @return a Matrix object which correspond to the multiplication of the current Matrix object and the Matrix object P.
	 * @throws SizeException if the size do not correspond for a matrix multiplication.
	 */
	public Matrix matrixMul(Matrix P) throws SizeException {
		if(this.sizeJ != P.sizeI) {throw new SizeException();}
		Matrix result = new Matrix(this.sizeI,P.sizeJ);
			
		for(int i = 0; i < this.sizeI; i++) {
			for(int n = 0; n < P.sizeJ; n++) {
				double dummy = 0;
				for(int j = 0; j < this.sizeJ; j++) {
					dummy += this.getValue(i, j)*P.getValue(j, n);
				}
				result.setMatrix(i, n, dummy);
			}
		}
		return result;
	}
	
	// Overwrites the toString() Method for the class Matrix.
	public String toString() {
		for(int i=0; i<this.sizeI;i++) {
			for(int j=0; j<this.sizeJ;j++) {
				System.out.print(this.getValue(i,j)+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		return "";
	}	
}
