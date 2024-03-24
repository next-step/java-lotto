package lotto.model;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(getWinningAmount());
        System.out.println(lottos.size() * 1000);
        return (double) getWinningAmount() / (lottos.size() * 1000);
    }

    public List<List<Integer>> getLottosNumbers() {
        List<List<Integer>> lottosNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottosNumbers.add(lotto.getNumbers());
        }

        return lottosNumbers;
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
