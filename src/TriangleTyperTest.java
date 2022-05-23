// Name: Aigerim Kubanychbek kyzy; Student ID: 70321299; UCInetID: akubanyc
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

// This is just my initial, non-completed test class that I created during 
// class. Your goal is to complete this with more test cases (either using
// parameterized testing or just the regular @Test methods. Look at the 
// specification.

// Here is the specification, for convenience:

/* Specification: This method takes three integers as input and outputs an

 * integer. The three input variables each describe the lengths of each 
 * side of a triangle. The lengths of the sides of the triangle should be 
 * less than or equal to 1000. The output of this method will be one of 
 * 5 possible values: 
 * 		1 for a scalene triangle, 
 * 		2 for an isosceles triangle, 
 * 		3 for an equilateral triangle, 
 * 		4 for values that do not describe a triangle, and 
 * 		5 for values that are out of bounds.
 */



// CODE FOUND ON THE WEB FOR THE LAST TEST CASE

class TriangleTyperTest {
	
	
	

	
	// Normal JUnit (non-parameterized) version
	@Test
	void testEquilateral() {
		int type = TriangleTyper.typer(5, 5, 5);
		Assertions.assertEquals(3, type);
	}
	
	@Test 
	void testScalene() {
		int type = TriangleTyper.typer(3, 4, 5);
		Assertions.assertEquals(1, type);
	}
	// Parameterized version (you just need to add more values to the @CsvSource)
//	@ParameterizedTest(name="{0}: sides {1}, {2}, {3} Expected= {4}")
//	@CsvSource({//"'Equilateral', 5, 5, 5, 3",
//		//"'Scalene a<b<c', 3, 4, 5, 1", 
//		//"'Non triangle', -1, 1, 1, 4",//S7-S14
//		//"'Non triangle', 1, 1, -5, 4",//S7-S14
//		//"'Non triangle', 1, -5, 1, 4",//S7-S14
//		//"' Out of bounds', 1001, 999, 999, 5", //S4
//		//"'Out of bounds', 999, 999, 1001, 5",  //S4
//		//"'Out of bounds', 999, 1001, 999, 5",  //S4
//		//"'Non triangle', 1, 2, 5, 4",
//		//"'Isosceles', 3, 3, 2, 2",  //S8, S21
//		//"'Non triangle', 5, 5, 12, 4", //S8, S21
//		//"'Isosceles', 3, 2, 3, 2", //S23, S10
//		//"'Isosceles', 5, 3, 5, 2",  //S23, S10
//		//"'Isosceles', 2, 3, 3, 2",  // S25, S12
////		"'Non triangle', 5, 7, 1, 4", //S15
////		"'Non triangle', 5, 3, 2, 4", //S15
////		"'Non triangle', 1, 2, 1, 4", //S23, S10
////		"'Non triangle', 10, 2, 2, 4" //S25, S12
//		})
	
	@Test
	void testTriangleTyperS7S14() {
		int type = TriangleTyper.typer(-1, 1, 1);
		Assertions.assertEquals(4, type);
	}

	@Test
	void testTriangleTyperS7S14_2() {
		int type = TriangleTyper.typer(1, 1, -5);
		Assertions.assertEquals(4, type);
	}
	
	@Test
	void testTriangleTyperS7S14_3() {
		int type = TriangleTyper.typer(1, -5, 1);
		Assertions.assertEquals(4, type);
	}
	
	@Test
	void testTriangleTyperS4() {
		int type = TriangleTyper.typer(1001, 1, 1);
		Assertions.assertEquals(5, type);
	}
	
	@Test
	void testTriangleTyperS4_2() {
		int type = TriangleTyper.typer(1, 1, 1001);
		Assertions.assertEquals(5, type);
	}
	
	@Test
	void testTriangleTyperS4_3() {
		int type = TriangleTyper.typer(1, 1001, 1);
		Assertions.assertEquals(5, type);
	}
	
	
	@Test
	void testTriangleTyperS8S21() {
		int type = TriangleTyper.typer(3, 3, 2);
		Assertions.assertEquals(2, type);
	}
	
	@Test
	void testTriangleTyperS8S21_2() {
		int type = TriangleTyper.typer(5, 5, 12);
		Assertions.assertEquals(4, type);
	}
	
	@Test
	void testTriangleTyperS23S10() {
		int type = TriangleTyper.typer(3, 2, 3);
		Assertions.assertEquals(2, type);
	}
	
	@Test
	void testTriangleTyperS23S10_2() {
		int type = TriangleTyper.typer(5, 3, 5);
		Assertions.assertEquals(2, type);
	}
	
	@Test
	void testTriangleTyperS25S12() {
		int type = TriangleTyper.typer(2, 3, 3);
		Assertions.assertEquals(2, type);
	}
	
	@Test
	void testTriangleTyperS15() {
		int type = TriangleTyper.typer(5, 7, 1);
		Assertions.assertEquals(4, type);
	}
	
	
	@Test
	void testTriangleTyperS15_2() {
		int type = TriangleTyper.typer(5, 3, 2);
		Assertions.assertEquals(4, type);
	}
	
	@Test
	void testTriangleTyperS23S10_3() {
		int type = TriangleTyper.typer(1, 2, 1) ;
		Assertions.assertEquals(4, type);
	}
	
	@Test
	void testTriangleTyperS25S12_2() {
		int type = TriangleTyper.typer(10, 2, 2);
		Assertions.assertEquals(4, type);
	}
	
	@Test
	void testTyperthatthrowsExceptionS5() {
		Triangle t = new Triangle(3, 4, 5);
		TriangleType type = TriangleTyper.typer(t);
		Assertions.assertEquals(TriangleType.SCALENE, type); 
	}
	
	@Test
	void testTriangleTyperS15S21() {
		int type = TriangleTyper.typer(1, 2, 5);
		Assertions.assertEquals(4, type);
	}
	
	@Test
	void TyperthatthrowsExceptionS6()
	{
		Triangle t = new Triangle(3, 3, 2);
		TriangleType type = TriangleTyper.typer(t);
		Assertions.assertEquals(TriangleType.ISOSCELES, type); 
	}
	
	@Test
	void testTyperthatthrowsExceptionS7() {
		Triangle t = new Triangle(5, 5, 5);
		TriangleType type = TriangleTyper.typer(t);
		Assertions.assertEquals(TriangleType.EQUILATERAL, type); 
	}
	
	@Test
	void TyperthatthrowsExceptionS8()
	{
		Triangle t = new Triangle(1001, 1001, 1001);
		TriangleType type = TriangleTyper.typer(t);
		Assertions.assertEquals(TriangleType.OOB, type); 
	}
	@Test
	void testTyperthatthrowsExceptionS9() {
		Triangle t = new Triangle(5, 7, 1);
		TriangleType type = TriangleTyper.typer(t);
		Assertions.assertEquals(TriangleType.NOT_TRIANGLE, type); 
	}
	
	
	@Test
	void testTyperthatthrowsExceptionS2() {
		Triangle t = null;
		Throwable e = assertThrows(IllegalArgumentException.class,
							() -> { TriangleTyper.typer(t);}); //for some reason stays yellow*
		//Assertions.assertEquals(null, e.getMessage());	
	}
 //or 
/*	
	@Test
	void testTyperthatthrowsExceptionS2()
	{
		Triangle t = null;
		int was_thrown = 0;
		try
		{
			TriangleTyper.typer(t);
		}
		catch(IllegalArgumentException e)
		{
			was_thrown = 1;
		}
		Assertions.assertEquals(1, was_thrown);	
	}
	*/
	@Test
	void testsetTriangleTyperExceptionCaught()	{
		Triangle test = mock(Triangle.class);
        doThrow(new IllegalArgumentException()).when(test).setType(any(TriangleType.class));
        TriangleTyper.setTriangleType(test);
	}
	
	@Test
	void testsetTriangleTypewithoutCatching() {
		Triangle t = new Triangle(1, 1, 1);
		TriangleType type = TriangleTyper.typer(t);
		TriangleTyper.setTriangleType(t);
		Assertions.assertEquals(t.getType(), type);
	}
	
	@Test 
	void testTrinagleTyperClass() {
		TriangleTyper t = new TriangleTyper();
	}
}
