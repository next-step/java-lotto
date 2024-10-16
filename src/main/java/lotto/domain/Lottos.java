package lotto.domain;

import lotto.exception.PrizeOverFlowIsNegativeException;

import java.util.List;
import java.util.Stack;

public class Lottos {
    private final List<Lotto> lottos;

    public static Lottos createLottos(int purchaseAmount, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseAmount);
        return new Lottos(lottos);
    }

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getNumberOfLotto() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getWinningPrize(Lotto winningLotto) {
        int totalPrize = 0;
        int eachPrize = 0;
        for (Lotto lotto : lottos) {
            eachPrize = LottoWinningStatus(lotto, winningLotto);
            validOverFlow(eachPrize, totalPrize);
            validtotalPrize(eachPrize, totalPrize);
            totalPrize += eachPrize;
        }
        return totalPrize;
    }

    private void validtotalPrize(int eachPrize, int totalPrize) {
        if (eachPrize + totalPrize > 2_000_000_000) {
            throw new IllegalArgumentException("총 상금 20억을 넘길 순 없음");
        }
    }

    private void validOverFlow(int eachPrize, int totalPrize) {
        if (eachPrize + totalPrize < 0) {
            throw new PrizeOverFlowIsNegativeException();
        }
    }


    private int LottoWinningStatus(Lotto lotto, Lotto winningLotto) {
        int count = 0;
        List<LottoNumber> lottoNumbers = lotto.getLotto();
        List<LottoNumber> winningNumbers = winningLotto.getLotto();

        for (int i = 0; i < winningNumbers.size(); i++) {
            count += isNumberMatched(winningNumbers, i, lottoNumbers);
        }

        return Prize.getValueByHit(count);
    }

    private int isNumberMatched(List<LottoNumber> winningNumbers, int i, List<LottoNumber> lottoNumbers) {
        if (winningNumbers.contains(lottoNumbers.get(i))) {
            return 1;
        }
        return 0;
    }

    public void additionalLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public Stack<Integer> calculateStatistic(int totalPrize, Stack<Integer> stack) {
        int prize = totalPrize;
        Stack<Integer> statistic = stack;
        for (Prize price : Prize.values()) {
            statistic.push( prize / price.getValue());
            prize %= price.getValue();
        }
        return statistic;
    }

    public double calculateProfit(int prize, int buyPrice) {
        return Math.floor(prize / (double) buyPrice * 100) / 100.0;
    }

}
