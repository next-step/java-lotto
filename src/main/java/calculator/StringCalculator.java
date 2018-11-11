package calculator;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public static int add(String expression) {
        if(StringUtils.isBlank(expression)) {
            return 0;
        }

        String[] values = Splitor.split(expression);

        return new Adder(values).getResult();
    }
}
