package ut;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.Calculator;

public class CalculatorTest {

	static Calculator cl;

	@BeforeClass
	public static void setUp() {
		cl = new Calculator();
	}

	@AfterClass
	public static void tearDown() {
		System.gc();
	}

	@Test
	public void testAdd() {

        assertEquals(3, cl.doAdd(1, 2), 0.0);
	}

	@Test
	public void testSub() {
        assertEquals(0, cl.doSub(1, 1), 0.0);
	}


	@Test
	public void testDivZero() {
		assertEquals(Double.POSITIVE_INFINITY, cl.doDiv(10, 0), 0.0);
	}
}
