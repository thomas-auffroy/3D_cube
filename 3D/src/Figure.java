/**
 * A figure class object.
 * @author Thomas
 */
public class Figure {

	/**
	 * Construct a Figure object. It contains all the figures coded.
	 */
	public Figure() {
		// TODO Auto-generated constructor stub
	}

	public int[] vector(int x, int y, int z, double angleX, double angleY, double zoom) throws SizeException{
		int[] coord = new int[2];
		
		Point A = new Point(x,y,z);
		
		A.rotate3D('x', angleX);
		A.rotate3D('y', angleY);
		A.rotate3D('z', 0);
		
		A.transform3Dto2D(zoom);
		coord[0] = (int) A.getCoordinates2D()[0];
		coord[1] = (int) A.getCoordinates2D()[1];
				
		return coord;
	}
		
	public int[][] orthogonal(double theta, double phi, double zoom) throws SizeException{
		int[][] u = new int[3][2];
		u[0] = vector(50,0,0, phi, theta, zoom);
		u[1] = vector(0,50,0, phi, theta, zoom);
		u[2] = vector(0,0,50, phi, theta, zoom);
		
		return u;
	}
	
	
	/**
	 * Initialize a cuboid shape. With the given attributes, creates all the point of the cuboid in a 3D space. All the points, one at each vertex, are Point objects.
	 * Applies a 3D transform to return the coordinates in a 2D space.
	 * @param x - x coordinates of the left top vertex.
	 * @param y - y coordinates of the left top vertex.
	 * @param height - height of the square.
	 * @param width - width of the square.
	 * @param length - length of the cuboid
	 * @param theta - rotation around the y axis with a angle value of <b>theta</b>.
	 * @param phi - rotation around the x axis with a angle value of <b>phi</b>.
	 * @return returns a 2D Array which correspond to each point of the cuboid in a 2D space.
	 * @throws SizeException if the size do not correspond for a matrix multiplication.
	 */
	public int[][] cuboid(int x, int y, int height, int width, int length, double theta, double phi, double zoom) throws SizeException {
		double []xCoord = new double[8];
		double []yCoord = new double[8];
		
		Point A = new Point(x,y - height,length/2);
		A.rotate3D('x', phi);
		A.rotate3D('y', theta);
		A.rotate3D('z', 0);
		
		A.transform3Dto2D(zoom);
		xCoord[0]=A.getCoordinates2D()[0];
		yCoord[0]=A.getCoordinates2D()[1];
		
		Point B = new Point(x + width,y - height,length/2);
		B.rotate3D('x', phi);
		B.rotate3D('y', theta);
		B.rotate3D('z', 0);
		
		B.transform3Dto2D(zoom);
		xCoord[1]=B.getCoordinates2D()[0];
		yCoord[1]=B.getCoordinates2D()[1];
		
		Point C = new Point(x,y,length/2);
		C.rotate3D('x', phi);
		C.rotate3D('y', theta);
		C.rotate3D('z', 0);
		
		C.transform3Dto2D(zoom);
		xCoord[2]=C.getCoordinates2D()[0];
		yCoord[2]=C.getCoordinates2D()[1];
		
		Point D = new Point(x + width,y,length/2);
		D.rotate3D('x', phi);
		D.rotate3D('y', theta);
		D.rotate3D('z', 0);
		
		D.transform3Dto2D(zoom);
		xCoord[3]=D.getCoordinates2D()[0];
		yCoord[3]=D.getCoordinates2D()[1];
		
		Point E = new Point(x,y - height,-length/2);
		E.rotate3D('x', phi);
		E.rotate3D('y', theta);
		E.rotate3D('z', 0);
		
		E.transform3Dto2D(zoom);
		xCoord[4]=E.getCoordinates2D()[0];
		yCoord[4]=E.getCoordinates2D()[1];
		
		Point F = new Point(x + width,y - height,-length/2);
		F.rotate3D('x', phi);
		F.rotate3D('y', theta);
		F.rotate3D('z', 0);
		
		F.transform3Dto2D(zoom);
		xCoord[5]=F.getCoordinates2D()[0];
		yCoord[5]=F.getCoordinates2D()[1];
		
		Point G = new Point(x,y,-length/2);
		G.rotate3D('x', phi);
		G.rotate3D('y', theta);
		G.rotate3D('z', 0);
		
		G.transform3Dto2D(zoom);
		xCoord[6]=G.getCoordinates2D()[0];
		yCoord[6]=G.getCoordinates2D()[1];
		
		Point H = new Point(x + width,y,-length/2);
		H.rotate3D('x', phi);
		H.rotate3D('y', theta);
		H.rotate3D('z', 0);
		
		H.transform3Dto2D(zoom);
		xCoord[7]=H.getCoordinates2D()[0];
		yCoord[7]=H.getCoordinates2D()[1];
		
		int [][]coord = new int[2][8];
		for(int i = 0; i < xCoord.length; i++) {coord[0][i] = (int)xCoord[i];}
		for(int i = 0; i < yCoord.length; i++) {coord[1][i] = (int)yCoord[i];}
		return coord;		
	}	
}
