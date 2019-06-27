package common;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionSplitter {

    private static final String DEFAULT_SEPARATOR_PATTERN = ":|,";

    private static final String CUSTOM_SEPARATOR_EX_PATTERN = "//(.)\n(.*)";

    private static final int INDEX_OF_EXTRACTED_SEPARATOR = 1;

    private static final int INDEX_OF_EXTRACTED_EXPRESSION = 2;

    private static final String CHAR_CLASS_WRAPPING_FORMAT = "[%s]";

    private String separator;

    private String expression;


    public ExpressionSplitter(String expression) {

        this.separator = DEFAULT_SEPARATOR_PATTERN;
        this.expression = Optional.ofNullable(expression).orElse("");

        this.extractCustomSeparator();
    }

    private void extractCustomSeparator(){
        /**
         * 커스텀 구분자가 지정된 경우 구분자와 표현식 추출
         */
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_EX_PATTERN).matcher(this.expression);

        if(m.find()){
            /**
             * 추출된 구분자가 정규식 메타문자인 경우 발생 할 오류를 회피하기 위해
             * [Character class|https://docs.oracle.com/javase/tutorial/essential/regex/char_classes.html]로 만들어서 반환
             */
            this.separator = String.format(CHAR_CLASS_WRAPPING_FORMAT, m.group(INDEX_OF_EXTRACTED_SEPARATOR));
            this.expression = m.group(INDEX_OF_EXTRACTED_EXPRESSION);
        }
    }


    public String[] split() {
        return expression.trim().split(separator);
    }
}
