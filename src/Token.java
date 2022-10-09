
public class Token {

	TokenType tokenType;

	private Object value;

	public Token(TokenType tokenType, Object value) {

		if (tokenType == null)
			throw new IllegalArgumentException("TokenType is null");

		this.tokenType = tokenType;
		this.value = value;
	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "[tokenType=" + tokenType + ", value=" + value + "]";
	}
	
	

}
