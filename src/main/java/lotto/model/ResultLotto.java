package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class ResultLotto {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;
    private Numbers winningNumbers;
    private Number bonusNumber;

    public int totallottoCount() {
        return lottos.size();
    }

    public int getWinningAmount() {
        List<MatchNumber> matchNumbers = lottos.stream()
                .map(lotto -> lotto.matchNumbers(winningNumbers, bonusNumber))
                .collect(Collectors.toList());

        return LottoOutlet.getWinnings(matchNumbers);
    }

    public double getWinningRate() {
        return (double) getWinningAmount() / (lottos.size() * LOTTO_PRICE);
    }

    public List<Numbers> getLottosNumbers() {
        return lottos.stream()
                .map(lotto -> lotto.getNumbers())
                .collect(Collectors.toList());
    }

    public void recordBuyLottos(List<Lotto> buyLottos) {
        this.lottos = buyLottos;
    }

    public void recordWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = Numbers.valueOf(winningNumbers);
    }

    public int findRankCount(int rank) {
        return (int) lottos.stream()
                .map(lotto -> lotto.matchNumbers(winningNumbers, bonusNumber))
                .filter(matchNumber -> LottoOutlet.getRank(matchNumber) == rank)
                .count();
    }

    public void recordWinningNumbers(Numbers winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = new Number(bonusNumber);
    }
}
