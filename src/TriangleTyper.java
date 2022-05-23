
public class TriangleTyper {

	// ====================================
	// The main triangle classification method
	public static int typer(int Side1, int Side2, int Side3)
	{
		int triOut;

		// triOut is output from the routine:
		//    Triang = 1 if triangle is scalene
		//    Triang = 2 if triangle is isosceles
		//    Triang = 3 if triangle is equilateral
		//    Triang = 4 if not a triangle
		//    Triang = 5 if the inputs are out of bounds

/*S1*/	if (Side1 <= 0 || Side2 <= 0 || Side3 <= 0)
		{
/*S2*/		triOut = 4;
/*S3*/		return (triOut);
		}
		
/*S4*/	if (Side1 > 1000 || Side2 > 1000 || Side3 > 1000)
		{
/*S5*/		triOut = 5;
/*S6*/		return (triOut);
		}

/*S7*/	triOut = 0;
/*S8*/	if (Side1 == Side2)
/*S9*/		triOut = triOut + 1;
/*S10*/	if (Side1 == Side3)
/*S11*/		triOut = triOut + 2;
/*S12*/	if (Side2 == Side3)
/*S13*/		triOut = triOut + 3;
/*S14*/	if (triOut == 0)
		{   // Confirm it's a valid triangle before declaring it to be scalene
/*S15*/		if (Side1+Side2 <= Side3 || Side2+Side3 <= Side1 || Side1+Side3 <= Side2)
/*S16*/			triOut = 4;
			else
/*S17*/			triOut = 1;
/*S18*/		return (triOut);
		}

		// Confirm it's a valid triangle before declaring
		// it to be isosceles or equilateral

/*S19*/	if (triOut > 3)
/*S20*/		triOut = 3;
/*S21*/	else if (triOut == 1 && Side1+Side2 > Side3)
/*S22*/		triOut = 2;
/*S23*/	else if (triOut == 2 && Side1+Side3 > Side2)
/*S24*/		triOut = 2;
/*S25*/	else if (triOut == 3 && Side2+Side3 > Side1)
/*S26*/		triOut = 2;
		else
/*S27*/		triOut = 4;
/*S28*/	return (triOut);
	} 

	public static TriangleType typer(Triangle t) throws IllegalArgumentException {
/*S1*/	if (t == null) {
/*S2*/		throw new IllegalArgumentException();
		}
/*S3*/	int intType = typer(t.getSide1Length(), t.getSide2Length(), t.getSide3Length());
/*S4*/	switch (intType) {
		case 1:
/*S5*/		return TriangleType.SCALENE;
		case 2:
/*S6*/		return TriangleType.ISOSCELES;
		case 3:
/*S7*/		return TriangleType.EQUILATERAL;
		case 5:
/*S8*/		return TriangleType.OOB;
		case 4:
		default:
/*S9*/		return TriangleType.NOT_TRIANGLE;
		}
	}
	
	public static void setTriangleType(Triangle t) {
		TriangleType type = typer(t);
		try {
			t.setType(type);
		} catch (IllegalArgumentException e) {
			System.err.println("Invalid Triangle Type");
		}
	} 
}

