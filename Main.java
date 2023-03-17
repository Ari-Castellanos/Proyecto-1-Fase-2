package proyecto1Fase2_LISP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
	    try (FileReader fr = new FileReader("example.txt");
	         BufferedReader br = new BufferedReader(fr)) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            sb.append(line).append("\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    LispInterpreter interpreter = new LispInterpreter();
	    Object result = interpreter.evaluate(interpreter.parse(interpreter.tokenize(sb.toString())));
	    System.out.println(result);

	}

}
