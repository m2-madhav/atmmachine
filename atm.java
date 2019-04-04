import java.util.Scanner;
class Atm
{   
	static int i=0;
	static int j=0;
	int balance=20000;
	String s1[]=new String[]{"123","456","789","987","654","321","147","258","369","777"};	
	void mainMenu()
	{
		System.out.println("                   *********************");
		System.out.println("                          WELCOME    ");
		System.out.println("                        TO AXIS BANK    ");
		System.out.println("                   *********************");
		getPassword();
	}
	void getPassword()
	{
		char s2[]=System.console().readPassword("    Sir pls Enter your pin-");
		String s3=new String(s2);
		comparePassword(s3);
	}
	void comparePassword(String s3)
	{
	   if(i<2)
	   {
	     int x=0;
		for(int i=0;i<10;i++)
		{
				if(s3.equals(s1[i]))
				{
					x=1;
					withdrawMoney(s3);
					break;
			    }
				else
					continue;
		}
				
				if(x==0)
				{
					i++;
					System.out.println("       SORRY!!!!!!   INVALID PASSWORD");
					System.out.println("       Please Enter your password again");
					getPassword();
				}
	   }
				else
				{
							System.out.println("       !!!!!!!!!!! LIMIT EXCEEDED  !!!!!!!!!!!!!!!!!!!"  );
							System.out.println("             YOU HAVE ENTERED WRONG PW FOR 3 TIMES");
							System.out.println("     ************THANK YOU SIR FOR USING AXIS BANK************");
							System.out.println(" ======================================================================");
				}
	}
	void withdrawMoney(String s3)
	{
		System.out.println("           YOUR CURRENT BALANCE IS  "+balance);
		Scanner sc=new Scanner(System.in);
		System.out.println("                   Enter how much money you withdraw-");
		int amt=sc.nextInt();
		if(amt<=balance)
		{
		System.out.println("                   Your account is debited with "+amt);
		int newbalance=balance-amt;
		balance=newbalance;
		System.out.println("                   You current balance is-"+balance);
		withdrawMoreMoney(balance,s3);
		}
		else
		{
			System.out.println("  SORRY!!!!!  YOU  HAVE NOT SUFFICIENT MONEY TO WITHDRAW..........");
			withdrawMoney(s3);
		}
	}
	void withdrawMoreMoney(int balance,String s3)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("               ***Would YOU like to withdraw more MONEY***");
		System.out.println("                         yes  or   no");
		String s4="yes";
		String s5="no";
		String s6=sc.next();
		if(s6.equals(s4))
		{
					recheckPassword(s3);	
		}
	    else
		{
			System.out.println("               ***THANK YOU SIR FOR USING AXIS BANK****");
			System.out.println("================================================================================");
	    }
	}
	void recheckPassword(String s3)
	{	if(j<3)
	    {
		char s7[]=System.console().readPassword("              Sir pls Enter your pin-");
		String s8=new String(s7);
		if(s8.equals(s3))
			withdrawMoney(s3);
		else
		    {
		   System.out.println("                         ###########  WARNING ###########");
		   System.out.println("                                 WRONG PASSWORD");
			    j++;
				recheckPassword(s3);
			 }
		}
		else{
			System.out.println("                  !!!!!!!!!  OOPSS!!!!!!! SORRY    !!!!!");
			System.out.println("                 INVALID PASSWORD. MAXIMUM ATTEMPTS EXCEEDED.");
			
		}
	}
	public static void main(String ... args)
	{
		Atm a=new Atm();
		a.mainMenu();
	}
}





