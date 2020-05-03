package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import prolog_lists.Find_element_of_a_list;

public class Find_element_of_a_list_Test {

	private List<String> l1;
	private List<Integer> l2;
	private List<String> l3;
	private List<Integer> l4;
	private List<Integer> l4c;
	private List<Integer> l4cc;
	private List<String> l5;
	private List<String> l6;
	private List<List<Integer>> combinel2l4;
	private List<String> empty;
	
	private String actual;
	
		
	@Before
	public void setUp() 
	{
		l1 = Arrays.asList("ala", "ma", "krowa", "cos");
		l2 = Arrays.asList(1, 2, 12, 234, 82, 23);
		l3 = Arrays.asList("x", "a", "m", "a", "x");
		l4 = Arrays.asList(1, 2, 3, 4, 4, 3, 2, 1);
		l4c = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 3, 3, 2, 2, 1, 1);
		l4c = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 3, 3, 2, 2, 1, 1);
		l4cc = Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 3, 3, 3, 2, 2, 2, 1, 1, 1);
		l5 = Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e");
		l6 = Arrays.asList("a", "a", "a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e");
		
		combinel2l4 = Arrays.asList(l2, l4);
		
		empty = new ArrayList<>();
	}
	
	// Bottel 01
	@Test
	public void find_the_last_element_of_a_list() 
	{		
		actual = Find_element_of_a_list.findLastElement(l1);
		assertEquals("cos", actual);
		
		actual = Find_element_of_a_list.findLastElement(l2);
		assertEquals(Integer.toString(23), actual);
		
		actual = Find_element_of_a_list.findLastElement(empty);
		assertEquals("No such element", actual);
		
	}
	
	// Bottel 02
	@Test
	public void find_the_last_but_one_element_of_a_list() 
	{
		actual = Find_element_of_a_list.findLastButOneElement(l1);
		assertEquals("krowa", actual);
		
		actual = Find_element_of_a_list.findLastButOneElement(l2);
		assertEquals(Integer.toString(82), actual);
		
		actual = Find_element_of_a_list.findLastButOneElement(empty);
		assertEquals("No such element", actual);
	}
	
	// Bottel 03
	@Test
	public void find_the_K_element_of_a_list() 
	{
		actual = Find_element_of_a_list.findThe_K_Element(l1, 3);
		assertEquals("cos", actual);
		
		actual = Find_element_of_a_list.findThe_K_Element(l1, 23);
		assertEquals("Out of Bound", actual);
	}
	
	// Bottel 04
	@Test
	public void find_the_number_of_elements_of_a_list()
	{
		actual = Find_element_of_a_list.findTheNumberOfElements(l1);
		assertEquals("4", actual);
		
		actual = Find_element_of_a_list.findTheNumberOfElements(empty);
		assertEquals("Pusto", actual);		
	}
	
	// Bottel 05
	@Test
	public void reverse_a_list()
	{
		List<String> expected = Arrays.asList("cos" ,"krowa", "ma", "ala");
		List<String> actual = Find_element_of_a_list.reverseList(l1);
		
		assertEquals(expected, actual);
	}
	
	// Bottle 06
	@Test
	public void if_list_is_a_palindrome()
	{
		Boolean ifPalindrom = false;
		
		ifPalindrom = Find_element_of_a_list.ifListIsaPalindrome(l3);
		assertTrue(ifPalindrom);
		
		ifPalindrom = Find_element_of_a_list.ifListIsaPalindrome(l4);
		assertTrue(ifPalindrom);
	}
	
	// Bottle 07
	@Test
	public void flatten_a_nested_list_structure()
	{		
		List<Integer> expected = Arrays.asList(1, 2, 12, 234, 82, 23, 1, 2, 3, 4, 4, 3, 2, 1);
		List<Integer> actual = Find_element_of_a_list.flattenNestedListStructure(combinel2l4);
		
		assertEquals(expected, actual);	
	}
	
	// Bottle 08
	@Test
	public void eliminate_consecutive_duplicates_of_list_elements() 
	{
		List<Integer> expected = Arrays.asList(1, 2, 3, 4);
		List<Integer> actual = Find_element_of_a_list.eliminateConsecutiveDuplicates(l4);
		
		assertEquals(expected, actual);
	}
	
	// Bottle 09
	@Test
	public void pack_consecutive_duplicates_of_list_elements_into_sublists()
	{
		List<List<Integer>> expectedInteger = Arrays.asList(Arrays.asList(1,1), Arrays.asList(2,2), Arrays.asList(3,3), Arrays.asList(4,4));
		List<List<Integer>> actualInteger = Find_element_of_a_list.packIntoSublists(l4);
		
		assertEquals(expectedInteger, actualInteger);
		
		List<List<String>> expected = Arrays.asList(Arrays.asList("a", "a", "a", "a", "a", "a"), 
					Arrays.asList("b"), Arrays.asList("c", "c"), Arrays.asList("d"), Arrays.asList("e", "e", "e", "e"));
		List<List<String>> actualString = Find_element_of_a_list.packIntoSublists(l5);
		
		assertEquals(expected, actualString);
	}
	
	// Bottle 10
	@Test
	public void run_length_encoding_of_a_list()
	{
		List<List<String>> expected = Arrays.asList(Arrays.asList("6", "a"), Arrays.asList("1", "b"), 
				Arrays.asList("2", "c"), Arrays.asList("1", "d"), Arrays.asList("4", "e"));			
		List<List<String>> actualString = Find_element_of_a_list.runListLengthEncoding(l5);
		
		assertEquals(expected, actualString);
	}
	
	// Bottle 11 == Bottle 13
	@Test
	public void mod_run_length_encoding_of_a_list()
	{
		List<List<String>> expected = Arrays.asList(Arrays.asList("6", "a"), Arrays.asList("b"), 
				Arrays.asList("2", "c"), Arrays.asList("d"), Arrays.asList("4", "e"));			
		List<List<String>> actualString = Find_element_of_a_list.modRunListLengthEncoding(l5);
		
		assertEquals(expected, actualString);
	}
	
	// Bottle 12
	@Test
	public void decode_a_run_length_encoded_list()
	{
		List<List<String>> prepForString =  Arrays.asList(Arrays.asList("6", "a"), Arrays.asList("1", "b"), 
				Arrays.asList("2", "c"), Arrays.asList("1", "d"), Arrays.asList("4", "e"));
		
		List<String> expected =  l6;
		
		List<String> actualString = Find_element_of_a_list.decodeRunLength(prepForString);
		
		assertEquals(expected, actualString);
	}
	
	// Bottle 14
	@Test
	public void duplicate_the_elements_of_a_list()
	{
		List<Integer> expected = l4c;
		List<Integer> actualInteger = Find_element_of_a_list.duplicateElements(l4);
		assertEquals(expected, actualInteger);
	}
	
	// Bottle 15
	@Test
	public void duplicate_the_elements_of_a_list_a_given_number_of_times()
	{
		List<Integer> expected = l4cc;
		List<Integer> actualInteger = Find_element_of_a_list.duplicateElementsGivenNumberOfTimes(l4, 3);
		assertEquals(expected, actualInteger);
	}
	
	// Bottle 16
	@Test
	public void drop_every_N_th_element_from_a_list()
	{
		List<String> expectedString = Arrays.asList("ala", "ma", "cos");
		List<String> actualString = Find_element_of_a_list.dropChosenElement(l1, 3);
		
		assertEquals(expectedString, actualString);
			
		List<Integer> expectedInteger = Arrays.asList(1, 2, 4, 4, 2, 1);
		List<Integer> actualInteger = Find_element_of_a_list.dropChosenElement(l4, 3);
		
		assertEquals(expectedInteger, actualInteger);
	}
}
