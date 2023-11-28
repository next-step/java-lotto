package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AutomaticLottoMachine {

    private final RandomLottoGenerator randomLottoGenerator;

    public AutomaticLottoMachine(RandomLottoGenerator randomLottoGenerator) {
        this.randomLottoGenerator = randomLottoGenerator;
    }

    public Lottos createLottos(long lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(sortedLotto());
        }
        return new Lottos(lottos);
    }

    private Lotto sortedLotto() {
        return new Lotto(createSortedLottoNumbers(createRandomLottoNumbers()));
    }

    private List<LottoNumber> createRandomLottoNumbers() {
        return randomLottoGenerator.createLotto(LottoNumber.allNumbers());
    }

    private List<LottoNumber> createSortedLottoNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream().sorted(LottoNumber::compare).collect(Collectors.toList());
    }
}
