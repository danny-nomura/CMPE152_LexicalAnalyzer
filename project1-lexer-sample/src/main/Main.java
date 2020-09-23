package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import lexer.Lexer;
import lexer.Token;

public class Main {

	public static void readCode() throws IOException {
		try{
			InputStream inStream = Main.class.getClassLoader().getResourceAsStream("codeBlock.txt");
			Scanner myScan = new Scanner(inStream);
			myScan.useDelimiter("\\ |\n |\t");	// tokenize at space, newline, or tab

			while(myScan.hasNext()){
				String c = myScan.next().trim();
				System.out.println(c);
			}
			myScan.close();
			inStream.close();
		}
		finally{
			System.out.print("----------\n");
		}	
	}

	public static void main(String[] args) throws IOException {
		Lexer lex = new Lexer();
	    Token t = lex.scan();
	    System.out.printf("The first token's tag is: %d", t.tag);
	    // Rather than printing the first token's tag, you need to loop
		// until EOF and output each token's type name and its actual
		// string contents (lexeme).
		System.out.write('\n');
		readCode();
	}
}
