package nextstep.lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class NumberFactory {

    public static List<InputNumber> create(String[] inputStrings) {
        List<InputNumber> inputNumbers = new ArrayList();

        for (String targetString : inputStrings) {
            inputNumbers.add(new InputNumber(targetString));
        }

        return inputNumbers;
    }

}
