package lotto.domain;

import lotto.domain.lottocreator.Lotto;
import lotto.domain.lottocreator.LottoFactory;
import lotto.domain.winning.WinningCount;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int BONUS_NO_CHECK = 5;
    private static final int MIN_NUM_OF_LOTTO = 0;

    private List<Lotto> lottos;

    public Lottos(Positive numberOfLotto) {
        this.lottos = createAutoLottos(numberOfLotto);
    }

    public Lottos(List<String> manualLottosNumbers) {
        this.lottos = createManualLottos(manualLottosNumbers);
    }

    private List<Lotto> createAutoLottos(Positive numberOfLotto) {
        return IntStream.range(MIN_NUM_OF_LOTTO, numberOfLotto.getNumber()).boxed().map(lotto -> createAutoLotto()).collect(Collectors.toList());
    }

    private List<Lotto> createManualLottos(List<String> manualLottosNumbers) {
        return manualLottosNumbers.stream().map(numbers -> createManualLotto(numbers)).collect(Collectors.toList());
    }

    private Lotto createAutoLotto() {
        return LottoFactory.createAutoLotto();
    }

    private Lotto createManualLotto(String numbers) {
        return LottoFactory.createManualLotto(numbers);
    }

    public List<WinningCount> matchesLottos(Lotto winningLotto, LottoNo bonusNo) {
        return lottos.stream()
                .map(lotto -> WinningCount.of(lotto.getMatchingNumberCount(winningLotto)
                        , checkBonusBall(lotto, bonusNo, lotto.getMatchingNumberCount(winningLotto))))
                .collect(Collectors.toList());
    }

    private boolean checkBonusBall(Lotto lotto, LottoNo bonusNo, int count) {
        if (count != BONUS_NO_CHECK) {
            return false;
        }
        return lotto.contains(bonusNo);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void combineLottos(Lottos otherLottos) {
        lottos.addAll(otherLottos.lottos);
    }

    @Override
    public String toString() {
        return lottos.stream().map(String::valueOf).collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
