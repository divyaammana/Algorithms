import java.util.*;
import java.io.*;
import java.lang.*;
public class Print {
	@SuppressWarnings({ "null", "resource" })
	static
	int[] lengths=new int[500];
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in;
		int inf = Integer.MAX_VALUE;
		ArrayList<String> words=new ArrayList<String>(100);
        int M=80;
		if (args.length > 0) {
		    File inputFile = new File(args[0]);
		    in = new Scanner(inputFile).useDelimiter("\\n+|\\s+");
		    if (args.length > 1) 
		    	M = Integer.parseInt(args[1]);
		while(in.hasNext())
			words.add(in.next());
		String[] arr1 = words.toArray(new String[0]);
		for(int k=0;k<arr1.length;k++)
			lengths[k+1]=arr1[k].length();
		int n=arr1.length;
		int[] Penalty=new int[n+1];
		int[] P=new int[n+1];
		int[][] Spaces=new int[n+1][n+1];
		Penalty[0]=0;
		for(int j=1;j<=n;j++)
		{
				Penalty[j]=inf;
			for(int i=1;i<=j;i++)
			{
				if(j==n && M-j+i-sum(i,j)>=0)
					Spaces[i][j]=0;
				else
				{
					int x=sum(i,j);
					int y=M-j+i-x;
				Spaces[i][j]=y*y*y;
				}
			    if(Penalty[i-1]!=inf && Spaces[i][j]>=0 && Penalty[j]>Penalty[i-1]+Spaces[i][j])
			    {
					Penalty[j]=Penalty[i-1]+Spaces[i][j];
					P[j]=i;
				}
			}
		}
		System.out.println(Penalty[n]);
		PrintSolution(P,n,arr1,M);
		}
	}
	private static void PrintSolution(int[] p, int n, String[] arr1, int m) {
		// TODO Auto-generated method stub
		int k=n;int count=0;
		if(p[k]==1)
		{
			System.out.print("\n");
			if(sum(p[k],k)+k-p[k]<m)
				count=m-(sum(p[k],k)+k-p[k]);
			for(int f=0;f<k;f++)
			{
				if(count>0)
				{
					System.out.print(arr1[f]+ " "+ "+");
				    count--;
				}
				else
						System.out.print(arr1[f]+ " ");
			}
			return;
		}
		else
		{
			PrintSolution(p,p[k]-1,arr1,m);
			System.out.print("\n");
			if(sum(p[k],k)+k-p[k]<m)
				count=m-(sum(p[k],k)+k-p[k]);
			if(n==arr1.length)
			{
				for(int f=p[k]-1;f<k;f++)
				System.out.print(arr1[f]+ " ");
		    }
			else
			{
				for(int f=p[k]-1;f<k;f++)
				{
					if(count>0)
					{
						System.out.print(arr1[f]+ " "+ "+");
						count--;
					}
						else
								System.out.print(arr1[f]+ " ");
				}
		    }
		}
						}
	public static int sum(int i,int j){
		int summ=0;
		if(i==j)
			return lengths[j];
		else
		{
		  for(int k=i;k<=j;k++)
			summ=summ+lengths[k];
		return summ;
	    }
	}
}

	
