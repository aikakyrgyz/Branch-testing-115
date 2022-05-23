
public class Triangle {
	private int side1Length;
	private int side2Length;
	private int side3Length;
	private TriangleType type;
	
	public Triangle(int side1Length, int side2Length, int side3Length) {
		this.side1Length = side1Length;
		this.side2Length = side2Length;
		this.side3Length = side3Length;
	}
	
	public int getSide1Length() {
		return side1Length;
	}
	
	public int getSide2Length() {
		return side2Length;
	}
	
	public int getSide3Length() {
		return side3Length;
	}
	
	public void setType(TriangleType t) {
		type = t;
	}
	
	public TriangleType getType() {
		return type;
	}
}
