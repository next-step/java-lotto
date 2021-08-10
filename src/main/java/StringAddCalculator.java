import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {

    private List<String> numberList;

    public StringAddCalculator(String str) {
        numberList = new ArrayList<>();
        if (isVerifiableString(str)) {
            numberList = Arrays.asList(str.split(",|:"));
        }
    }

    public List<String> getNumberList() {
        return this.numberList;
    }

    public int getSum() {
        if (numberList == null) {
            return 0;
        }
        int sum = 0;
        for (String number : numberList) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private boolean isVerifiableString(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return true;
    }
}
