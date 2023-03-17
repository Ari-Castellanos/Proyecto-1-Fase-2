package proyecto1Fase2_LISP;

import java.util.*;
import java.math.*;

public class LispInterpreter {
   public  LispInterpreter() {
	   
   }
    	Scanner scanner = new Scanner(System.in) {{

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equals("quit")) {
                break;
            }

            List<String> tokens = tokenize(input);
            Object expresion = parse(tokens);
            Object resultado = evaluar(expresion);

            System.out.println(resultado);
        }

        scanner.close();
    }

    static List<String> tokenize(String input) {
        // Implementa un token
    	 List<String> tokens = new ArrayList<>();
    	    String currentToken = "";

    	    for (int i = 0; i < input.length(); i++) {
    	        char c = input.charAt(i);

    	        if (Character.isWhitespace(c)) {
    	            if (!currentToken.isEmpty()) {
    	                tokens.add(currentToken);
    	                currentToken = "";
    	            }
    	        } else if (c == '(' || c == ')') {
    	            if (!currentToken.isEmpty()) {
    	                tokens.add(currentToken);
    	                currentToken = "";
    	            }
    	            tokens.add(String.valueOf(c));
    	        } else {
    	            currentToken += c;
    	        }
    	    }

    	    if (!currentToken.isEmpty()) {
    	        tokens.add(currentToken);
    	    }

    	    return tokens;
    }

    static Object parse(List<String> tokens) {
        if (tokens.isEmpty()) {
            return null;
        }

        String Token1 = tokens.get(0);

        if (Token1.equals("(")) {
            List<Object> list = new ArrayList<>();
            tokens.remove(0);

            while (!tokens.isEmpty() && !tokens.get(0).equals(")")) {
                Object element = parse(tokens);
                if (element != null) {
                    list.add(element);
                }
            }

            if (!tokens.isEmpty() && tokens.get(0).equals(")")) {
                tokens.remove(0);
                return list;
            } else {
                throw new RuntimeException("Parentesis no emparejado");
            }
        } else if (Token1.equals(")")) {
            throw new RuntimeException("Parentesis no emparejado");
        } else {
            try {
                return new BigDecimal(Token1);
            } catch (NumberFormatException e) {
                return Token1;
            }
        }
    }


    static Object evaluar(Object expresion, Class<BigDecimal>) {
        if (expresion == null) {
            return null;
        }

        if (expresion instanceof List) {
            List<BigInteger> list = List;

            if (list.isEmpty()) {
                return null;
            }

            Object primerelemento = list.get(0);

            if (primerelemento instanceof String) {
                String functionName = (String) primerelemento;

                if (functionName.equals("if")) {
                    if (list.size() != 4) {
                        throw new RuntimeException("Número inválido de argumentos ");
                    }

                    Object condición = evaluar(list.get(1));

                    if (condición instanceof Boolean && (Boolean) condición) {
                        return evaluar(list.get(2));
                    } else {
                        return evaluate(list.get(3));
                    }
                } else if (functionName.equals("+")) {
                    BigDecimal result = BigDecimal.ZERO;

                    for (int i = 1; i < list.size(); i++) {
                        Object argument = evaluate(list.get(i));

                        if (argument instanceof BigDecimal) {
                            result = result.add((BigDecimal) argument);
                        } else {
                            throw new RuntimeException("Argumento inválido para la suma");
                        }
                    }

                    return result;
                } else if (functionName.equals("-")) {
                    if (list.size() == 1) {
                        throw new RuntimeException("Argumento inválido para la resta");
                    }

                    BigDecimal result = evaluate(list.get(1), BigDecimal.class);

                    for (int i = 2; i < list.size(); i++) {
                        Object argument = evaluate(list.get(i));

                        if (argument instanceof BigDecimal) {
                            result = result.subtract((BigDecimal) argument);
                        } else {
                            throw new RuntimeException("Argumento inválido para la resta");
                        }
                    }

                    return result;
                } else if (functionName.equals("*")) {
                    BigDecimal result = BigDecimal.ONE;

                    for (int i = 1; i < list.size(); i++) {
                        Object argument = evaluate(list.get(i));

                        if (argument instanceof BigDecimal) {
                            result = result.multiply((BigDecimal) argument);
                        } else {
                            throw new RuntimeException("Argumento inválido para el producto");
                        }
                    }

                    return result;
                } else if (functionName.equals("/")) {
                    if (list.size() == 1) {
                        throw new RuntimeException("Argumento inválido para la división.");
                    }

                    BigDecimal result = evaluate(list.get(1), BigDecimal.class);

                    for (int i = 2; i < list.size(); i++) {
                        Object argument = evaluate(list.get(i));

                        if (argument instanceof BigDecimal) {
                            result = result.divide((BigDecimal) argument, MathContext.DECIMAL128);
                        } else {
                            throw new RuntimeException("Argumento inválido para la división");
                        }
                    }

                    return result;
                } else if (functionName.equals("=")) {
                    if (list.size() != 3) {
                        throw new RuntimeException("Número inválido de argumentos");
                    }

                    Object argument1 = evaluate(list.get(1));
                    Object argument2 = evaluate(list.get(2));

                    if (argument1 instanceof BigDecimal && argument2 instanceof BigDecimal) {
                        return ((BigDecimal) argument1).compareTo((BigDecimal) argument2) == 0;
                    } else {
                        return argument1.equals(argument2);
                    }
                } else {
                    
                    throw new RuntimeException("Function no implementada: " + functionName);
                }
            } else {
               
                Object evaluarprimerelemento = evaluar(primerelemento);
                List<Object>  ObjectList;
            }
            LispInterpreter interpreter = new LispInterpreter();
            Object result = interpreter.evaluate(interpreter.parse(interpreter.tokenize(sb.toString())));
            System.out.println(result);


}}};}
