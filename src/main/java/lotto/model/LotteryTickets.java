package lotto.model;

import lotto.exception.LottoCountException;
import lotto.exception.LottoSizeException;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class LotteryTickets {

    private final List<Lotto> lottos;
    private final int inputCount;

    public LotteryTickets(List<Lotto> lottos) {
        this(lottos, lottos.size());
    }

    public LotteryTickets(List<Lotto> lottos, int inputCount) {
        validate(lottos.size());
        inputValidate(lottos, inputCount);
        this.lottos = lottos;
        this.inputCount = inputCount;
    }

    public void findGrade(Lotto winLotto, int bonus) {
        Set<Integer> winningNumbers = winLotto.numbers();
        for (Lotto lotto : lottos) {
            LotteryResults.increase(lotto.matchCount(winningNumbers, bonus));
        }
    }


    public static LotteryTickets plus(LotteryTickets manualLottos, LotteryTickets autoLottos) {
        manualLottos.lottos.addAll(autoLottos.lottos);
        return new LotteryTickets(manualLottos.lottos, manualLottos.lottos.size());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void inputValidate(List<Lotto> lottos, int inputCount) {
        if (lottos.size() != inputCount) {
            throw new LottoCountException(inputCount);
        }
    }

    private void validate(int size) {
        if (size < 0) {
            throw new LottoSizeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTickets that = (LotteryTickets) o;
        return inputCount == that.inputCount && Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos, inputCount);
    }
}
