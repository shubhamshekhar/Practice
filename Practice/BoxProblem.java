class BoxProblem
{

	int[] w = new int[]{1,2,4,2,5,3,6,4,1,2,3,4,5,8,4,5,6,1};
	int[] h = new int[]{5,3,5,3,2,5,4,3,2,6,1,5,4,7,4,1,1,4};
	int[] v = new int[]{5,3,5,3,2,5,4,3,2,6,1,5,4,7,4,1,1,2};
	int[][] arr;
	int[] temp;
	int val = 0;


	public static void main(String[] args)
	{
		BoxProblem box = new BoxProblem();
		box.temp = new int[(box.w.length-1)*(box.w.length-1)];
		System.out.println(box.findBox(box.w.length-1,35));

		int max = 0;
		for(int i=0;i<box.temp.length;i++)
		{
			System.out.print(" "+box.temp[i]);
			if (max<box.temp[i]);
				max = box.temp[i];
		}
		System.out.println();
	}

	//private int arr[][] = new int[][]

	private int findBox(int n, int width_left)
	{
		if(n>0/*||width_left==0*/)
		{
			return 0;
		}
		if(width_left==0)
		{
			/*temp[val] = max(temp1,temp2,temp3);
			val++;*/
			return 0;
		}
		int temp1 = 0;
		int temp2 = 0;
		int temp3 = 0;
		temp1 = findBox(n-1,width_left);
		if(width_left-w[n]>-1)
			temp2 = w[n]*h[n]+findBox(n-1,width_left-w[n]);
		else
			n--;
		if(width_left-h[n]>-1)
			temp3 = w[n]*h[n]+findBox(n-1,width_left-h[n]);
		else
			n--;
		if(width_left==0)
		{
			temp[val] = max(temp1,temp2,temp3);
			val++;
		}
		return max(temp1,temp2,temp3);
	}

	int max(int val1, int val2, int val3)
	{
		return (val1>val2?(val1>val3?val1:val3):(val2>val3?val2:val3));
	}

}