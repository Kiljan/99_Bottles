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
	
	// Bottle 35
	public Integer greatest_common_divisor(int f, int s) 
	{
		List<Integer> firstCollect = new ArrayList<>();
		List<Integer> secondCollect = new ArrayList<>();
		List<Integer> resoults = new ArrayList<>();
		Integer greatest;
		
		firstCollect = IntStream
				.range(1, f + 1)
				.filter(x -> f%x == 0)
				.boxed()
				.collect(Collectors.toList());
		
		secondCollect = IntStream
				.range(1, s + 1)
				.filter(x -> s%x == 0)
				.boxed()
				.collect(Collectors.toList());
		
		resoults = firstCollect.stream()
				.distinct()
				.filter(secondCollect::contains)
				.collect(Collectors.toList());
		
		greatest = resoults.stream()
				.max(Integer::compare)
				.get();
		
		return greatest;
	}
	
	//Bottel 36
	public Boolean coprime(int f, int s)
	{
		List<Integer> firstCollect = new ArrayList<>();
		List<Integer> secondCollect = new ArrayList<>();
		List<Integer> resoults = new ArrayList<>();
		Boolean coprime = false;
		
		firstCollect = IntStream
				.range(1, f+1)
				.filter(x -> f%x == 0)
				.boxed()
				.collect(Collectors.toList());
		
		secondCollect = IntStream
				.range(1, s+1)
				.filter(x -> s%x ==0 )
				.boxed()
				.collect(Collectors.toList());
		
		resoults = firstCollect.stream()
				.distinct()
				.filter(secondCollect::contains)
				.collect(Collectors.toList());
		
		if(resoults.size() == 1 && resoults.get(0).equals(1))
		{
			coprime = true;
		}
		
		return coprime;
	}
	
	// Bottle 37 and 38 and 39
	public Integer eulerTotientFunction(int m)
	{
		if(m == 1)
			return 1;
		
		List<Integer> areCoprime = new ArrayList<>();
		Integer resoult = 1;
		
		for(int i = 0; i < m; i++)
		{
			if(coprime(i, m))
			{
				areCoprime.add(i);
			}
		}
		
		resoult = (int) areCoprime.stream()
				.count();
		
		return resoult;
	}
}
