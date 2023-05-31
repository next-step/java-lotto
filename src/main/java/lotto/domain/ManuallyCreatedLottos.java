package lotto.domain;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ManuallyCreatedLotto {

    private final List<TreeSet<Integer>> manuallyCreatedLottoNumbers;

    public ManuallyCreatedLotto(List<TreeSet<Integer>> manuallyCreatedLottoNumbers) {
        this.manuallyCreatedLottoNumbers = manuallyCreatedLottoNumbers;
    }

    public List<Lotto> createManualLottos() {
        return manuallyCreatedLottoNumbers.stream()
                .map(this::createManualLotto)
                .collect(Collectors.toList());
    }

    private Lotto createManualLotto(TreeSet<Integer> numbers) {
        TreeSet<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));
        return new Lotto(lottoNumbers);
    }

    public List<TreeSet<Integer>> getManuallyCreatedLottoNumbers() {
        return manuallyCreatedLottoNumbers;
    }
}
