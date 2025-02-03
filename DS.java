import java.util.*;
class DS
{
	public static void main(String []args)
	{
		Stack<Integer> s=new Stack<Integer>();
		int i;
		Integer myInt=null;

		for(i=0;i<5;i++)
		{
			myInt=new Integer(i);
			s.push(myInt);
		}

		while(!s.empty())
		{
			myInt=(Integer)s.pop();
			i=myInt.intValue();
			System.out.println(i);
		}
		myInt=null;
		s=null;
	}
}
