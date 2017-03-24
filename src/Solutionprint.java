import java.io.*;
import java.util.*;
public class Solutionprint {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in;
		String[] list=new String[20];
	    Integer[] length=new Integer[20];
		int M=80;
		if (args.length > 0) {
		    File inputFile = new File(args[0]);
		    in = new Scanner(inputFile).useDelimiter("\n\\s+");
		    if (args.length > 1) { 
		    	M = Integer.parseInt(args[1]);
		    }
		    int index=0;
		    while(in.hasNext()){
		    	System.out.println(in.next());
		    	list[index]=in.next();
		    	length[index]=list[index].length();
		    	index++;
		    }
		System.out.println(list[2]);
		System.out.println(length[2]);
		in.close();
		}
	}
}
