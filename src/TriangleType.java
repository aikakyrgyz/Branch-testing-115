
public enum TriangleType {
	SCALENE (1),
	ISOSCELES (2),
	EQUILATERAL (3),
	NOT_TRIANGLE (4),
	OOB (5);
	
	private final int typeCode;
	
	private TriangleType(int typeCode) {
		this.typeCode = typeCode;
	}
}
