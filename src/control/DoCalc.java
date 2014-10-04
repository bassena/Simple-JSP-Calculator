package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import business.Compute;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class DoCalc
 * @author Max Bassett
 */
@WebServlet({ "/DoCalc", "/docalc" })
public class DoCalc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private double lastNum = 0;
    private String trail = "0.0";
    private double opNum = 0.0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCalc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = new PrintWriter(response.getWriter());
		Compute comp = new Compute();
		boolean hasError = false, isClearAll = false, isPowOf = false, isNaN = false;
		String preOpNum = (request.getParameter("numbers") == "" ? "0.0" : request.getParameter("numbers"));
		
		
		//First checks to see if the passed number is one.
		if(comp.isANumber(preOpNum)){
			opNum = Double.parseDouble(preOpNum);
		}else{
			response.sendRedirect("calcError.jsp?error=" + URLEncoder.encode("The entered value, " + preOpNum + ", was not a number.", "UTF-8"));
			isNaN = true;
		}
		
		//Performs division
		if(request.getParameter("operation").equals("/")){
			try{
				lastNum = comp.divide(lastNum, opNum);
			}catch(ArithmeticException e){
				hasError = true;
				response.sendRedirect("calcError.jsp?error=" + URLEncoder.encode(e.getMessage(), "UTF-8"));
			}
		}
		
		
		//Performs addition
		if(request.getParameter("operation").equals("+")){
			lastNum = comp.add(lastNum, opNum);
		}
		
		
		//Performs subtraction
		if(request.getParameter("operation").equals("-")){
			lastNum = comp.subtract(lastNum, opNum);
		}
		
		
		//Performs multiplication
		if(request.getParameter("operation").equals("x")){
			lastNum = comp.multiply(lastNum, opNum);
		}
		
		
		//Performs square
		if(request.getParameter("operation").equals("square of")){
			opNum = lastNum;
			lastNum = comp.square(lastNum);
		}
		
		
		//Performs square root
		if(request.getParameter("operation").equals("sqrt of")){
			try{
				opNum = lastNum;
				lastNum = comp.sqrt(lastNum);
			}catch(ArithmeticException e){
				hasError = true;
				response.sendRedirect("calcError.jsp?error=" + URLEncoder.encode(e.getMessage(), "UTF-8"));
			}//catch
		}
		
		//Performs exponent
		if(request.getParameter("operation").equals("xy")){
			lastNum = comp.exp(lastNum, opNum);
			trail += "<br/> to the power of " + opNum + " = " + lastNum;
			isPowOf = true;
			response.sendRedirect("calculator.jsp?trail=" + URLEncoder.encode(trail, "UTF-8"));
		}
		
		/* Resets the trail to display "0.0", and the operation variables to zero.
		 * Redirects to the previous page once the operations are done.
		 */
		if(request.getParameter("operation").equals("Clear All")){
			trail = "0.0";
			lastNum = 0;
			opNum = 0;
			isClearAll = true;
			response.sendRedirect("calculator.jsp");
		}
		
		
		//Checks for any special conditions, then updates the trail and redirects with trail as query string.
		if(!hasError && !isClearAll && !isPowOf && !isNaN){
			lastNum = comp.round(lastNum);
			opNum = comp.round(opNum);
			trail += "<br/> " + request.getParameter("operation") + " " + opNum + " = " + lastNum;
			response.sendRedirect("calculator.jsp?trail=" + URLEncoder.encode(trail, "UTF-8"));
		}
	}//doGet(HttpServletRequest, HttpServletResponse)
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
