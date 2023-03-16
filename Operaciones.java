package proyecto1Fase2_LISP;
import java.util.Arrays;

	public class Operaciones {
	    
	    public String suma(String sumandos) {
	    	//Por medio de split() se divide la cadena en un Array de String separados por espacio
	        String[] numeros = sumandos.split(" ");
	        //Se convierte el array en un stream
	        double resultado = Arrays.stream(numeros)
	        		//Se transforman a double y se opera.
	                                 .mapToDouble(n -> Double.parseDouble(n))
	                                 .sum();
	        return Double.toString(resultado);
	    }

	    public String resta(String sumandos) {
	        String[] numeros = sumandos.split(" ");
	        double resultado = Arrays.stream(numeros)
	                                 .skip(1)
	                                 .mapToDouble(n -> Double.parseDouble(n))
	                                 .sum();
	        resultado = Double.parseDouble(numeros[0]) - resultado;
	        return Double.toString(resultado);
	    }

	    public String producto(String sumandos) {
	        String[] numeros = sumandos.split(" ");
	        double resultado = Arrays.stream(numeros)
	                                 .mapToDouble(n -> Double.parseDouble(n))
	                                 .reduce(1, (a, b) -> a * b);
	        return Double.toString(resultado);
	    }

	    public String division(String sumandos) throws Exception {
	        String[] numeros = sumandos.split(" ");
	        double resultado = Arrays.stream(numeros)
	                                 .skip(1)
	                                 .mapToDouble(n -> Double.parseDouble(n))
	                                 .reduce(1, (a, b) -> {
	                                     // Verifica  que no se divida entre cero.
	                                	 if (b == 0) {
	                                         throw new ArithmeticException("Error: División entre cero.");
	                                     }
	                                     return a * b;
	                                 });
	        if (Double.parseDouble(numeros[0]) == 0) {
	            throw new ArithmeticException("Error: División entre cero.");
	        }
	        resultado = Double.parseDouble(numeros[0]) / resultado;
	        return Double.toString(resultado);
	    }
	}
	
		
	

