package splitandsum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    public static final int FILTER_NUMBER = 1;
    public static final String FILTER_PATTERN = "//(.)\n(.*)";

    private final List<Number> numbers;
    private final NumberPattern pattern;
    private String num = "";

    public Numbers(String str) {
        this.num = str;
        this.pattern = new NumberPattern(find(str));
        this.numbers = generateNumbers(num);
    }

    public List<Number> generateNumbers(String str){
        String[] splitNumber = splitNumbers(ValidationNumber.checkNumber(str));
        List<Number> nums = new ArrayList<>();
        for(String num : splitNumber){
            nums.add(new Number(num));
        }
        return nums;
    }

    public String[] splitNumbers(String str) {
        return StringUtils.split(str, pattern.getPattern());
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }


    public String find(String number) {
        Matcher m = Pattern.compile(FILTER_PATTERN)
                .matcher(ValidationNumber.checkNumber(number));
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(FILTER_NUMBER);
            this.num = m.group(2);
        }
        return customDelimiter;
    }
}
