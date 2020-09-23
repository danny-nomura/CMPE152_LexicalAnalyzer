package main;

import java.io.IOException;
import java.io.*;

import lexer.Lexer;
import lexer.Token;

public class Main {

	// Added Method
   public static void readCode() throws IOException {
      // read input file
      FileInputStream inFile = null;
      try{
         inFile = new FileInputStream("codeBlock.txt");
         int a;
         while((a = inFile.read()) != -1){
            System.out.print((char)a);
         }
      }
      finally{
         if(inFile != null){
			 inFile.close();
		 }
      }

      // while not eof
         // tokenID = scan()
         // typeName = tokenID.getTypeName
         // stringContents = originalInput
         // print typeName and stringContents
         // get next token
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
