package step2.domain;

import java.util.ArrayList;
import java.util.List;
import step2.utils.Conversion;
import step2.utils.Split;
import step2.utils.Validation;

public class ManualLotto {

    private final List<Lotto> manualLottoList = new ArrayList<>();

    public ManualLotto(List<String> numbers) {
        for (String number : numbers) {
            List<Integer> manualNumbers = getManualNumber(number);
            validateManualNumbers(manualNumbers);
            manualLottoList.add(new Lotto(manualNumbers));
        }
    }

    public ManualLotto(String number) {
            List<Integer> manualNumbers = getManualNumber(number);
            validateManualNumbers(manualNumbers);
            manualLottoList.add(new Lotto(manualNumbers));
    }

    private void validateManualNumbers(List<Integer> manualNumbers) {
        Validation.size(manualNumbers);
        Validation.duplicate(manualNumbers);
        for (Integer manualNumber : manualNumbers) {
            Validation.rangeOfNumber(manualNumber);
        }
    }

    private List<Integer> getManualNumber(String number) {
        String[] strings = Split.getStrings(number);
        return Conversion.stringToInt(strings);
    }

    public void isAdded(List<Lotto> lottoList) {
        lottoList.addAll(manualLottoList);
    }
}
