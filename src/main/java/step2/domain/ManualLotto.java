package step2.domain;

import java.util.ArrayList;
import java.util.List;
import step2.utils.Conversion;
import step2.utils.Split;
import step2.utils.Validation;

public class ManualLotto {

    private final List<PickedLottoNumbers> manualLottos = new ArrayList<>();

    public ManualLotto(List<String> numbers) {
        for (String number : numbers) {
            List<Integer> manualNumbers = getManualNumber(number);
            validateManualNumbers(manualNumbers);
            manualLottos.add(new PickedLottoNumbers(manualNumbers));
        }
    }

    public ManualLotto(String number) {
        this(new ArrayList<>(List.of(number)));
    }

    public List<Lotto> toLottoEntity() {
        List<Lotto> lottoStore = new ArrayList<>();
        manualLottos.forEach(manualLotto -> lottoStore.add(new Lotto(manualLotto)));
        return lottoStore;
    }

    private void validateManualNumbers(List<Integer> manualNumbers) {
        Validation.validComponent(manualNumbers);
        for (Integer manualNumber : manualNumbers) {
            Validation.rangeOfNumber(manualNumber);
        }
    }

    private List<Integer> getManualNumber(String number) {
        String[] strings = Split.getStrings(number);
        return Conversion.stringToInt(strings);
    }
}
