import java.util.*;
import java.util.Vector;
import java.lang.Integer.*;
import java.util.LinkedHashSet.*;
class Mix
{
	public static int mult(int a, int b)
	{
		if(b==0)
			return 0;
		else
			return a+mult(a, b-1);
	}

	public static int mult_by2(int a)
	{
		int b=a<<1;
		return b;
	}

	public static int mult_by7(int a)
	{
		int b=(a<<3)-a;
		return b;
	}

	//	Recursive Version of Fibonacci numbers
	//	//	O(2^n)
	public static int fib(int n)
	{
		if(n<=1)
			return n;
		else
			return fib(n-1)+fib(n-2);
	}

	//	Iterative Version of Fibonacci numbers
	//	O(n)
	public static int fib1(int num)
	{
		int term1=0, term2=1, i, temp;

		if(num==0)
			return 0;
		if(num==1)
			return 1;

		for(i=2; i<=num; i++)
		{
			temp=term1;
			term1=term2;
			term2=term1+temp;
		}
		return term2;
	}


	public static void print_num_rec(int num)
	{
		if(num<0)
			return;
		else 
		{
			System.out.println(num);
			print_num_rec(num-1);
		}
	}

	static void testAssert()
	{
		int x=0, y=5;
		assert(x>y):"x is "+x+" y is "+y;
	//	System.out.println("test");
	}

	static void testMath()
	{
		double cl, fl;
		long rnd;
		int i;
		double a[]={-9, -8.8, -8.5, -8.4, -8.02, 8.02, 8.4, 8.5, 8.8, 9};

		for(i=0; i<a.length; i++) {
			rnd=Math.round(a[i]);
			cl=Math.ceil(a[i]);
			fl=Math.floor(a[i]);
			System.out.println("Math.round("+a[i]+")="+rnd+" Math.ceil("+a[i]+")="+cl+" Math.floor("+a[i]+")="+fl);
		}
		System.out.println(Math.sin(Math.toRadians(90)));
	}

	public static void Test_isPowerOf2()
	{
		double []a={2, 3, 4, 5, 8, 32, 64, 0, -1, 0.5, 0.25, 0.125, 0.0625, 0.1, -0.131, 3.14, 2.71828};
		double cl, fl, rs;
		int i;
		String str;
		// For 0, this routine returned true...
		for(i=0; i<a.length; i++)
		{
			/*
			rs=(Math.log(a[i]))/(Math.log(2));
			cl=Math.ceil(rs);
			fl=Math.floor(rs);
			if(cl==fl)
				System.out.println(a[i]+" is a power of 2!");
			*/
			if(isPowerOf2_3(a[i]))
				str=a[i]+" is a power of 2!";
			else 
				str=a[i]+" NOT a power of 2!";

		//	str=null;
		// Test only as of 5.29.18
/*
			if(is_PowerOf2((int)a[i]))
				str=a[i]+" is a power of 2!";
			else 
				str=a[i]+" NOT a power of 2!";
			System.out.println(str);
			str=null;


			if(isPowerOf2((int)a[i]))
				str=a[i]+" is a power of 2!";
			else 
				str=a[i]+" NOT a power of 2!";
				*/
			System.out.println(str);
			str=null;


		}
	}

    public static void incr(int a) { a++; }; 
    public static void test_incr()
    {
            int[] a = {2, 5}; 
            incr(a[0]); 
            System.out.println("\na[0]="+a[0]);
    }            
    
    /*  Generate truth table in reverse order.  */
    public static void bitwise()
    {
        int num, i;
    
        for(i=0; i<5; i++)
        {
            num=i;
            while(num != 0) {
            if( (num & 1) == 1)
                System.out.printf("1");
            else
                System.out.printf("0");
            num>>=1;
            }
          System.out.print("\n");
        }
    }

	public static void test_getTruthTable()
	{
		int []a={0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		StringBuffer sb=new StringBuffer();
		int i;

		for(i=0; i<a.length; i++) {
			getTruthTable(a[i], sb);
			System.out.println(a[i]+" is in binary ["+sb+"]");
		}
		sb=null; // clean up
	}
		

	// Finish ASAP
	public static void getTruthTable(int x, StringBuffer sb)
	{
		int i=0, num;
		
		// clear buffer
		if(sb.length()!=0) {
			sb.delete(0, sb.length()); 
		}

		num=x;
        	while(num != 0) {
        		if( (num & 1) == 1)
            			sb.append('1');
        		else
            			sb.append('0');
			num>>=1;
		}
		sb.reverse();
	}


	public static boolean areEqual(int a, int b)
	{
    		return  (a^b)==0;
	}


        public static void test_areEqual()
        {
                System.out.println("1 2 are equal? "+ areEqual(1,2));
	}

	public static boolean is_PowerOf2(int n)
	{
		System.out.println("A");
		if(n<=0) return false;
    		return (n==1 || (n & (n-1))==0);
	//	return ((n)&&(~(n&(n-1))));
	}


	public static boolean isPowerOf2(int num)
	{
		System.out.println("B");
		if(num<=0) return false;
    		return (num==1 || (num & (num-1))==0);
	//	return ((n)&&(~(n&(n-1))));
	}


	public static boolean isPowerOf2_3(double num)
	{
	//	System.out.println("C");
		if(num<=0) return false;
		return (num>0) && Math.ceil((Math.log(num))/(Math.log(2)))==Math.floor((Math.log(num))/(Math.log(2)));
	}

	public static void test_loop()
	{
		int i=0, j=0;

outer:
		for(i=0; i<10; i++) {
			for(j=0; j<5; j++) { // j is never incremented
				System.out.println("Hello: i="+i+" j="+j);
				continue outer;
			} // end of inner loop
			System.out.println("outer"); // never prints
		}
		System.out.print("Good-Bye: i="+i+" j="+j); // i=10, j=0
	}


	public static void decrement1(int x) 
	{
    	    System.out.println(~-x);
    	}

	public static void increment1(int x) {
       		System.out.println(-~x);
    	}


	interface AI {
			public  void f1();
			public  void f2();
		};

	class AC implements AI
	{
		public  void f1() {System.out.println("AC::f1()"); }
		public  void f2() {System.out.println("AC::f2()"); }
	}

	public static void test_AI()
	{
		
	}

	abstract class AC1 implements AI{
		public abstract void f1();
		public  abstract void f2();
	}



	// Returns x%8 without % operator
	public static int rem8(int x)
	{
		return x-8*(x>>>3);
	}



	//  Euclid's Algorithm
	int gcd(int a, int b) 
	{ 
   		return ( b == 0 ? a : gcd(b, a % b) ); 
	}

	/* Budd, "Data Structures in C++ using STL, p 55 */
	int gcd1(int m, int n)
	{
    		assert(n>0 && m>0);
    
    		while(m!=n)
    		{
        		if(n>m)
            			n=n-m;
        		else
            			m=m-n;
    		}            
    		return n;
	}

/*
    10/22/10
    Test of min and max, works OK - don't get it yet.
    
    On some rare machines where branching is very expensive and no condition move instructions exist, 
    the above expression might be faster than the obvious approach, r = (x < y) ? x : y, 
    even though it involves two more instructions. (Typically, the obvious approach is best, though.) 
    It works because if x < y, then -(x < y) will be all ones, so r = y ^ (x ^ y) & ~0 = y ^ x ^ y = x. 
    Otherwise, if x >= y, then -(x < y) will be all zeros, so r = y ^ ((x ^ y) & 0) = y. 
    On some machines, evaluating (x < y) as 0 or 1 requires a branch instruction, so there may be no advantage. 
*/
//  From recursion.cpp as of 05.14.12
        //  Find min: 
        //              r = y^((x^y) & -(x<y));
        //  Find max: 
        //              r = x^((x^y) & -(x<y));
    public static void min_max()
    {
        int x=3, y=2, r=0;
               
        r=y^((x^y) & ((-1) * (x<y?1:0)));
        System.out.printf("x = %d\ty = %d\t min(%d, %d) = %d\n", x,y,x,y,r);

        /* Find max */
        r = x^((x^y) & ((-1) * (x<y?1:0)));
        System.out.printf("x = %d\ty = %d\t max(%d, %d) = %d\n", x,y,x,y,r);
    }

	//	12.01.14
	//  Complexity:     O(n^(1/2))  Budd, p 67
	static boolean isPrime(int n)
	{
    		int i=2;
    
    		while(i*i <=n) {
        		if(n%i == 0) return false;
        		++i;
    		}
    		return true;
	}


	//	12.01.14
	static int count_divisors(int n)
	{
    		int i=1, count=0;
    
    		while(i*i<n) {
        		if(n%i == 0)    count+=2;
        		++i;
        		if(i*i == n)    ++count;
    		}
    		return count;
	}



	//	Get divisors
	static void get_divisors(int n)
	{
    	//	Vector<Integer> v=new Vector<Integer>();   // vector of divisors
		LinkedHashSet<Integer> lhs=new LinkedHashSet<Integer>();
    		int i=1, k;
    
    		while(i*i < n) {
        		k = n%i;
        		if(k == 0) {
		  	//	v.add(Integer.valueOf(i));
		  	//	v.add(Integer.valueOf(n/i));
		  		lhs.add(Integer.valueOf(i));
		  		lhs.add(Integer.valueOf(n/i));
        		}
        
        		++i;
        		if(i*i ==n)  {
		  	//	v.add(Integer.valueOf(i));
		  		lhs.add(Integer.valueOf(i));
			}
    		}

		/* 
		for(i=0;i<v.size();i++) {
			System.out.printf(v.elementAt(i).toString() + " ");
		}
		*/

		Object divisors[]=lhs.toArray();
		java.util.Arrays.sort(divisors);
		for(i=0; i<divisors.length;i++)
			System.out.printf(divisors[i] + " ");

		System.out.println("\n");


		//	Clean up
		divisors=null;
		lhs=null;
	}    
    

	public static void test_get_divisors()
	{
    		int data[]={2, 4, 12, 25, 96, 131, 360, 479};
    		int i, cnt;
   
    		System.out.println("\n\ntest_count_divisors()\n");
    		for(i=0; i<data.length;i++) {
	    		get_divisors(data[i]);
   			cnt =   count_divisors(data[i]);
        		System.out.println(data[i]+" has "+cnt +" divisors\n");
    		}
	}
	

	public static void linear_sort(int []a, int size)
	{
    		int pass, cand, temp;

    		for(pass=0; pass < size-1; pass++)
        		for(cand=pass+1; cand < size; cand++)
            		if(a[pass] > a[cand]) {
                		temp=a[pass];
                		a[pass]=a[cand];
                		a[cand]=temp;
            		}
    		return;
	}

	//  Bubble sort from Jones & Harrow book, p 547.
	public static void bubble_sort(int arr[], int n)
	{
		int i,swapped,temp;

		do {
			swapped=0;

			for(i=0;i<n-1;i++) {
				if(arr[i]>arr[i+1]) {
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
					swapped=1;
				}
			}
		} while(swapped==1);
	}

	/*  Insertion sort: O(n^2)  */
	public static void insert_sort(int data[], int no_elems)
	{
		int tmp,j,i;

		for(i=1;i<no_elems;i++) {
			tmp=data[i];
			j=i-1;
			while( (data[j]>tmp) && (j>=0) ) {
				data[j+1]=data[j];
				j--;
			}
			data[j+1]=tmp;
		}
	}

	public static int findmax(int a[], int size)
	{
		int max=a[0], find=0, i;

		for(i=1;i<size;i++)
			if(max<a[i]) {
				max=a[i];
	 			find=i;
			}
		return find;
	}

	/* Max sort: O(n^2) */
	public static void maxsort(int a[],int size)
	{
    		int indmax, temp;
		if(size==1)
			return;
		else {
			indmax=findmax(a,size);
			temp=a[size-1];
			a[size-1]=a[indmax];
			a[indmax]=temp;
			maxsort(a,size-1);
		}
	}

	/*  Selection sort: O(n^2)  */
	public static void selection_sort(int a[], int n)
	{
		int largepos,i,last, temp;

		for(last=n-1; last>0; last--) {
			largepos=0;
			for(i=1; i<=last;i++)  /* {  */
				if(a[i]>a[largepos])
					largepos=i;
	/*	if(largepos!=last) { */
			temp=a[last];
			a[last]=a[largepos];
			a[largepos]=temp;
	/*	}   */
	/*	}   */
		}
	}


	/*  Langsam, p.365           */
	public static void insertion_sort(int []x, int n)
	{
    		int i,k,y;
    
    		for(k=1; k<n; k++) {
        		y=x[k];
        		for(i=k-1; i>=0 && y<x[i]; i--)
            	 		x[i+1]=x[i];
        		x[i+1]=y;
    		}
	}    


    //  Hanoi Towers
    
    //
    //	test of Towers of Hanoi routine
    //
    //	Described in Chapter 3 of
    //	Data Structures in C++ using the STL
    //	Published by Addison-Wesley, 1997
    //	Written by Tim Budd, budd@cs.orst.edu
    //	Oregon State University
    public static void Hanoi (int n, char a, char b, char c)
    	// move n disks from tower a to tower b, using tower c
    {
    	if (n == 1) {
    			// can move smallest disk directly
    		System.out.println("Move disk from tower "+a+ " to "+b);
    		}
    	else {
    			// first move all but last disk from tower a to tower c
    		Hanoi (n-1, a, c, b);
    			// then move one disk from a to b
    		System.out.println("Move disk from tower "+a+" to "+b);
    			// then move all disks from c back to b
    		Hanoi (n-1, c, b, a);
    		}
    }
    
    public static void test_Hanoi()
    {
        Hanoi(3, 'a', 'b', 'c');
    //    Hanoi(4, 'a', 'b', 'c');
    //    Hanoi(5, 'a', 'b', 'c');
    }
    
    
    //	Swap 2 ints without 3rd parameter
    //	Only swap technique is show in this method!
    //	No actual swap is done here!
    public static void swap1(int x, int y)
    {
    	x^=y^=x^=y;
    }
    
    
    //	Swap 2 ints without 3rd parameter
    //	Only swap technique is show in this method!
    //	No actual swap is done here!
    public static void swap2(int a, int b)
    {
    	a=a+b;
    	b=a-b;
    	a=a-b;
    }
    	






	/*
	October 2010, online test from Simplex Investments
	Using %, /, +, *, how would you reverse any four-digit number in one statement?
	For example, int n = 1234; int x = (*your code here* ); printf("%d\n", x); 
	would print out 4321.

	*/
	public static void reverse_4_digit_number_in_1_line()
	{
		int n=1234, rev;
		
		rev = (((n%1000)%100)%10)*1000 + ((((n%1000)%100))/10)*100+((n%1000)/100)*10 + n/1000;  /*  4321  */
		System.out.printf("n = %d\trev = %d\n", n, rev);   
	}




	/* Clear LSB */
	public static void clearLSB(int c)
	{
		c=c&(c-1);
	}

	public static int bitSwapRequired1(int a, int b)
	{
		int c, count = 0;
		for(c=a^b; c!=0; c>>=1)
			count+= c&1;
		return count;
	}

	public static int bitSwapRequired2(int a, int b)
	{
		int c, count = 0;
		for(c=a^b; c!=0; c=c&(c-1))
			++count;
		return count;
	}

	//  Taking log2(n) - base =2. n was int in recursion.cpp
	public static int logarithmic(double n)
	{
		int result=0;
		
		while(n>1)
		{
			n=Math.floor(n/2);
			++result;
		}
		return result;
	}

	/*  Packing and unpacking of bits   */
	/* Store in 2 chars a 0<number<10000. */
	public static void test_binary()
	{
		int b[]={1111, 1234, 2222, 4567, 3333, 4444, 5555, 7777, 8888, 9999};
		char c[] = new char[3];
		int temp=0, i, p1=0, p2=0, x=0;    
		for(i=0; i<b.length; i++) {
			temp=0;
			x=0;
			
			/*  Packing */
			c[0]=(char)(b[i] / 256);
			c[1]=(char)(b[i] % 256);
			c[2]='\0';
			/*  End of Packing */

			/*  Unpacking */
			if(c[1]>=0)
				x=c[1];
			else x=256+c[1];    
			temp=256*(c[0])+x;
			System.out.printf("b[%d] = %d = %d\n", i, b[i], temp);
		}
	}
	
	//	java.lang.Integer.MAX_VALUE is an analog of INT_MAX in C++
	//  Test for an overflow
	public static boolean WillOverflow_GOOD(int x, int add) 
	{
	  // This won't overflow because "x" can't be greater than UINT_MAX
	  return (java.lang.Integer.MAX_VALUE - x) < add;
	}

	


	//	12.11.2020
//	Test for Multiplication Overflow
	public static boolean isMultOverflow(int x, int y)
	{
    		return x>(java.lang.Integer.MAX_VALUE/y);
	}

	//  03.27.15
	public static int add(int a, int b)
	{
		int sum = a^b; //   add without carrying
		int carry=(a&b)<<1;  // Carry, don't add
		
		if(b==0) return a;
		
		return add(sum, carry);
	}


	//Conversion to binary
	//	0 is not handled as of 2.22.17
	public static void convert2(int n)
	{
	 if(n>0) {
	     convert2(n/2);
	     System.out.print(n%2);
	 }
	}
	
	
	
	//	Conversion to hexadecimal
	//	0 is not handled as of 2.23.17
	public static void convert8(int n)
	{
		if(n>0) {
			convert8(n/8);
			System.out.print(n%8);
		}
	}
	
	
	
	//Conversion to hexadecimal
	//	0 is not handled as of 2.22.17
	public static void convert16(int n)
	{
	 int rem=0;
	 if(n>0) {
	     convert16(n/16);
	     rem=n%16;
	     
	     switch(rem) {
	         case 10:
	        	 System.out.print("A");
	             break;
	         case 11:
	        	 System.out.print("B");
	             break;
	         case 12:
	        	 System.out.print("C");
	             break;
	         case 13:
	        	 System.out.print("D");
	             break;
	         case 14:
	        	 System.out.print("E");
	             break;
	         case 15:
	        	 System.out.print("F");
	             break;
	         default:
	        	 System.out.print(rem);
	             break;
	     };
	 }
	}
	
	
			
	
	
	
	/*	02.08.17 */
	public static int BinarySearch(int a[], int n, int x, boolean searchFirst)
	{
		int low=0, high=n-1, result=-1, mid=0;	
	
		while(low<=high) {
			mid=(low+high)/2;
			if(a[mid]==x) {
				result=mid;
				if(searchFirst) // search for first occurence
					high=mid-1; // go search left (lower indices)
				else // search for last occurence
					low=mid+1; // go search right
	
			}
			else if(x<a[mid]) high=mid-1;
			else low=mid+1;
		}
		return result;
	}
	
	
	
	
	/*
		The C library function void *bsearch(const void *key, 
						 const void *base, 
					 	 size_t nitems, 
						 size_t size, 
						 int (*compar)(const void *, const void *)) 
		function searches an array of nitems objects, 
		the initial member of which is pointed to by base, 
		for a member that matches the object pointed to, by key. 
		The size of each member of the array is specified by size.
	
		The contents of the array should be in ascending sorted 
		order according to the comparison function referenced by compar.
	*/
	/* Binary Search, O(log(n)). Added 05.01.12
	    Jones & Harrow, p 571 */
	public static int binarySearch(int[] a, int size, int val)
	{
	    int mid, low=0, high=size-1;    
	    
	    while(low<=high) 
	    {
	        mid=(low+high)/2;
	        if(a[mid] == val) return mid; /* Value is found! */
	        else if(a[mid] > val) 
	            high=mid-1;
	        else 
	            low=mid+1;
	    }                        
	    return -1; /* Value is NOT found */
	}    




	//	03.31.17
	//	 Returns 0 if same sign, 1 as different
	public static boolean isSameSign(int x, int y)
	{
		return ((x^y)<0);
	}


	// 07.01.19
	public static boolean   isExactSquare2(int x)
    	{
	    if(x<0) return false;
	    return Math.ceil(Math.sqrt(x)) == Math.floor(Math.sqrt(x));
    	}
	


	public static boolean isExactCube(int x)
	{
	    return Math.ceil(Math.cbrt(x)) == Math.floor(Math.cbrt(x));
	}



	public static void add1(int []aa, int pos)
    {
         ++aa[pos];
    }
	public static void main(String [] args)
	{
		System.out.println("Total "+args.length+" arguments");
		int i;
//		int arr[10];	// Doesn't compile

		for(i=0; i<args.length; i++)
			System.out.println("args["+i+"]="+args[i]);
/*
		for(i=0; i<arr.length; i++)
			arr[i]=i;
*/
//		int result=mult(2,3);
//		System.out.println(result);

		//	test >>
//		System.out.println(10>>1);

		//	Test <<
//		System.out.println(mult_by2(10));
//		System.out.println(mult_by7(10));
		/*
		for(i=0; i<=5; i++)
		{
			//	Recursive Version of Fibonacci numbers
			result=fib(i);
			System.out.println("Recursion: fib("+i+")="+result);

			//	Iterative Version of Fibonacci numbers
			result=fib1(i);
			System.out.println("Iteration: fib("+i+")="+result);
		}
		*/

		//	Testing Bitwise OR
	//	System.out.println("2|1="+2|1);

		//	Testing Bitwise XOR
	//	System.out.println("3^1="+3^1);

//		double a=5/10*2.0;
//		System.out.println("5/10*2.0="+a);
/*
		char c=127;
		c=c+10;
		System.out.println(c);
*/
		/*
		int d=5;
		int b, c;

		b=d>>1;
		c=b>>2;
		System.out.println(b+" "+c);

		i=0;
		*/
		/*
		Exception ex;
		try
		{
			i++;
			ex=new Exception();
			throw ex; 
		}
		catch (Exception m)
		{
			i++;
			throw ex;
		}
		finally {
			i++;
			System.out.println(i);
		}
		*/
		//	Print number in reverse order recursively
//		print_num_rec(5);

//		test();
//
//		In for loop, i++ and ++i work identically!
	/*	System.out.println("Postfix");
		for(i=0; i<3; i++)
			System.out.println(i);

		System.out.println("Prefix");
		for(i=0; i<3; ++i)
			System.out.println(i);
	
		System.out.println("Test 2");
		for(i=-1; i<3; ++i)
			System.out.println(i);
		*/
/*		testAssert();
		testMath(); */
//		isPowerOf2(); 
//		test_loop();
//		test_incr();
//		test_AI();
//		System.out.print(rem8(9));
		
//		test_getTruthTable();

//		test_areEqual();
	
	//	Interface methods CANNOT have body
	/*
	interface T2 {
		void f() { System.out.println("T2::f()"); }
	};
	*/
	// 	test_get_divisors();
	Test_isPowerOf2();
	}
}
