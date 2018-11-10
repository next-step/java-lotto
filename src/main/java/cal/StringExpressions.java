package cal;

public class StringExpressions {
    String[] expressions;

    public StringExpressions(String[] expressions) {
        if(expressions.length <= 0){
            throw new NullPointerException("배열이 없습니다");
        }
        this.expressions = expressions;
    }

    public int getSum() {
        int result = 0;
        for (String strNumber : expressions) {
            result += parserInt(strNumber);
        }
        return result;
    }

    public static int parserInt(String strNumber) throws  NumberFormatException{
        Integer num = Integer.parseInt(strNumber.trim());

        if (num < 0) {
            throw new RuntimeException();
        }
        return num;
    }

}
