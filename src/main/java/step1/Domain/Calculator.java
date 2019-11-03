package step1.Domain;

import step1.Util.NumberUtil;
import step1.Util.StringUtil;

import java.util.List;

public class Calculator {
    private List<Integer> inputValues;

    public Calculator(String inputWord) {
        List<String> inputWords = StringUtil.splitStrings(inputWord);
        this.inputValues = NumberUtil.parseUnsignedInt(inputWords);
    }

    public int getSum() {
        int sum = 0;
        for (Integer inputValue : inputValues) {
            sum += inputValue;
        }
        return sum;
    }

}
