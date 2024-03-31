package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class ResultLotto {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;
    private LottoNumbers winningLottoNumbers;
    private LottoNumber bonusLottoNumber;

    public int totallottoCount() {
        return lottos.size();
    }

    public int getWinningAmount() {
        List<MatchNumber> matchNumbers = lottos.stream()
                .map(lotto -> lotto.matchNumbers(winningLottoNumbers, bonusLottoNumber))
                .collect(Collectors.toList());

        return LottoOutlet.getWinnings(matchNumbers);
    }

    public double getWinningRate() {
        return (double) getWinningAmount() / (lottos.size() * LOTTO_PRICE);
    }

    public List<LottoNumbers> getLottosNumbers() {
        return lottos.stream()
                .map(lotto -> lotto.getNumbers())
                .collect(Collectors.toList());
    }

    public void recordBuyLottos(List<Lotto> buyLottos) {
        this.lottos = buyLottos;
    }

    public void recordWinningNumbers(List<Integer> winningNumbers) {
        this.winningLottoNumbers = LottoNumbers.valueOf(winningNumbers);
    }

    public int findRankCount(int rank) {
        return (int) lottos.stream()
                .map(lotto -> lotto.matchNumbers(winningLottoNumbers, bonusLottoNumber))
                .filter(matchNumber -> LottoOutlet.getRank(matchNumber) == rank)
                .count();
    }

    public void recordWinningNumbers(LottoNumbers winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = LottoNumber.valueOf(bonusNumber);
    }
}
