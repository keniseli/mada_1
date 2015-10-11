package mada_1;

import java.math.BigInteger;
import java.util.Random;

public class KeyGenerator {
	private BigInteger n, e;
	
	public BigInteger createBigInteger() {
		// create a BigInteger object
		BigInteger bigInt_1 = null;
		BigInteger bigInt_2 = null;
		
		// create and assign value to bitLength	
		int bitLength = 1024;
		
		// create a random object
		Random randomNumber_1 = new Random();
		Random randomNumber_2 = new Random();
		
		//create two Primzahlen
		bigInt_1 = BigInteger.probablePrime(bitLength, randomNumber_1);
		bigInt_2 = BigInteger.probablePrime(bitLength, randomNumber_2);			
		
		//create n
		n = bigInt_1.multiply(bigInt_2);
		
		return n;
	}
	
	public BigInteger getGGT(BigInteger n, BigInteger e) {
		BigInteger rest = null;
		
		while (n.compareTo(BigInteger.ZERO) != 0) {
			rest = e.mod(n);
			e = n;
			n = rest;		
		}
		return e;
	}
	
	public BigInteger defineE() {
		System.out.println(n);
		e = BigInteger.valueOf(1000);
		while (getGGT(n,e).compareTo(BigInteger.ONE) != 0) {			
		}
		return e;		
	}
	
	public String euklid() {
		//declarations
		BigInteger a, b, x0, x1, y0, y1, q, r, n, e, x0_tmp, y0_tmp;
		n = BigInteger.valueOf(144);
		e = BigInteger.valueOf(19);
		a = createBigInteger();
		b = defineE();
		x0 = BigInteger.valueOf(1);
		y0 = BigInteger.valueOf(0);
		x1 = BigInteger.valueOf(0);
		y1 = BigInteger.valueOf(1);
		String result = null;
	
		
		//euklidischer Algorithmus
		while ((b.compareTo(BigInteger.ZERO)) != 0){
			q = a.divide(b);
			r = a.mod(b);				
			a = b;
			b = r;			
			x0_tmp = x1;
			y0_tmp = y1;
			x1 = x0.subtract(q.multiply(x1));
			y1 = y0.subtract(q.multiply(y1));	
			x0 = x0_tmp;
			y0 = y0_tmp;
			
			result = String.format("(%s,%s)", x0.toString(), y0.toString());
			System.out.println(result);
		}	
		return result;
	}


}
