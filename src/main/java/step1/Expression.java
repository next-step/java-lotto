package step1;

public class Expression {
    public static final Expression EMPTY_EXPRESSION = new Expression(null); 
    private final String text;

    private Expression(final String text) {
        this.text = text;
    }
    
    public static Expression of(final String text) {
        if (StringUtils.isBlank(text)) {
            return EMPTY_EXPRESSION;
        }
        
        return new Expression(text);
    }
    
    public boolean isEmpty() {
        return this == EMPTY_EXPRESSION;
    }

    public boolean hasSingleNumber() {
        return text.length() == 1;
    }
    
    public int toInteger() {
        return Integer.parseInt(text);
    }
}
