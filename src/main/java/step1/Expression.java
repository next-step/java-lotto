package step1;

public class Expression {
    public static final Expression EMPTY_EXPRESSION = new Expression(null); 
    public final String text;

    private Expression(final String text) {
        this.text = text;
    }
    
    public static Expression of(final String text) {
        if (StringUtils.isBlank(text)) {
            return EMPTY_EXPRESSION;
        }
        
        return new Expression(text);
    }
}
