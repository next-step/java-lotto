package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    private void validate(List<Lotto> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException("로또가 생성되지 않았습니다.");
        }
    }

    public LottoResult getResult(Lotto winningNumbers, LottoNumber lottoNumber) {
        List<Rank> rewards = lottos.stream()
                .map(lotto -> Rank.findRank(lotto.countCorrectNumber(winningNumbers)))
                .collect(Collectors.toList());
        return new LottoResult(rewards);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
