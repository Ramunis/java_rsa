package app;

import java.math.BigInteger;
import java.util.Arrays;

public class RSAdll {
	
	static long [] openkey = new long[2]; 
	static long [] lockkey = new long[2]; 
	
	protected long message;
	protected long p;  //1.простые числа
	protected long q;  //
	
	public RSAdll()
	{
			
	}
	
	public void setmessage(long message)
	{
		this.message = message;
	}
	
	public void setp(long p)
	{
		this.p = p;
	}
	
	public void setq(long q)
	{
		this.q = q;
	}
	
	public static long[] getopenkey() 
	{
		return openkey;
	}
	
	public static long[] getlockkey() 
	{
		return lockkey;
	}
	
	public static boolean prime(long e)
	{
		if (e<2) 
		{
		return false;
		}
		
		if (e==2) 
		{
		return true;
		}
		
		double limit = Math.sqrt(e);
		
		int i=2;
		while (i <= limit)
		{
			if ((e % i)==0)
			{
				return false;
			}
			i = i+1;
		}
		return true;
	}
	
	public static long gcd(long p,long q)
	{
		if (q==0) {
			return p;
		}
		else
		{
			return gcd(q,p%q);
		}
	}
	
	public static long[] ex_gcd(long a, long b, long[] x, long[] y){

	      long gcd;
	      long[] result = new long[3];

	      if(b==0){
	          result[0] = a;
	          result[1] = x[0];
	          result[2] = y[0];
	          return result;
	      }
	      long q=a/b;
	      long tx1 = x[0]-q*x[1];
	      long ty1 = y[0]-q*y[1];
	      long[] tx = {x[1],tx1};
	      long[] ty = {y[1],ty1};
	      return ex_gcd(b,a%b,tx,ty);
	  }

	  public static long[] ex_gcd(long a, long b){
	      long[] x = {1,0};
	      long[] y = {0,1};
	      return ex_gcd(a,b,x,y);
	  }
	  
	  public static int Encrypt(long message,long e,long n)
		{
			int output = 0;
			
			output =  (int) (Math.pow(message, e)%n);
			//System.out.print("\nEncrypt:"+output);
			
			return output;
		}
		
		public static BigInteger Decrypt(long output,long d,long n)
		{
			
			BigInteger backout = new BigInteger(String.valueOf(output));
			backout = backout.pow((int) d);
			backout = backout.mod(new BigInteger(String.valueOf(n)));
			//System.out.print("\nDecrypt:"+backout);
			
			return backout;
		}
		   
		
		public static void genkeys(long p,long q) {
			// TODO Auto-generated method stub
			
			long n= p*q;  //2.умножение простых
			long c= (p-1)*(q-1); //вспомогательная переменная
			
			long e=3; // 3.простое число для (p-1)*(q-1)
			long d=0;  // 4.главное число 
			
			if (gcd(p,q)==1) // проверка простых чисел на простоту
		    {
			    if (prime(e)==true) //проверка на простоту числа е
			    {    	
			       long[] dfind = ex_gcd( c,e);  //поиск
			       d =  (dfind[2] +c);            //числа d
			       //System.out.print(d);
			    	
				   if (((e*d)%(Math.abs(c)))==1)  //проверка условия для d
				   {
					openkey[0]=e;  //5.генерация открытого и закрытого ключа
					openkey[1]=n;
					lockkey[0]=d;
					lockkey[1]=n;
					//System.out.print("\nP(A) = {"+openkey[0]+","+openkey[1]+"}, S(A) = {"+lockkey[0]+","+lockkey[1]+"}");		
				   }
				   else
				   {
					System.out.print("Error: D is not correct");
				   }
				
			    }
			    else
			    {
				System.out.print("Error: Number E is not prime");
			    }
			
			}
			else
			{
				System.out.print("Error: Number P and Q is not prime");
			}

		}
	  	

}
