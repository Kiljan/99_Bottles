package arithmetic_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import arithmetic.Arithmetic;

public class Arithmetic_test 
{
	private Arithmetic ar;	
	private List<Integer> prime;
	
	private List<Integer> actual;
	private List<List<Integer>> actual2D;
	
	@Before
	public void setUp()
	{
		ar = new Arithmetic();
		prime = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 193);
	}
	
	// Bottle 29
	@Test
	public void if_number_is_a_prime()
	{	
		Boolean actual = false;
		for(Integer i : prime)
			actual = ar.primeNumber(i);
		assertTrue(actual);
		
		actual = ar.primeNumber(6);
		assertFalse(actual);
	}
	
	// Bottle 30
	@Test
	public void determine_the_prime_factors_of_a_given_positive_integer()
	{
		actual = ar.primeFactors(315);
		assertEquals(Arrays.asList(3, 3, 5, 7), actual);		
	}
	
	// Bottle 31
	@Test
	public void determine_the_prime_factors_of_a_given_positive_integer_two()
	{
		actual2D = ar.primeFactorsCount(315);
		List<List<Integer>> expected = Arrays.asList(
				Arrays.asList(3, 2),
				Arrays.asList(5, 1),
				Arrays.asList(7, 1));
		assertEquals(expected, actual2D);
	}
	
	// Bottle 32
	@Test
	public void a_list_of_prime_numbers()
	{
		actual = ar.primeList(1, 10);
		List<Integer> expected = Arrays.asList(2, 3, 5, 7);
		assertEquals(expected, actual);
	}

	// Bottle 33
	@Test
	public void goldbach_s_conjecture()
	{
		actual = ar.goldbachConjecture(false, 28);
		List<Integer> expected = Arrays.asList(5, 23);
		assertEquals(expected, actual);
	}

	// Bottle 34
	@Test
	public void a_list_of_goldbach_compositions()
	{
		actual = ar.goldbachCompositions(9, 20);
		List<Integer> expected = Arrays.asList(3,7,5,7,3,11,3,13,5,13,3,17);
		assertEquals(expected, actual);
	}
}
