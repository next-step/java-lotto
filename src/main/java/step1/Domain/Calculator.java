package step1.Domain;

import step1.Util.NumberUtil;
import step1.Util.StringUtil;

import java.util.List;

public class Calculator {
    private List<Integer> inputValues;

    public Calculator(String inputWord) {
        List<String> inputWords = StringUtil.split(inputWord);
        this.inputValues = NumberUtil.parseUnsignedInt(inputWords);
    }

    public int sum() {
        return inputValues.stream().reduce(0, Integer::sum);
    }

}
