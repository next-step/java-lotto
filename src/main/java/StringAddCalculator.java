import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final List<String> delimiterList;
    private List<String> numberList;

    public StringAddCalculator(String str) {
        numberList = new ArrayList<>();
        delimiterList = new ArrayList<>(Arrays.asList(",", ":"));

        if (stringValidater(str)) {
            str = setCustomDelimiter(str);
            numberList = Arrays.asList(str.split(getStringifyDelimiter()));
        }
    }

    public List<String> getNumberList() {
        return this.numberList;
    }

    public int getSum() {
        int sum = 0;

        if (numberList == null) {
            return 0;
        }

        for (String number : numberList) {
            numberValidator(number);
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private void numberValidator(String str) {
        List<String> possibleNumberList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9",
            "0");

        if (!possibleNumberList.contains(str)) {
            throw new RuntimeException();
        }
    }

    private boolean stringValidater(String str) {
        return str != null && !str.equals("");
    }

    private String getStringifyDelimiter() {
        return String.join("|", delimiterList);
    }

    private String setCustomDelimiter(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);

        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiterList.add(customDelimiter);
            return m.group(2);
        }

        return str;
    }
}
