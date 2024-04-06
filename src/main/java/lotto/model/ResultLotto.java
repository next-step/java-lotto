package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class ResultLotto {
    private static final int LOTTO_PRICE = 1000;
    private Lottos lottos;
    private LottoNumbers winningLottoNumbers;
    private LottoNumber bonusLottoNumber;

    public ResultLotto() {
        this.lottos = new Lottos();
    }

    public int totallottoCount() {
        return lottos.size();
    }

    public int getWinningAmount() {
        List<MatchResult> matchResults = lottos.getLottos().stream()
                .map(lotto -> lotto.matchNumbers(winningLottoNumbers, bonusLottoNumber))
                .collect(Collectors.toList());

        return LottoOutlet.getWinnings(matchResults);
    }

    public double getWinningRate() {
        return (double) getWinningAmount() / (lottos.size() * LOTTO_PRICE);
    }

    public List<LottoNumbers> getLottosNumbers() {
        return lottos.getLottos().stream()
                .map(lotto -> lotto.getNumbers())
                .collect(Collectors.toList());
    }

    public void recordWinningNumbers(List<Integer> winningNumbers) {
        this.winningLottoNumbers = LottoNumbers.valueOf(winningNumbers);
    }

    public int findRankCount(int rank) {
        return (int) lottos.getLottos().stream()
                .map(lotto -> lotto.matchNumbers(winningLottoNumbers, bonusLottoNumber))
                .filter(matchNumber -> LottoOutlet.getRank(matchNumber) == rank)
                .count();
    }

    public void recordWinningNumbers(LottoNumbers winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = LottoNumber.valueOf(bonusNumber);
    }

    public void recordManualLottos(List<Lotto> buyLottos) {
        lottos.addManualLottos(buyLottos);
    }

    public void recordBuyAutoLottos(List<Lotto> buyLottos) {
        lottos.addAutoLottos(buyLottos);
    }

    public int getAutoLottoCount() {
        return lottos.getAutoCount();
    }

    public int getManualLottoCount() {
        return lottos.getManualCount();
    }
}
