package step2.domain;

import java.util.ArrayList;
import java.util.List;
import step2.utils.Conversion;
import step2.utils.Split;
import step2.utils.Validation;

public class ManualLotto {

    private final List<Lotto> lottoList = new ArrayList<>();

    public ManualLotto(String numbers) {
        String[] strings = Split.getStrings(numbers);
        List<Integer> manualNumbers = Conversion.stringToInt(strings);
        validateManualNumbers(manualNumbers);
        lottoList.add(new Lotto(manualNumbers));
    }

    private void validateManualNumbers(List<Integer> manualNumbers) {
        Validation.duplicate(manualNumbers);
        for (Integer manualNumber : manualNumbers) {
            Validation.rangeOfNumber(manualNumber);
        }
    }
}
