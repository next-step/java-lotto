package calculator.domain;

import calculator.util.ValidUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitTextNum {
    private List<String> textNums;

    public SplitTextNum(String[] textNums) {
        List<String> listNums = trim(textNums);
        ValidUtil.validateNumber(listNums);
        this.textNums = listNums;
    }

    private List<String> trim(String[] textNums) {
        return Arrays.stream(textNums).map(String::trim).collect(Collectors.toList());
    }


    public int sum() {
        return textNums.stream().collect(Collectors.summingInt(textNum -> Integer.parseInt(textNum)));
    }
}
