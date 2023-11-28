package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManuallyPurchase implements Purchase {

    private final List<List<String>> manuallyLotto;

    ManuallyPurchase(List<List<String>> manuallyLotto) {
        this.manuallyLotto = manuallyLotto;
    }

    @Override
    public List<Lotto> purchase() {
        return createManuallyLottoList();
    }

    private List<Lotto> createManuallyLottoList() {
        return this.manuallyLotto.stream()
            .map(list -> Lotto.manually(list.stream()
                .map(s -> LottoNumber.from(Integer.parseInt(s)))
                .collect(Collectors.toList())))
            .collect(Collectors.toList());
    }
}
