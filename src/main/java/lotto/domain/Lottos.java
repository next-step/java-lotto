package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<List<LottoNumber>> getLottos() {
        return lottos.stream()
                .map(Lotto::getLottoNumbers)
                .collect(Collectors.toUnmodifiableList());
    }

    public long size() {
        return lottos.size();
    }

    public LottoResults matchWinningNumbers(WinningNumbers winningNumbers) {
        LottoResults lottoResults = new LottoResults();
        for (Lotto lotto : lottos) {
            lottoResults.add(winningNumbers.match(lotto), 1);
        }
        return lottoResults;
    }
}
