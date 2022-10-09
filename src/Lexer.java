import java.util.HashMap;
import java.util.Map;

public class Lexer {
	
	private final char[] data;
	
	private int index;
	
	private Token currentToken;
	
	private int rowIndex;
	
	private static final Map<String, TokenType> tokenMapper;
	
	
	static {
		tokenMapper = new HashMap<>();
		
		tokenMapper.put("=", TokenType.OP_PRIDRUZI);
		tokenMapper.put("+", TokenType.OP_PLUS);
		tokenMapper.put("-", TokenType.OP_MINUS);
		tokenMapper.put("*", TokenType.OP_PUTA);
		tokenMapper.put("/", TokenType.OP_DIJELI);
		tokenMapper.put("(", TokenType.L_ZAGRADA);
		tokenMapper.put(")", TokenType.D_ZAGRADA);
	}
	
    private static final Map<String, TokenType> keywordsMapper;
    
    static {
    	keywordsMapper = new HashMap<>();
    	keywordsMapper.put("za", TokenType.KR_ZA);
    	keywordsMapper.put("od", TokenType.KR_OD);
    	keywordsMapper.put("do", TokenType.KR_DO);
    	keywordsMapper.put("az", TokenType.KR_AZ);
    }
    
    private static final String comment = "//";
    
    public Lexer(String program) {
    	data = program.toCharArray();
    	index = 0;
    	rowIndex = 1;
    }
    
    public Token getCurrentToken() {
    	return currentToken;
    }
    
    public int currentRow() {
    	return rowIndex;
    }
    
    public void nextToken() {
    	extractNextToken();
    	return;
    }
    
    private void extractNextToken() {
    	//Je li kraj vec zabiljezen
    	if(currentToken != null && currentToken.tokenType == TokenType.EOF) {
    		throw new RuntimeException("EOF - kraj programa");
    	}
    	
    	//Preskoci praznine do prvog znaka
    	skipBlanks();
    	
    	//Jesmo li dosli do kraja
    	if(index>=data.length) {
    		currentToken = new Token(TokenType.EOF, null);
    		return;
    	}
    	
    	//Radi li se o komentaru
    	String tmp = "" + data[index] + data[index+1];
    	if(tmp.equals(comment)) {
    		index = index+2;
    		while(data[index] != '\n') {
    			index++;
    		}
    		index++; //Presko jos \n
    		
    		//Novi redak je naden
    		rowIndex++;
    		
    		currentToken = new Token(TokenType.COMMENT, null);
    		return;
    	}
    	
    	//Radi li je o operatorima s jednim znakom
    	TokenType tokentype = tokenMapper.get(String.valueOf(data[index]));
    	if(tokentype != null) {
    		currentToken = new Token(tokentype, String.valueOf(data[index]) );
    		index++;
    		return;
    	}
    	
    	//Provjera je li keywoard ili ident
    	if(Character.isLetter(data[index])) {
    		String builder = "";
    		
    		while(index < data.length && Character.isLetter(data[index])) {
    			builder = builder + data[index];
    			index++;
    		}
    		
    		//Provjeri je li keywoard
        	tokentype = keywordsMapper.get(builder);
        	if(tokentype != null) {
        		currentToken = new Token(tokentype, builder);
        		return;
        	}
        	  
        	//Mora biti ident inace
        	currentToken = new Token(TokenType.IDN, builder);
        	return;
    	}
    	
    	//Jos su moguci brojevi
    	if(Character.isDigit(data[index])) {
    		String builder = "";
    		
    		while(index < data.length && Character.isDigit(data[index])) {
    			builder = builder + data[index];

				index++;
    		}
    		
    		currentToken = new Token(TokenType.BROJ, builder);
    		return;
    	}
    	
    	//Nazalost nedopusteni znak
    	throw new RuntimeException("Nedopusteni znak");    	
    }
    
    
	private void skipBlanks() {
		
		while(index < data.length) {
			
			char character = data[index];
			
			if(character == ' ' || character == '\t' || character == '\r') {
				index++;
			} else if (character == '\n') {
				index++;
				rowIndex++;
			}else {
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	

}
