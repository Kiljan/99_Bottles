package prolog_lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Find_element_of_a_list {

	// Bottel 01
	public <T> String findLastElement(List<T> list)
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
	public <T> String findLastButOneElement(List<T> list)
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
	public <T> String findThe_K_Element(List<T> list, Integer elementK) 
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
	public <T> String findTheNumberOfElements(List<T> list)
	{
		String resoult = null;
		long lg = 0;
		
		lg = list.stream().count();
		resoult = lg == 0 ? "Pusto" : Long.toString(lg) ;
		
		return resoult;
	}
	
	// Bottle 05
	public <T> List<T> reverseList(List<T> list)
	{
		List<T> resoult = list;
		Collections.reverse(resoult);
		return resoult;
	}
	
	// Bottel 06
	public <T> boolean  ifListIsaPalindrome(List<T> list) 
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
	public <T> List<T> flattenNestedListStructure(List<List<T>> list)
	{
		return list.stream()
				.flatMap(s -> s.stream())
				.collect(Collectors.toList());
	}
	
	// Bottle 08
	public <T> List<T> eliminateConsecutiveDuplicates(List<T> list)
	{
		return list.stream()
				.distinct()
				.collect(Collectors.toList());
	}
	
	// Bottle 09
	public <T> List<List<T>> packIntoSublists(List<T> list)
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
	public <T> List<List<String>> runListLengthEncoding(List<T> list)
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
	public <T> List<List<String>> modRunListLengthEncoding(List<T> list)
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
	public <T> List<T>  decodeRunLength(List<List<T>> list)
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
	public <T> List<T> duplicateElements(List<T> list)
	{
		List<T> resoult = (List<T>) list.stream()
				.map(x -> Collections.nCopies(2, x))
				.flatMap(x -> x.stream())
				.collect(Collectors.toList());
		
		return resoult;
	}
	
	// Bottle 15
	public <T> List<T> duplicateElementsGivenNumberOfTimes(List<T> list, Integer repTimes)
	{
		List<T> resoult = (List<T>) list.stream()
				.map(x -> Collections.nCopies(repTimes, x))
				.flatMap(x -> x.stream())
				.collect(Collectors.toList());
		
		return resoult;
	}
	
	// Bottle 16
	// In this case a simpler solution did not require the use of streams ()
	public <T> List<T> dropChosenElement(List<T> list, Integer elementDropped)
	{
		List<T> resoult = new ArrayList<>();
		
		for(T t : list)
		{
			if((list.indexOf(t) + 1) % elementDropped != 0)
				resoult.add(t);
		}
		
		return resoult;
	}
	
	// Bottle 17
	public <T> List<List<T>> splitList(List<T> list, 
			Integer lengthFirst)
	{
		if(list.size() < lengthFirst)
			return null;
		
		List<T> one = new ArrayList<>();
		List<T> two = new ArrayList<>();
		List<List<T>> resoult = new ArrayList<>();
		int count = 0;
		
		for(T t : list)
		{
			if(count < lengthFirst)
			{
				one.add(t);
				count++;
			} else
			{
				two.add(t);
			}
				
		}
		
		resoult.add(one);
		resoult.add(two);
		
		return resoult;
	}
	
	// Bottle 18
	public <T> List<T> sliceList(List<T> list,
			int start, int stop)
	{
		if(list.size() < start || list.size() < stop)
			return null;
		
		List<T> resoult = new ArrayList<>();
		int count = 1;
		
		for(T t : list)
		{
			if(count >= start && count <= stop)
				resoult.add(t);
			count++;
		}
		
		return resoult;
	}
	
	// Bottle 19
	public <T> List<T> rotateList (List<T> list, int n)
	{
		List<T> resoult = new ArrayList<>();
		resoult.addAll(list);
		int length = resoult.size() - 1;
		
		if(n > 0) 
		{
			for(int i = 0; i < n; i++)
			{
				T temp = resoult.get(0);
				
				for(int j = 0; j < length; j++)
				{
					resoult.set(j, resoult.get(j + 1));
				}
				resoult.set(length, temp);
			}
		} else if (n < 0)
		{
			for(int i = 0; i > n; i--)
			{
				T temp = resoult.get(length);
				
				for(int j = length; j > 0; j--)
				{
					resoult.set(j, resoult.get(j - 1));
				}
				resoult.set(0, temp);
			}
		} 		
		return resoult;
	}
	
	// Bottle 20
	public <T> List<T> removeElement(List<T> list, int remPos)
	{
		List<T> resoult = new LinkedList<>();
		resoult.addAll(list);
		resoult.remove(remPos);
		
		return resoult;
	}
	
	// Bottle 21
	public <T> List<T> insertElement(List<T> list, T element, int insPos)
	{
		List<T> resoult = new LinkedList<>();
		resoult.addAll(list);
		resoult.add(insPos, element);
		
		return resoult;
	}
	
	// Bottle 22
	public List<Integer> integersWithinRange (int start, int stop)
	{
		List<Integer> resoult = new ArrayList<>();
		
		for(int i = start; i <= stop; i++)
		{
			resoult.add(i);
		}
		
		return resoult;
	}
	
	// Bottle 23
	public <T> List<T> randomlySelectedElements(List<T> list, Integer num)
	{
		List<T> toShuffle = list;
		Collections.shuffle(toShuffle);
		List<T> resoult = toShuffle.stream()
							.limit(num)
							.collect(Collectors.toList());
		return resoult;
	}
	
	// Bottle 24
	public List<Integer> lotto(int numberOfnum, int maxIntValue)
	{
		List<Integer> resoult = new ArrayList<>();
		Random ran = new Random();
		
		for(int i = 0; i < numberOfnum; i++)
		{
			resoult.add(ran.nextInt(maxIntValue + 1));
		}
		return resoult;
	}
	
	// Bottle 25
	public <T> List<T> randomPermutation(List<T> list)
	{
		List<T> resoult = new ArrayList<>();
		resoult.addAll(list);
		for(int i = 0; i < 2; i++)
			Collections.shuffle(resoult);
		
		return resoult;
	}
}












