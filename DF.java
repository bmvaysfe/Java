//	DF.java
//	Date format, Numbers, currencies

import java.util.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.regex.*; // For Pattern and Matcher
class DF
{
	public static void main(String []args)
	{
		// 1. Get current date + time.
		Date d=new Date();
		System.out.println("Today is "+d);

                // Create calendar
		Calendar c=Calendar.getInstance();
		Date d2=c.getTime();
		System.out.println("d2="+d2);
       
	        Locale locUS = new Locale("us");	
		DateFormat dfUS =DateFormat.getDateInstance(DateFormat.SHORT, locUS);
	//	Date usDate = dfUS.format(d);
		System.out.println("In US is: "+dfUS.format(d));
	//	System.out.println(usDate);

		// 2. Date in Germany
		Locale locGE=new Locale("de");
		DateFormat dfGE=DateFormat.getDateInstance(DateFormat.FULL, locGE);
		System.out.println("In Germany is: "+dfGE.format(d));


	 	// 3.	Date in Italy
	   	Locale locIT=new Locale("it");
		DateFormat dfIT=DateFormat.getDateInstance(DateFormat.FULL, locIT);
		System.out.println("In Italy is: "+dfIT.format(d));

		// 4. Date in Spain
		Locale locSP=new Locale("es");
		DateFormat dfSp=DateFormat.getDateInstance(DateFormat.FULL, locSP);
		System.out.println("In Spain is: "+dfSp.format(d));

		// 5. Date in France
		Locale locFR=new Locale("fr");
		DateFormat dfFR=DateFormat.getDateInstance(DateFormat.FULL, locFR);
		System.out.println("In France is: "+dfFR.format(d));

		// 6. Date in Poland
		Locale locPL=new Locale("pl");
		DateFormat dfPL=DateFormat.getDateInstance(DateFormat.FULL, locPL);
		System.out.println("In Poland is: "+dfPL.format(d));

		// 7. Date in Latvia
		Locale locLV=new Locale("lv");
		DateFormat dfLV=DateFormat.getDateInstance(DateFormat.FULL, locLV);
		System.out.println("In Latvia is: "+dfLV.format(d));

		// Working with NumberFormat class
		System.out.println("\nWorking with NumberFormat class\n");
		float f1=123.45678F;
		NumberFormat[] nfa=new NumberFormat[4];

		nfa[0]=NumberFormat.getInstance(); // Local(US)
		nfa[1]=NumberFormat.getInstance(locFR); // France
		nfa[2]=NumberFormat.getCurrencyInstance();
		nfa[3]=NumberFormat.getCurrencyInstance(locFR); //France

		for(NumberFormat nf:nfa)
			System.out.println(nf.format(f1));

		System.out.println(nfa[0].getMaximumFractionDigits()); // 3
		System.out.println(nfa[0].format(f1)); // 123.456
		nfa[0].setMaximumFractionDigits(5); // Set to 5
		System.out.println(nfa[0].format(f1)); // 123.45678

		// Parsing Section
		System.out.println("\nParsing Section\n");
		try {
			System.out.println(nfa[0].parse("3.14")); // 3.14
			nfa[0].setParseIntegerOnly(true);
			System.out.println(nfa[0].parse("3.14")); // 3
		} catch(Exception pe) {  // Compiler doesn't recognize ParseException?
			System.out.println("ParseException"); 
		}

		//	Pattern matching section
		System.out.println("\nPattern matching section\n");
		Pattern p = Pattern.compile("ab"); // expression
		Matcher m=p.matcher("abaaaba"); // source
		while(m.find()) {
		//	System.out.print(m.group()+" ");
			System.out.print(m.start()+" ");
		}
	}
}
