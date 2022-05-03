package app;

import java.lang.reflect.Array;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 //
		 String str ="Hello World and zewrsa";
		 // перевод в число
		 char[] s = str.toCharArray();
		 int[] ss = new int[s.length]; //сообщение исходное
	        for (int i = 0; i < s.length; i++) {
	            ss[i]=  ((int) s[i]);
	            System.out.print("\n"+ss[i]);
	        }
		 // вывод в тест
	     char[] o = new char[ss.length]; //сообщение в цифре
	     for (int i = 0; i < ss.length; i++) {
	            o[i]=  ((char) ( ss[i]));    
	            System.out.print("\n"+o[i]);
	        }
	     //
		 int m=314;
		 int p=17;
		 int q=23;
			
		 app.RSAdll RSA = new RSAdll();
		 
         RSA.genkeys(p, q);
         long[] openkey = RSA.getopenkey();
         long[] lockkey = RSA.getlockkey();
         System.out.print("\nP(A) = {"+openkey[0]+","+openkey[1]+"}, S(A) = {"+lockkey[0]+","+lockkey[1]+"}");	
         
         long encrypt = RSA.Encrypt(m, openkey[0], openkey[1]);
         System.out.print("\nEncrypt = "+encrypt);

         System.out.print("\nEncrypt = "+RSA.Decrypt(encrypt, lockkey[0], lockkey[1]));
	}

}
