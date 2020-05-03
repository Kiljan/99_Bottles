package prolog_lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Find_element_of_a_list {

	// Bottel 01
	public static <T> String findLastElement(List<T> list)
	{
		String resoult = null;
		List<T> mainList = list;
		
		try
		{
			resoult = mainList.stream()
					.reduce((first, second) -> second).get().toString();
		}
		catch (NoSuchElementException e)
		{
			resoult = "No such element";
		}
		
		return resoult;
	}
	
	// Bottel 02
	public static <T> String findLastButOneElement(List<T> list)
	{
		String resoult = null;
		List<T> mainList = list;
		
		try
		{
			long count = mainList.stream().count();
			Stream<T> stream = mainList.stream();
			resoult = stream.skip(count - 2).findFirst().get().toString();	
		}
		catch(IllegalArgumentException e)
		{
			resoult = "No such element";
		}
		
		return resoult;
	}
	
	// Bottle 03
	public static <T> String findThe_K_Element(List<T> list, Integer elementK) 
	{
		String resoult = null;
		
		try
		{
			resoult = list.get(elementK).toString(); 
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			resoult = "Out of Bound";
		}
		
		return resoult;
	}
	
	// Bottle 04
	public static <T> String findTheNumberOfElements(List<T> list)
	{
		String resoult = null;
		long lg = 0;
		
		lg = list.stream().count();
		resoult = lg == 0 ? "Pusto" : Long.toString(lg) ;
		
		return resoult;
	}
	
	// Bottle 05
	public static <T> List<T> reverseList(List<T> list)
	{
		List<T> resoult = list;
		Collections.reverse(resoult);
		return resoult;
	}
	
	// Bottel 06
	public static <T> boolean  ifListIsaPalindrome(List<T> list) 
	{
		int size = list.size() - 1;
		
		for(int i = 0; i < size ; i++)
		{
			T f = list.get(i);
			T s = list.get(size - i);
			
			if(f.equals(s))
				continue;
			else
				return false;
		}
		
		return true;
	}
	
	// Bottle 07 
	public static <T> List<T> flattenNestedListStructure(List<List<T>> list)
	{
		return list.stream()
				.flatMap(s -> s.stream())
				.collect(Collectors.toList());
	}
	
	// Bottle 08
	public static <T> List<T> eliminateConsecutiveDuplicates(List<T> list)
	{
		return list.stream()
				.distinct()
				.collect(Collectors.toList());
	}
	
	// Bottle 09
	public static <T> List<List<T>> packIntoSublists(List<T> list)
	{	
		// checking function
		Function<List<T>, Map<T, Integer>> checkOccurrences = x -> 
		{
			Map<T, Integer> resoult = new HashMap<>();

			for(T i : x) 
			{
					resoult.put(i, Collections.frequency(x, i));
			}
				return resoult;
		}; 
		
		Map<T, Integer> allOccurrences = checkOccurrences.apply(list);
		
		// create a packege list
		List<List<T>> packed = new ArrayList<>();
		
		for(Map.Entry<T, Integer> entry : allOccurrences.entrySet())
		{
			List<T> elements = new ArrayList<>();
			for(int i = 0; i < entry.getValue(); i++)
			{
				elements.add(entry.getKey());
			}
			packed.add(elements);
		}
		
		return packed;
	}
	
	// Bottle 10
	public static <T> List<List<String>> runListLengthEncoding(List<T> list)
	{
		// checking function
		Function<List<T>, Map<T, Integer>> checkOccurrences = x -> 
		{
			Map<T, Integer> resoult = new HashMap<>();
			for(T i : x) 
			{
				resoult.put(i, Collections.frequency(x, i));
			}
			return resoult;
		}; 
				
		Map<T, Integer> allOccurrences = checkOccurrences.apply(list);
		List<List<String>> pack = new ArrayList<>();
				
		for(Map.Entry<T, Integer> m : allOccurrences.entrySet())
		{
			List<String> element = new ArrayList<>();
			element.add(Integer.toString(m.getValue()));
			element.add((String) m.getKey());
			pack.add(element);
		}
		
		return  pack;
	}
	
	// Bottle 11 == Bottle 13
	public static <T> List<List<String>> modRunListLengthEncoding(List<T> list)
	{
		// checking function
		Function<List<T>, Map<T, Integer>> checkOccurrences = x -> 
		{
			Map<T, Integer> resoult = new HashMap<>();
			for(T i : x) 
			{
				resoult.put(i, Collections.frequency(x, i));
			}
			return resoult;
		}; 
				
		Map<T, Integer> allOccurrences = checkOccurrences.apply(list);
		List<List<String>> pack = new ArrayList<>();
				
		for(Map.Entry<T, Integer> m : allOccurrences.entrySet())
		{
			List<String> element = new ArrayList<>();
			
			if(m.getValue() > 1)
			{
				element.add(Integer.toString(m.getValue()));
				element.add((String) m.getKey());
				pack.add(element);
			}
			else
			{
				element.add((String) m.getKey());
				pack.add(element);
			}			
		}
		
		return  pack;
	}
	
	// Bottle 12
	@SuppressWarnings("unchecked")
	public static <T> List<T>  decodeRunLength(List<List<T>> list)
	{
		List<T> resoult = new ArrayList<>();
		
		for(List<T> l : list)
		{
			Integer count = Integer.parseInt((String) l.get(0));
			String value = (String) l.get(1);
			
			for(int i = 0; i < count; i++) 
			{
				resoult.add((T) value);
			}
			
		}
		return resoult;
	}
	
	// Bottle 14
	public static <T> List<T> duplicateElements(List<T> list)
	{
		List<T> resoult = (List<T>) list.stream()
				.map(x -> Collections.nCopies(2, x))
				.flatMap(x -> x.stream())
				.collect(Collectors.toList());
		
		return resoult;
	}
	
	// Bottle 15
	public static <T> List<T> duplicateElementsGivenNumberOfTimes(List<T> list, Integer repTimes)
	{
		List<T> resoult = (List<T>) list.stream()
				.map(x -> Collections.nCopies(repTimes, x))
				.flatMap(x -> x.stream())
				.collect(Collectors.toList());
		
		return resoult;
	}
	
	// Bottle 16
	// In this case a simpler solution did not require the use of streams ()
	public static <T> List<T> dropChosenElement(List<T> list, Integer elementDropped)
	{
		List<T> resoult = new ArrayList<>();
		
		for(T t : list)
		{
			if((list.indexOf(t) + 1) % elementDropped != 0)
				resoult.add(t);
		}
		
		return resoult;
	}
}












