package lotto.dto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ManualLottoNumbers {
    private final List<Set<Integer>> manualNumbers;

    private ManualLottoNumbers(List<Set<Integer>> manualNumbers) {
        this.manualNumbers = manualNumbers;
    }

    public static ManualLottoNumbers as(NumberOfManualLotto numberOfManualLotto, Supplier<Set<Integer>> supplier) {
        List<Set<Integer>> manualLottoNumbers = new ArrayList<>();
        numberOfManualLotto.repeatAsSize(() -> manualLottoNumbers.add(supplier.get()));
        return new ManualLottoNumbers(manualLottoNumbers);
    }

    public static ManualLottoNumbers empty() {
        return new ManualLottoNumbers(Collections.emptyList());
    }

    public void addManualLottos(List<Lotto> lottos, Amount amount) {
        for (Set<Integer> manualLottoNumber : manualNumbers) {
            lottos.add(Lotto.of(manualLottoNumber));
            amount.subtractOneLottoPrice();
        }
    }

    public int size() {
        return manualNumbers.size();
    }
}
