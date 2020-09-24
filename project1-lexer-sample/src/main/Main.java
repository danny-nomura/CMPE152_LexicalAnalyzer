package main;

import java.io.IOException;

import lexer.Lexer;
import lexer.Num;
import lexer.Real;
import lexer.Tag;
import lexer.Token;
import lexer.Word;

import symbols.Type;
//import symbols.Array; //not used

public class Main {

	public static void main(String[] args) throws IOException {
		Lexer lex = new Lexer();
		while(true) {
			Token tok = lex.scan();
			if(tok == null) {
				//print error message
				break;
			} else if (tok.tag == -1) {
				//tbh idk how to implement detecting EOF
				//kinda hoping it just works!
				break;
			} else {
				//print token Name and value
				//System.out.print();

				String nameValue = ""; //going to construct a string to print

				//Compare tag to determine token Name
				switch(tok.tag) {
					case Tag.AND:
						nameValue += "AND";
						break;
					case Tag.BASIC:
						nameValue += "BASE_TYPE";
						break;
					case Tag.BREAK:
						nameValue += "BREAK";
						break;
					case Tag.DO:
						nameValue += "DO";
						break;
					case Tag.ELSE:
						nameValue += "ELSE";
						break;
					case Tag.EQ:
						nameValue += "EQ";
						break;
					case Tag.FALSE:
						nameValue += "FALSE";
						break;
					case Tag.GE:
						nameValue += "GE";
						break;
					case Tag.ID:
						nameValue += "ID";
						break;
					case Tag.IF:
						nameValue += "IF";
						break;
					case Tag.INDEX:
						nameValue += "INDEX";
						break;
					case Tag.LE:
						nameValue += "LE";
						break;
					case Tag.MINUS:
						nameValue += "MINUS";
						break;
					case Tag.NE:
						nameValue += "NE";
						break;
					case Tag.NUM:
						nameValue += "NUM";
						break;
					case Tag.OR:
						nameValue += "OR";
						break;
					case Tag.REAL:
						nameValue += "REAL";
						break;
					case Tag.TEMP:
						nameValue += "TEMP";
						break;
					case Tag.TRUE:
						nameValue += "TRUE";
						break;
					case Tag.WHILE:
						nameValue += "WHILE";
						break;
					default:
						nameValue += tok.toString();
						break;
				}

				//Seperate Name and value with a tab wow
				nameValue += "\t";

				//Determine subtype of tok, then append value to nameValue
				if (tok instanceof Token) {
					nameValue += tok.toString();
				} else if (tok instanceof Num) {
					Num tmpNum = (Num) tok;
					nameValue += tmpNum.toString();
				} else if (tok instanceof Real) {
					Real tmpReal = (Real) tok;
					nameValue += tmpReal.toString();
				} else if (tok instanceof Word) {
					Word tmpWord = (Word) tok;
					nameValue += tmpWord.toString();
				} else if (tok instanceof Type) {
					Type tmpType = (Type) tok;
					nameValue += tmpType.toString();
				}

				//print nameValue to a new line
				System.out.println(nameValue);
			} //else
		} //while(true)
	}
}
