package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class ResultLotto {
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;

    public int totallottoCount() {
        return lottos.size();
    }

    public int getWinningAmount() {
        return LottoOutlet.getWinnings(lottos, winningNumbers);
    }

    public double getWinningRate() {
        return (double) getWinningAmount() / (lottos.size() * 1000);
    }

    public List<List<Integer>> getLottosNumbers() {
        return lottos.stream()
                .map(lotto -> lotto.getNumbers())
                .collect(Collectors.toList());
    }

    public void recordBuyLottos(List<Lotto> buyLottos) {
        this.lottos = buyLottos;
    }

    public void recordWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int findMatchCount(int matchCount) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.matchNumbers(winningNumbers) == matchCount)
                .count();
    }
}
