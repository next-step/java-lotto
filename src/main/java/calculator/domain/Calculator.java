package calculator.domain;

import calculator.utils.StringUtils;

public class Calculator {

    public int add(String input) {

        if(StringUtils.isBlank(input)) {
            return 0;
        }

        String delimiters = DelimiterUtils.findDelimiters(input);

        return 0;
    }

    public int add(Numbers numbers) {
        return 0;
    }
}
