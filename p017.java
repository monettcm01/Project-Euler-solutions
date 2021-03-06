/* 
 * Solution to Project Euler problem 17
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */


public final class p017 implements EulerSolution {
	
	public static void main(String[] args) {
		System.out.println(new p017().run());
	}
	
	
	public String run() {
		int sum = 0;
		for (int i = 1; i <= 1000; i++)
			sum += toEnglish(i).length();
		return Integer.toString(sum);
	}
	
	
	private static String toEnglish(int n) {
		if (n < 0 || n >= 100000)
			throw new IllegalArgumentException();
		
		if (n < 100)
			return tens(n);
		else {
			String big = "";
			if (n >= 1000) big += tens(n / 1000) + "thousand";
			if (n / 100 % 10 != 0) big += ones(n / 100 % 10) + "hundred";
			
			if (n % 100 == 0) return big;
			else return big + "and" + tens(n % 100);
		}
	}
	
	
	private static String tens(int n) {
		if (n < 0 || n >= 100)
			throw new IllegalArgumentException();
		
		if (n / 10 == 0)
			return ones(n);
		else if (n / 10 == 1) {  // Teens
			switch (n) {
				case 10:  return "ten";
				case 11:  return "eleven";
				case 12:  return "twelve";
				case 13:  return "thirteen";
				case 14:  return "fourteen";
				case 15:  return "fifteen";
				case 16:  return "sixteen";
				case 17:  return "seventeen";
				case 18:  return "eighteen";
				case 19:  return "nineteen";
				default:  throw new IllegalArgumentException();
			}
		} else {
			String tens;
			switch (n / 10) {
				case 2:  tens = "twenty";   break;
				case 3:  tens = "thirty";   break;
				case 4:  tens = "forty";    break;
				case 5:  tens = "fifty";    break;
				case 6:  tens = "sixty";    break;
				case 7:  tens = "seventy";  break;
				case 8:  tens = "eighty";   break;
				case 9:  tens = "ninety";   break;
				default:  throw new IllegalArgumentException();
			}
			if (n % 10 == 0) return tens;
			else return tens + ones(n % 10);
		}
	}
	
	
	private static String ones(int n) {
		switch (n) {
			case 0:  return "zero";
			case 1:  return "one";
			case 2:  return "two";
			case 3:  return "three";
			case 4:  return "four";
			case 5:  return "five";
			case 6:  return "six";
			case 7:  return "seven";
			case 8:  return "eight";
			case 9:  return "nine";
			default:  throw new IllegalArgumentException();
		}
	}
	
}
