import model.OperatorFactory;

import java.nio.file.Path;
import java.util.regex.Pattern;

public class StringCalculator {
    private int result = 0;
    public final String PATTERN = "[^0-9+*/\\-/\\s]";
    public final Pattern VALIDATE_REGEXR = Pattern.compile(PATTERN);

    public final String FOUR_FUNDAMENTAL = "[+\\-*/]";
    public final Pattern FOUR_FUNDAMENTAL_VALIDATE_REGEXR = Pattern.compile(FOUR_FUNDAMENTAL);

    public int calculate(String input) {
        validateData(input);

        String[] chars = input.split(" ");

        String operator = null;
        int f = 0;
        int s = 0;
        for(String ch : chars) {
            if(FOUR_FUNDAMENTAL_VALIDATE_REGEXR.matcher(ch).find()){
                operator = ch;
                continue;
            }

            if(f == 0){
                f = Integer.parseInt(ch);
                continue;
            }

            if(s == 0){
                s = Integer.parseInt(ch);
            }


            if(f != 0 && s != 0 && operator != null){
                f = OperatorFactory.getOperator(operator).getResult(f,s);
                s=0;
                operator=null;
            }
        }

        return f;
    }



    private void validateData(String input) {
        if(input == null || input.isEmpty())
            throw new IllegalArgumentException("입력값은 null 또는 빈공백 값이 될수 없습니다. 확인해주세요.");

        if(VALIDATE_REGEXR.matcher(input).find())
            throw new IllegalArgumentException("숫자, 공백, 사측연산 기호 외의 문자가 포함되어있습니다.");
    }

    private int divide(int f, int s) {
        return f / s;
    }

    private int multiple(int f, int s) {
        return f * s;
    }

    private int minus(int f, int s) {
        return f - s;
    }

    private int plus(int f, int s) {
        return f + s;
    }

    public int getResult() {
        return result;
    }
}
