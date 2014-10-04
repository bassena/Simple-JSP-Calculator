package business;

/**
 * @author Max Bassett
 */
public class Compute {
	
	public double add(double fNum, double sNum){
		return fNum + sNum;
	}//add(double, double)
	
	public double subtract(double fNum, double sNum){
		return fNum - sNum;
	}//substract(double, double)
	
	public double multiply(double fNum, double sNum){
		return fNum * sNum;
	}//multiply(double, double)
	
	public double divide(double fNum, double sNum){
		
		if(sNum == 0)
			throw new ArithmeticException("Cannot divide by zero.");
		else
			return fNum / sNum;
	}//divide(double, double)
	
	public double square(double fNum){
		return Math.pow(fNum, 2);
	}//square(double)
	
	public double sqrt(double fNum){
		if(fNum < 0)
			throw new ArithmeticException("Cannot square root a negative number.");
		else
			return Math.sqrt(fNum);
	}//sqrt(double)
	
	public double exp(double num1, double num2){
		return Math.pow(num1, num2);
	}//exp(double, double)
	
	public boolean isANumber(String num){
		try{
			double dummyNum = Double.parseDouble(num);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}//isANumber(String)
	
	public double round(double num){
		return Math.round(num * 100000.0) / 100000.0;
	}//round(double)
}//Compute class
