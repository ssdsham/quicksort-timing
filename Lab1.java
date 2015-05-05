/*Coded by Sham Dorairaj
 * Submission for CSE 5331 Autumn 2013 Lab Assignment 1
 * TrainSorting Algorithm
* Start by popping inputTrack and pushing into exitTrack.
* Compare inputTrack, sideTrack and exitTrack.
* Push/Pop such that smaller value goes to exitTrack and larger value remains on sideTrack and
*  exitTrack is always in increasing order and sideTrack is in decreasing order.
* Once inputTrack is exhausted pop all cars from sideTrack and push onto exitTrack.
 */



import java.util.Stack;

//Uncomment the following imports to use without Lab1Test JUnint. Keep StopWatch.java and RandomInputGenerator.java in build 
/*import java.util.ArrayList;
import java.util.List;
*/

public class Lab1 {
	
	/*
	 * @param inputTrack Stack of input values to sort
	 * @return Stack of values from input in sorted order
	 */

	public static Stack<Integer> trainSort(Stack<Integer> inputTrack)
	{
		//Catch Null input exception
		if(inputTrack == null){
			System.out.println("Null Value Nothing to Sort");
			System.out.println("---------------------------");
			Stack<Integer> exitTrack=new Stack<Integer>();
			
			return exitTrack;
		}
		
		//Catch Empty input exceptions
		else if (inputTrack.isEmpty()){
			System.out.println("Nothing to Sort");
			System.out.println("---------------------------");
			Stack<Integer> exitTrack=new Stack<Integer>();

			return exitTrack;
		}
		
		
		else{
		Stack<Integer> sideTrack=new Stack<Integer>();
		Stack<Integer> exitTrack=new Stack<Integer>();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		trainSort(inputTrack,sideTrack,exitTrack);		
		
		stopWatch.stop();
		System.out.print("\nOutput Track: ");
		System.out.print("[ ");
		
		for(int val: exitTrack){
			System.out.print(val+" ");
		}
		
		System.out.print("]");
		System.out.println("");
		System.out.println("\nSorting took : "+stopWatch.getElapsedTime()+" milliseconds");
		System.out.println("---------------------------");
		
			return exitTrack;
	}
	}

	//Sort Train cars on inputTrack and Put them on exitTrack in ascending order
	/*
	 * Algorithm:
	 * Start by popping inputTrack and pushing into exitTrack.
	 * Compare inputTrack, sideTrack and exitTrack.
	 * Push/Pop such that smaller value goes to exitTrack and larger value remains on sideTrack.
	 * Once inputTrack is exhausted pop all cars from sideTrack and push onto exitTrack
	 */
	private static void  trainSort(Stack<Integer> inputTrack, Stack<Integer> sideTrack, Stack<Integer> exitTrack){

		
		while(!inputTrack.isEmpty()){
			int x = 0;

			if(exitTrack.isEmpty()){
				x = inputTrack.pop();
				System.out.println("\nMove "+x +" from input to exit");
				exitTrack.push(x);	

			}else if(inputTrack.peek() >= exitTrack.peek() && sideTrack.isEmpty()  ){
				x = inputTrack.pop();
				System.out.println("\nMove "+x +" from input to exit");
				exitTrack.push(x);	

			}else if(inputTrack.peek() >= exitTrack.peek() && !sideTrack.isEmpty()){
				if(inputTrack.peek() >= sideTrack.peek()){
					x = sideTrack.pop();
					System.out.println("\nMove "+x +" from siding to exit");
					exitTrack.push(x);
				}else{
					x=inputTrack.pop();
					System.out.println("\nMove "+x +" from input to exit");
					exitTrack.push(x);	
				}

			}else if(inputTrack.peek() < exitTrack.peek() && !sideTrack.isEmpty()){
				if(inputTrack.peek() < sideTrack.peek()){
					x= exitTrack.pop();
					System.out.println("\nMove "+x +" from exit to siding");
					sideTrack.push(x);
				}

			}
			else if(inputTrack.peek() < exitTrack.peek() && sideTrack.isEmpty()){
				x= exitTrack.pop();
				System.out.println("\nMove "+x +" from exit to siding");
				sideTrack.push(x);
			}


		}
		sortSideTrack(sideTrack,exitTrack);

		

	}
    //Dump all remaining train cars from side track onto exit track. They are already sorted in the sortExitTrack function    
	public static void sortSideTrack( Stack<Integer> sideTrack, Stack<Integer> exitTrack){
		int x = 0;
		while(!sideTrack.isEmpty()){
			x = sideTrack.pop();
			System.out.println("\nMove "+x +" from siding to exit");
			exitTrack.push(x);
		}
	}
} //Remove this parenthesis to use without Lab1Test JUnint. Keep StopWatch.java and RandomInputGenerator.java in build



//Uncomment the following to use without Lab1Test JUnint. Keep StopWatch.java and RandomInputGenerator.java in build 
/*
	public static void main(String[] args) {
		List<Integer> inputList = new ArrayList<Integer>();
		inputList = RandomInputGenerator.genInTrack(100, 100);

		Stack<Integer> ipStack=new Stack<Integer>();
		for (int inp : inputList) {
			ipStack.push(inp);
		}

		System.out.println("Input track: ");
		for(int val: ipStack){
			System.out.print(val+" ");
		}

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Stack<Integer> outputStack =new Stack<Integer>();
		outputStack = trainSort(ipStack);
		
	System.out.println("\nOutput stack: ");
		for(int val: outputStack){
			System.out.print(val+" ");
		}
		
		stopWatch.stop();
		System.out.println("\nSorting took : "+stopWatch.getElapsedTime()+" milliseconds");
	}

	}
	*/