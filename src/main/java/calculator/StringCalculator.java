package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // TODO :계산기 로직 수정
    //무엇인가 위의 3개의 함수가 약간씩 중복되는 행동들을 하고 있는 것으로 보입니다!.. 아래와 같은 구조를 따르면 어땟을까요? (굉장히 나이브한 생각이니 무시하여도 될것 같습니다.
    //
    //delimiter를 기본 값으로 초기화한다.
    //custom delimiter를 사용하는지 체크한다.
    //사용한다면 delimiter를 입력값으로 바꾼다.
    //사용한다면 해당 부분에서 숫자가 들어있는 부분만 추출한다. (엔터 뒤에 있는 값만..)
    //input을 delimiter를 사용하여 split 한 후 더한다.
    public int add (String text) {
        int res = 0;
        if (InputValidator.checkIsNullOrIsEmpty(text)) {
            return 0;
        }

        if(checkCustomDelimiter(text)) {
            return splitByCustomDelimiter(text);
        }
        return splitByDelimiter(text);
    }

    private boolean isOneNumber(String text) {
        String [] inputs = text.split(",|:");
        if (inputs.length == 1) {
            return true;
        }
        return false;
    }

    private boolean checkCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return true;
        }
        return false;
    }
    
    private int splitByDelimiter (String text) {
        String [] inputs = text.split(",|:");
        int res = 0;
        for (String input : inputs) {
            res += InputValidator.validatedInput(input);
        }
        return res;
    }

    private int splitByCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            int res = 0;
            for (String input : tokens) {
                res += InputValidator.validatedInput(input);
            }
            return res;
        }
        return 0;
    }

}
