class Outer
{
	public Outer(){}
	private int x=7;
	public void makeInner()
	{
		Inner in=new Inner();
		in.seeOuter();
	}

	public String toString()
	{
		String str="From Outer";
		return str;
	}

	class Inner
	{
		public Inner(){}
		public void seeOuter()
		{
			System.out.println("Inner::seeOuter()\nOuter x is "+x);
			System.out.println("Inner class ref is "+this);
			System.out.println("Outer class ref is "+Outer.this);

		}

		public String toString()
		{
			String str="From Inner";
			return str;
		}
	}
};

class TestInner
{
	public static void main(String []argv)
	{
		Outer.Inner inner=new Outer().new Inner();
		inner.seeOuter();
		System.out.println(inner.toString());
//		System.out.println(inner.super.toString());
	//
		Outer O1=new Outer();
		System.out.println(O1.toString());

	}
}
