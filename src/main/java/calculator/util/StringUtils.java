package calculator.util;

public class StringUtils {
    public static void valid(String formula) {

        if(formula == null || formula.isBlank()){
            throw new IllegalArgumentException("null 또는 빈공백은 안된다");
        }

        //빈공백이 숫자, 사칙연산 사이에 있는지 확인
        for(int i = 0; 2 * i + 1 < formula.length(); i++){
            if(formula.charAt(2 * i + 1) != ' '){
                throw new IllegalArgumentException("빈 공백을 넣어야 함");
            }
        }
    }

    public static boolean isNumber(String part) {
        return part.matches("\\d*(\\.\\d+)?");
    }
}
