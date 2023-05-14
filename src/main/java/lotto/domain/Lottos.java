package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;
    private final LottoNumberGenerator lottoNumberGenerator;

    public Lottos(List<Lotto> lottos, LottoNumberGenerator lottoNumberGenerator) {
        this.lottos = lottos;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void buyLotto(LottoPrice lottoPrice) {
        for (int i = 0; i < lottoPrice.lottoCount(); i++) {
            lottos.add(new Lotto(lottoNumberGenerator.lotto()));
        }
    }

    public List<LottoMatcher> matchResult(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> winningNumbers.match(lotto))
                .collect(Collectors.toList());
    }

    public int quantity() {
        return lottos.size();
    }

    public List<List<Integer>> result() {
        return lottos.stream()
                .map(lotto -> lotto.lottoNumbers()
                        .stream().map(LottoNumber::intValue)
                        .collect(Collectors.toList())).collect(Collectors.toList());

    }
}
