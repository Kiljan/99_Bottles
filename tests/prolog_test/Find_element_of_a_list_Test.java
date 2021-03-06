package prolog_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import prolog_lists.Find_element_of_a_list;

public class Find_element_of_a_list_Test {

	private Find_element_of_a_list spy;
	
	private Boolean actual;
	private List<String> actualString;
	private List<String> exceptedString;
	private List<Integer> actualInteger;
	private List<Integer> expectedInteger;
	private List<List<String>> actualString2D;
	private List<List<String>> exceptedString2D;
	private List<List<Integer>> actualInteger2D;
	private List<List<Integer>> expectedInteger2D;
	
	private List<String> c1;
	private List<Integer> c2;
	private List<String> c3;
	private List<Integer> c4;
	private List<List<Integer>> c2c4;
	private List<String> c5;
	private List<String> c6;
	private List<String> c7;
	private List<String> empty;
		
	@Before
	public void setUp() 
	{
		spy = new Find_element_of_a_list();
		
		c1 = Arrays.asList("ala", "ma", "krowa", "cos");
		c2 = Arrays.asList(1, 2, 12, 234, 82, 23);
		c3 = Arrays.asList("x", "a", "m", "a", "x");
		c4 = Arrays.asList(1, 2, 3, 4, 4, 3, 2, 1);
		c2c4 = Arrays.asList(c2, c4);
		c5 = Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e");
		c6 = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k");
		c7 = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
		empty = new ArrayList<>();
	}
	
	// Bottel 01
	@Test
	public void find_the_last_element_of_a_list() 
	{	
		actual = spy.findLastElement(c1).equals("cos") ? true : false;
		assertTrue(actual);
		
		actual = spy.findLastElement(c2).equals("23") ? true : false;
		assertTrue(actual);
	}
	
	// Bottel 02
	@Test
	public void find_the_last_but_one_element_of_a_list() 
	{
		actual = spy.findLastButOneElement(c1).equals("krowa") ? true : false;
		assertTrue(actual);
		
		actual = spy.findLastButOneElement(c2).equals("82") ? true : false;
		assertTrue(actual);
	}
	
	// Bottel 03
	@Test
	public void find_the_K_element_of_a_list() 
	{
		actual = spy.findThe_K_Element(c1, 3).equals("cos") ? true : false;
		assertTrue(actual);
		
		actual = spy.findThe_K_Element(c1, 23).equals("Out of Bound") ? true : false;
		assertTrue(actual);
	}
	
	// Bottel 04
	@Test
	public void find_the_number_of_elements_of_a_list()
	{
		actual = spy.findTheNumberOfElements(c1).equals("4") ? true : false;
		assertTrue(actual);
		
		actual = spy.findTheNumberOfElements(empty).equals("Pusto") ? true : false;
		assertTrue(actual);	
	}
	
	// Bottel 05
	@Test
	public void reverse_a_list()
	{
		actualString = spy.reverseList(c1);
		exceptedString = Arrays.asList("cos" ,"krowa", "ma", "ala");
		assertEquals(exceptedString, actualString);
	}
	
	// Bottle 06
	@Test
	public void if_list_is_a_palindrome()
	{
		Boolean ifPalindrom = false;
		
		ifPalindrom = spy.ifListIsaPalindrome(c3);
		assertTrue(ifPalindrom);
		
		ifPalindrom = spy.ifListIsaPalindrome(c4);
		assertTrue(ifPalindrom);
	}
	
	// Bottle 07
	@Test
	public void flatten_a_nested_list_structure()
	{		
		actualInteger = spy.flattenNestedListStructure(c2c4);
		expectedInteger = Arrays.asList(1, 2, 12, 234, 82, 23, 1, 2, 3, 4, 4, 3, 2, 1);
		assertEquals(expectedInteger, actualInteger);	
	}
	
	// Bottle 08
	@Test
	public void eliminate_consecutive_duplicates_of_list_elements() 
	{
		actualInteger = spy.eliminateConsecutiveDuplicates(c4);
		expectedInteger = Arrays.asList(1, 2, 3, 4);
		assertEquals(expectedInteger, actualInteger);
	}
	
	// Bottle 09
	@Test
	public void pack_consecutive_duplicates_of_list_elements_into_sublists()
	{
		actualInteger2D = spy.packIntoSublists(c4);
		expectedInteger2D = Arrays.asList(
				Arrays.asList(1,1), Arrays.asList(2,2), 
				Arrays.asList(3,3), Arrays.asList(4,4));
		assertEquals(expectedInteger2D, actualInteger2D);
		
		actualString2D = spy.packIntoSublists(c5);
		exceptedString2D = Arrays.asList(
				Arrays.asList("a", "a", "a", "a", "a", "a"),
				Arrays.asList("b"), Arrays.asList("c", "c"), 
				Arrays.asList("d"), Arrays.asList("e", "e", "e", "e"));
		assertEquals(exceptedString2D, actualString2D);
	}
	
	// Bottle 10
	@Test
	public void run_length_encoding_of_a_list()
	{
		actualString2D = spy.runListLengthEncoding(c5);
		exceptedString2D = Arrays.asList(
				Arrays.asList("6", "a"), Arrays.asList("1", "b"), 
				Arrays.asList("2", "c"), Arrays.asList("1", "d"), 
				Arrays.asList("4", "e"));			
		assertEquals(exceptedString2D, actualString2D);
	}
	
	// Bottle 11 == Bottle 13
	@Test
	public void mod_run_length_encoding_of_a_list()
	{
		actualString2D = spy.modRunListLengthEncoding(c5);
		exceptedString2D = Arrays.asList(
				Arrays.asList("6", "a"), Arrays.asList("b"), 
				Arrays.asList("2", "c"), Arrays.asList("d"), 
				Arrays.asList("4", "e"));			
		assertEquals(exceptedString2D, actualString2D);
	}
	
	// Bottle 12
	@Test
	public void decode_a_run_length_encoded_list()
	{
		List<List<String>> prepForString =  Arrays.asList(
				Arrays.asList("6", "a"), Arrays.asList("1", "b"), 
				Arrays.asList("2", "c"), Arrays.asList("1", "d"), 
				Arrays.asList("4", "e"));
		
		actualString = spy.decodeRunLength(prepForString);
		exceptedString = Arrays.asList("a", "a", "a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e");
		assertEquals(exceptedString, actualString);
	}
	
	// Bottle 14
	@Test
	public void duplicate_the_elements_of_a_list()
	{
		actualInteger = spy.duplicateElements(c4);
		expectedInteger = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 3, 3, 2, 2, 1, 1);
		assertEquals(expectedInteger, actualInteger);
	}
	
	// Bottle 15
	@Test
	public void duplicate_the_elements_of_a_list_a_given_number_of_times()
	{
		actualInteger = spy.duplicateElementsGivenNumberOfTimes(c4, 3);
		expectedInteger = Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 3, 3, 3, 2, 2, 2, 1, 1, 1);
		assertEquals(expectedInteger, actualInteger);
	}
	
	// Bottle 16
	@Test
	public void drop_every_N_th_element_from_a_list()
	{
		actualString = spy.dropChosenElement(c1, 3);
		exceptedString = Arrays.asList("ala", "ma", "cos");
		assertEquals(exceptedString, actualString);
		
		actualInteger = spy.dropChosenElement(c4, 3);
		expectedInteger = Arrays.asList(1, 2, 4, 4, 2, 1);
		assertEquals(expectedInteger, actualInteger);
	}
	
	// Bottle 17
	@Test
	public void split_a_list_into_two_parts()
	{
		actualInteger2D = spy.splitList(c4, 3);
		expectedInteger2D = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,4,3,2,1));
		assertEquals(expectedInteger2D, actualInteger2D);
		
		List<List<Integer>> actualNull = spy.splitList(c4, 16);
		assertNull("To much elements to distinct", actualNull);
	}
	
	// Bottle 18
	@Test
	public void extract_a_slice_from_a_list()
	{
		actualString = spy.sliceList(c6, 3, 7);
		exceptedString = Arrays.asList("c", "d", "e", "f", "g");
		assertEquals(exceptedString, actualString);
	}
	
	// Bottle 19
	@Test
	public void rotate_a_list_N_places_to_the_left()
	{
		actualString = spy.rotateList(c7, 3);
		exceptedString = Arrays.asList("d", "e", "f", "g", "h", "a", "b", "c");
		assertEquals(exceptedString, actualString);
		
		actualString = spy.rotateList(c7, -2);
		exceptedString = Arrays.asList("g", "h", "a", "b", "c", "d", "e", "f");
		assertEquals(exceptedString, actualString);
	}
	
	// Bottle 20
	@Test
	public void remove_the_K_th_element_from_a_list()
	{
		actualString = spy.removeElement(c7, 3);
		exceptedString = Arrays.asList("a", "b", "c", "e", "f", "g", "h");
		assertEquals(exceptedString, actualString);
	}
	
	// Bottle 21
	@Test
	public void insert_an_element_at_a_given_position_into_a_list()
	{
		actualString = spy.insertElement(c7, "boboek", 3);
		exceptedString = Arrays.asList("a", "b", "c", "boboek" , "d", "e", "f", "g", "h");
		assertEquals(exceptedString, actualString);
	}
	
	// Bottle 22
	@Test
	public void create_a_list_containing_all_integers_within_a_given_range()
	{
		actualInteger = spy.integersWithinRange(4, 9);
		expectedInteger = Arrays.asList(4, 5, 6, 7, 8, 9);
		assertEquals(expectedInteger, actualInteger);
	}
	
	// Bottle 23 
	@Test
	public void extract_a_given_number_of_randomly_selected_elements_from_a_list()
	{
		actualString = spy.randomlySelectedElements(c1, 2);
		Boolean actualSize = actualString.size() == 2 ? true : false;
		Boolean actualContains = c1.containsAll(actualString) ? true : false;
		
		assertTrue(actualSize);
		assertTrue(actualContains);
	}
	
	// Bottle 24
	@Test
	public void lotto_Draw_N_different_random_numbers_from_the_set()
	{
		actualInteger = spy.lotto(6, 50);
		Boolean actualSize = actualInteger.size() == 6 ? true : false;
		
		assertTrue(actualSize);
	}
	
	// Bottle 25
	@Test
	public void generate_a_random_permutation_of_the_elements_of_a_list()
	{
		actualString = spy.randomPermutation(c6);
		//actualString.forEach(System.out::println);
	}
	
	// Bottle 26
	@Test
	public void generate_the_combinations_of_K_distinct_objects_chosen_from_the_N_elements_of_a_list()
	{
		actualInteger2D = spy.combinationsDistinctObjects(c2, 3);
		actualInteger2D.forEach(System.out::println);
	}
	
	// Bottle 27 and 28
		/*
		 * No simple solution exist.
		 * For now moving on.
		 * */
}