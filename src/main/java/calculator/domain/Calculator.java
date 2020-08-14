package calculator.domain;

import calculator.utils.StringUtils;

import java.util.List;

public class Calculator {

    public int add(String input) {
        if(StringUtils.isBlank(input)) {
            return 0;
        }

        String delimiters = DelimiterUtils.findDelimiters(input);
        String filteredInput = DelimiterUtils.filteredStringFromDelimiter(input);
        List<String> strings = StringSplitter.split(filteredInput, delimiters);

        return Numbers.create(strings).sum();
    }
}
