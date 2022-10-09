import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class LexerTest {

	public static void main(String[] args) throws IOException {
		// java -cp bin/ src/LexerTest.java
		// jar cvfe myjar.jar src/LexerTest.java bin/*.class
		// java -jar myjar.jar
		// java -cp bin/*.class src/LexerTest.java

		// Radi java -cp bin/ LexerTest
		// Radi jar cf moj.jar bin/ .
		// java -cp moj.jar LexerTest

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		String ls = System.getProperty("line.separator");
		
		line = reader.readLine();
		while (line != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
			line = reader.readLine();
		}
		
		reader.close();

		
		String output = stringBuilder.toString();
		
		
		
//		StringBuilder stringBuilder = new StringBuilder();
//		char[] buffer = new char[20];
//		while (reader.read(buffer) != -1) {
//			stringBuilder.append(new String(buffer));
//			buffer = new char[10];
//		}
//		reader.close();
//
//		String output = stringBuilder.toString();

//		String path = "C:\\Users\\filip\\Desktop\\Java\\ppj-1\\test\\test1\\test.in";
//		String input = Files.readString(Path.of(path));
////		System.out.println(input);


		Lexer lexer = new Lexer(output);
		Token token;
		int currentRow;

		while (true) {
			lexer.nextToken(); // Ima li sljedeceg
			token = lexer.getCurrentToken(); // Uzmi sljedeci
			currentRow = lexer.currentRow();

			// Jesmo li dosli do kraja
			if (token.tokenType.equals(TokenType.EOF)) {
				break;
			}

			if (token.tokenType.equals(TokenType.COMMENT)) {
				continue;
			}

			System.out.print(token.getTokenType() + " " + currentRow + " " + token.getValue() + "\n");
			// Nismo na kraju i nesto je nasao

		}

	}

}
