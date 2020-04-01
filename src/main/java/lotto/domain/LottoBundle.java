package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoBundle {
    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        validateSize(lottos);
        this.lottos = new ArrayList<>(lottos);
    }

    private void validateSize(List<Lotto> lottos) {
        if (Objects.isNull(lottos) || lottos.isEmpty()) {
            throw new IllegalArgumentException("로또는 1개 이상 존재해야 합니다.");
        }
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public List<WinningType> drawForWinning(String winningNumber, int bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        return lottos.stream()
                .map(lotto -> winningLotto.checkWinning(lotto))
                .filter(winningType -> winningType.isMatched())
                .collect(Collectors.toList());
    }

    public long size() {
        return lottos.size();
    }

    public LottoBundle join(LottoBundle lottoBundle) {
        lottos.addAll(lottoBundle.lottos);
        return new LottoBundle(lottos);
    }
}
