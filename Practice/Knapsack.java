class Knapsack
{

	int[] w = new int[]{1,2,4,2,5,3,6,4,1,2,3,4,5,8,4,5,6};
	int[] v = new int[]{5,3,5,3,2,5,4,3,2,6,1,5,4,7,4,1,1};
	int[][] arr;


	public static void main(String[] args)
	{
		System.out.println("Knapsack using recursion:");
		Knapsack knapsackDPP = new Knapsack();
		knapsackDPP.init(knapsackDPP.w.length-1,10);
		System.out.println(knapsackDPP.computeKnapsackDPP(knapsackDPP.w.length-1,10));

		System.out.println("Knapsack using DPP:");
		Knapsack knapsack = new Knapsack();
		System.out.println(knapsack.computeKnapsack(knapsack.w.length-1,10));
	}

	//private int arr[][] = new int[][]

	private int computeKnapsack(int n, int cost)
	{
		int result = 0;
		if(n==0||cost==0)
		{
			result = 0;
		}
		else if(w[n]>cost)
		{
			result = computeKnapsack(n-1,cost);
		}
		else
		{
			int temp1 = computeKnapsack(n-1,cost);
			int temp2 = v[n] + computeKnapsack(n-1,cost - w[n]);
			result = max(temp1,temp2);
		}
		return result;
	}

	private void init(int n, int cost)
	{
		arr = new int[n+1][cost+1];
		for(int i=0; i<n+1; i++)
		{
			for(int j=0;j<cost+1;j++)
			{
				arr[i][j] = 11111;
			}
		}
	}

	private int computeKnapsackDPP(int n, int cost)
	{
		int result = 0;
		for(int i=0; i<n; i++)
		{
			for(int j=0;j<cost;j++)
			{
				if(arr[i][j]!=11111)
				{					
					return arr[i][j];
				}
			}
		}
		if(n==0||cost==0)
		{
			result = 0;
		}
		else if(w[n]>cost)
		{
			//result = computeKnapsack(n-1,cost);
			result = 0;
		}
		else
		{
			int temp1 = computeKnapsack(n-1,cost);
			int temp2 = v[n] + computeKnapsack(n-1,cost - w[n]);
			result = max(temp1,temp2);
		}
		arr[n][cost] = result;
		return result;
	}

	private int max(int val1, int val2)
	{
		return(val1>val2?val1:val2);
	}

}