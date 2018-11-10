package cal;

public class StringExpressions {
    String[] expressions;

    public StringExpressions(String[] expressions) {
        if(expressions.length <= 0){
            throw new NullPointerException("배열이 없습니다");
        }
        this.expressions = expressions;
    }

}
