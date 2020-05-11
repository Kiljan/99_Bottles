package arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Arithmetic {
	
	// Bottle 29
	public Boolean primeNumber(int numToCheck)
	{
		return numToCheck > 1 && IntStream
				.range(2, numToCheck).noneMatch(x -> numToCheck%x == 0);
	}
	
	// Bottle 30
	public List<Integer> primeFactors(Integer checkInt)
	{
		List<Integer> resoult = new ArrayList<>();
		int ver = 1;
		
		for(int i = 1; i <= checkInt; i++)
		{
			if(checkInt % i == 0)
			{
				if(primeNumber(i))
				{
					resoult.add(i);
					ver *= i;
				}
			}
		}
		
		if(checkInt != ver) 
			resoult.add(checkInt/ver); 
		
		Collections.sort(resoult);
		
		return resoult;
	}
	
	// Bottle 31
	public List<List<Integer>> primeFactorsCount(Integer checkInt)
	{
		List<Integer> primeFactors = primeFactors(checkInt);
		List<List<Integer>> resoult = new ArrayList<>();
		
		for(Integer i : primeFactors)
		{
			List<Integer> addToList = new ArrayList<>();
			int ocur = Collections.frequency(primeFactors, i);
			addToList.add(i);
			addToList.add(ocur);
			
			if(!resoult.contains(addToList))
				resoult.add(addToList);
		}
		
		return resoult;
	}
	
	// Bottle 32
	public List<Integer> primeList(int min, int max)
	{
		List<Integer> resoult = new ArrayList<>();
		for(int i = min; i <= max; i++)
		{
			if(primeNumber(i))
				resoult.add(i);
		}
		return resoult;
	}
	
	// Bottle 33 
	/*
	 * @param	ifAll	take all prime numbers for prime sum creation
	 * */
	public List<Integer> goldbachConjecture(Boolean ifAll, int val)
	{
		List<Integer> resoult = new ArrayList<>();
		List<Integer> primeFactors = primeList(1, val);
				
		for(int i = 0; i < primeFactors.size(); i++)
		{
			int num = primeFactors.get(i);
			for(Integer j : primeFactors)
			{
				if((num + j) == val && ifAll)
				{
					resoult.add(num);
					resoult.add(j);
				} else if ((num + j) == val && !ifAll)
				{
					resoult.add(num);
					resoult.add(j);
					return resoult;
				}
			}
		}
		return resoult;
	}
	
	// Bottle 34
	public List<Integer> goldbachCompositions(int min, int max)
	{
		List<Integer> resoult = new ArrayList<>();
		List<Integer> evenNum = IntStream.range(min, max+1)
				.filter(x -> x%2 == 0)
				.boxed()
				.collect(Collectors.toList());
		
		for(Integer i : evenNum)
		{
			resoult.addAll(goldbachConjecture(false, i));
		}
		
		return resoult;
	}
	

}
