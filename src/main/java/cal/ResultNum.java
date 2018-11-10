package cal;

public class ResultNum {
    public static int getResult(StringExpressions expressions) {
        int result = 0;
        for (String strNumber : expressions.expressions) {
           result += parserInt(strNumber);
        }
        return result;
    }

    public static int parserInt(String strNumber) {
        int num =  Integer.parseInt(strNumber.trim());
        if(num < 0){
            throw new RuntimeException();
        }
        return num;
    }

}
