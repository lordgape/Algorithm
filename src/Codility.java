import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

import javax.print.attribute.standard.Finishings;

public class Codility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		// Binary Gap		
//		System.out.println("Binary Gap");
//		System.out.println(binaryGap(777));
//		
//		// Odd Occurrences In Array
//		System.out.println("");
//		System.out.println("Odd Occurrences In Array");
//		int [] A = {9,3,9,3,8};
//		
//		System.out.println(oddOccurrencesInArray(A));

		// Cyclic Rotation
//		System.out.println("");
//		System.out.println("Cyclic Rotation");
//		int [] C = {3, 8, 9, 7, 6};
//		
//		System.out.println(Arrays.toString(cycliRotation(C,3)));

		// Frog Jmp
//		System.out.println("");
//		System.out.println("Frog Jmp");
//		
//		
//		System.out.println(frogJmp(5, 105, 3));

		
		// Perm Missing Elem
//		System.out.println("");
//		System.out.println("Perm Missing Elem");
//		int [] D = {1, 3, 6, 4, 1, 2};
		
		
//		System.out.println(permMissingElem(D));

		
//		// Smallest Missing Integer
//		System.out.println("");
//		System.out.println("Smallest Missing Integer");
//		int [] D1 = {-1,2};
//		
//		
//		System.out.println(smallestMissingInteger(D1));

		
		

		// Real test
//		System.out.println("");
//		System.out.println(" Real test");
//		int [] F = {0,1,2,2,3,5};
//		int [] G = {500000,500000,0,0,0,20000};
		
		
		//System.out.println(muplicatic(F,G));
		
		
//		// Tape Equilibrium
//		System.out.println("");
//		System.out.println("Tape Equilibrium");
//		int [] H = {3,1,2,4,3};
//		
//		
//		System.out.println(tapeEquilibrium(H));
		
		
		// Tape Equilibrium
		System.out.println("");
		System.out.println("Perm Check");
		int [] I = {3,1,2,4,5};
		
		
		System.out.println(PermCheck(I));
		
		
		


	}

	private static int PermCheck(int[] A) {
		
		
		Arrays.sort(A);
		
		if (A.length < 1)
			return 0;
		
		int lastValue = A[0];

		for(int i = 0; i < A.length ; i++)
		{
			if(A[i] > A.length)
				return 0;
			
			if(i > 0)
			{
				if(A[i] == lastValue)
					return 0;
			}
			
			
			lastValue = A[i];
		}
					

		return 1;
	}

	private static int tapeEquilibrium(int[] A) {
		
		// N is an integer within the range [2..100,000];
		// each element of array A is an integer within the range [−1,000..1,000].
		
		if(A.length < 2)
			return 0;
		
		int pCycle = A.length - 1;
		
		int p = 1;
		
		int smallest = 0;
		
		
		
		for(int i=0;i<pCycle; i++)
		{
			int result = computeEquilibruim(p,A) ;
						
			
			if(i > 0)
			{				
				
				if(result < smallest)
					smallest = result;
			}
			else
			{
				smallest = result;
				
			}
			
			
			p++;
			
		}
		
		
		return smallest;
	}

	private static int computeEquilibruim(int p,int [] A) {
		
		int firstPartSum = 0;
		int secondPartSum = 0;
		int pFiinalValue = p;	
		int N = A.length;
		
		while (p >= 1 )
		{
			firstPartSum+= A[p-1];
			--p;
		}

		while (N > pFiinalValue )
		{
			secondPartSum+= A[N-1];
			
			--N;
		}
		 
		return Math.abs(firstPartSum - secondPartSum); 
		 
		 
	}

	private static int muplicatic(int[] A, int[] B) {
		
		double C [] = new double[A.length];
		
		int count = 0;
		
		for(int i=0;i<A.length;i++)
		{
			C[i] = (A[i] + B[i] / 1000000.0) ;
		}
		
		for(int j=0;j<A.length;j++)
		{
			
			for(int k =1; k<A.length;k++)
			{
				
				
				
								
				System.out.println("C[j] * C[k] " + C[j] * C[k] + " C[j] + C[k] " + C[j] + C[k]);
				System.out.println(C[j] * C[k] >= C[j] + C[k]);
				
				if ( C[j] * C[k] >= C[j] + C[k] )
				{
					count++;
					
					
				}
					
			}
		}
		
		return (count > 1000000000) ? 1000000000 : count ;
	}

	private static int smallestMissingInteger(int[] A) {
		
		Arrays.sort(A);
		
		int result = 1;
		
		int count = 1;		
		
		
		if(A.length == 1)
		{
			if(A[0] != 1 && A[0] != 0)
				return 1;
			
		}
				
		System.out.println(Arrays.toString(A));
		
		for(int i = 0; i<A.length;i++)
		{
			
			if(count >= A.length)
				if(A[i] == 0)
					return 1;
				else
					return result + 1 ;
			
			if(A[i] !=A[count])
				if(A[i] + 1 != A[count]) {
					
					if(A[i] > 1)
					{
						result = A[i] + 1;
					}						
					else
					{
						result = 2;
					}
					
					System.out.println("XXXXX " + A[i]);
					
					return (result <= 0) ? 1 : result;
					
				}
					
				
			
			System.out.println("Count " + count + " result " + result  + " A[i] " + A[i]  + " index " +i);
			
			count++;
			
			
			
		}
		
		
		
		
		return (result <= 0) ? 1 : result;
	}

	private static int permMissingElem(int[] A) {

		
		Arrays.sort(A);
		int missingElement = 1;
		
		System.out.println(Arrays.toString(A));
		
		if(A.length > 0 && A[0] != 1)
			return missingElement;
		
		
		for(int i=0;i<A.length;)
		{
		
			
			
			missingElement = A[i];
			i++;
			
			missingElement++;
			
			if(i >= A.length)
				return missingElement;
			
		
			if ( missingElement != A[i] )
				return missingElement;
		}
		
		return missingElement;
	}

	private static int frogJmp(int X, int Y, int D) 
	{
		double divide = (Y - X)/(D * 1.0);
		return (int) ((divide % 1 == 0) ? divide : divide + 1);
		
	
	}

	private static int[] cycliRotation(int[] A, int K) {
		
		
		// Loop number of K times
		for(int i = 0; i < K; i++)
		{
			//Variable
			int tempStorage = 0;
			int nextCounter = 1;
			int currentCounter = 0;
			
			for(int j=0;j<A.length;j++)
			{
				if(nextCounter > A.length)
				{
					tempStorage = A[j];
					
					A[j] = A[currentCounter];
					
					A[currentCounter] = tempStorage;
					
				
				}
				else
				{
					if(j == A.length-1)
						break;
					
					
					tempStorage = A[nextCounter]; // Move the next element to a temporary storage
					
					A[nextCounter] = A[currentCounter]; // Swap the position of the next element with the first
					
					A[currentCounter] = tempStorage;			
					
					
					
				}
					
				
				nextCounter++;
					
				
			}
		}
		
		return A;
	}

	private static int oddOccurrencesInArray(int[] A) 
	{
		
			
		Arrays.sort(A);
		
		int i = 0; // currentCounter
		int j= 1;  //nextCounter
		
		for(i=0;i<A.length;)
		{
			if(j >= A.length )
				return A[i];
			
		   if(A[i] != A[j] )
			   return A[i];		   
		   
		   i = ++j; // Increment currentCounter
		   j++;		// Increment nextCounter   
		   
		}
		
		return 0;
		
	}

	private static int binaryGap(int N) {
		
		String stream = Integer.toString(N,2);
		
		int firstOccurance = stream.indexOf('1');
		
		int secondOccurance = 0;
		
		int smallestGap = 0;
		
		while(firstOccurance != -1)
		{
		
			secondOccurance = stream.indexOf('1',firstOccurance+1);
		
			if(secondOccurance != -1)
			{
				String gap = stream.substring(firstOccurance, secondOccurance);
				
				 smallestGap = (smallestGap > gap.length()-1 ) ? smallestGap : gap.length()-1 ;
			}
			
			firstOccurance = secondOccurance;
		}
		
		return (smallestGap > 0) ? smallestGap : 0;
		
	}

}
