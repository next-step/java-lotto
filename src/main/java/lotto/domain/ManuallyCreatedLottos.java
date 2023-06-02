package lotto.domain;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ManuallyCreatedLottos {

    private final List<Lotto> manuallyCreatedLottos;

    public ManuallyCreatedLottos(List<TreeSet<Integer>> manuallyCreatedLottos) {
        this.manuallyCreatedLottos = manuallyCreatedLottos.stream().map(this::createManualLotto).collect(Collectors.toList());
    }

    private Lotto createManualLotto(TreeSet<Integer> numbers) {
        TreeSet<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> getManuallyCreatedLottos() {
        return manuallyCreatedLottos;
    }
}
