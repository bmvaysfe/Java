// CommandLine.java
// This program prints command line arguments if any.
// 01.30.11.

class CommandLine
{
	public static void f1()
	{	System.out.println("CommandLine::f1()"); }

        public static void main(String []args)
        {
                int i=0;
		f1();
                if(args.length==0) {
                        System.out.println("There is no command line arguments.");
                        System.exit(0);
                }
                else {
                        System.out.println("There are "+args.length+" command line arguments.");
                        for(;i<args.length;i++) {
                                System.out.println(i+1+". "+args[i]);
                        }
                }
        }
}
