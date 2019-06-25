package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparateStringExtractor {

    private static final String DEFAULT_SEPARATOR_PATTERN = ":|,";

    private String separator;

    private String expression;


    public SeparateStringExtractor(String expression) {

        this.separator = DEFAULT_SEPARATOR_PATTERN;
        this.expression = expression;

        /**
         * 커스텀 구분자가 지정된 경우 구분자와 표현식 추출
         */
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);

        if(m.find()){
            /**
             * 추출된 구분자가 정규식 메타문자인 경우 발생 할 오류를 회피하기 위해 [Character class|https://docs.oracle.com/javase/tutorial/essential/regex/char_classes.html]로 만들어서 반환
             */
            separator = String.format("[%s]", m.group(1));
            this.expression = m.group(2);
        }
    }

    public String getSeparator(){
        return separator;
    }

    public String getExpression(){
        return expression;
    }
}
