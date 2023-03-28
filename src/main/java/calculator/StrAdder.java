package calculator;

import java.util.regex.Pattern;

public class StrAdder {

    //커스텀구분자 : 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용
    //예시 :  “//;\n1;2;3”
    private static final Pattern customSeparator = Pattern.compile("//");
    //숫자체크용
    private static final Pattern number = Pattern.compile("^[0-9]+$");

    String[] parseNumbers(String numbers){

        String[] factors;
        String separator = ",|:";

        if(numbers.isEmpty()){
            return new String[]{"0"};
        }

        if(isCustomUse(numbers)){
            separator = parseCustom(numbers);
            numbers = numbers.substring(4);  //숫자시작(4)
        }

        factors = numbers.split(separator);
        return factors;
    }

    //커스컴 구분자 사용하는지 여부 matcher() 사용으로 커스텀구분자 확인
    boolean isCustomUse(String numbers){
        return customSeparator.matcher(numbers).find(); // 상수값으로 체크
    }

    String parseCustom(String numbers){
        return String.valueOf(numbers.charAt(2));
    }

    int adder(String factors) throws RuntimeException{
        if(factors == null){
            return 0;
        }

        int result = 0;
        for(String factor : parseNumbers(factors)){
            checkMinus(factor);
            result = result + Integer.parseInt(factor); // 분리한 값들 덧셈처리
        }

        return result;
    }

    private void checkMinus(String factor){
        if(factor.contains("-") || !(number.matcher(factor).find())){
            throw new RuntimeException();
        }
    }
}