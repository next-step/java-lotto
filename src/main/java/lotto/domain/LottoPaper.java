package lotto.domain;

import java.util.*;

public class LottoPaper {

    private Set<Integer> lottoNumber;
    private WinnigResult winning = new WinnigResult();

    public LottoPaper(RandomNumber lottoNumberStragey) {
        lottoNumber = lottoNumberStragey.getLottoNumber();
    }

    public Set<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public void compreWinningNumber(Set<Integer> winningNumbers, Statistics statistics) {

        for (Integer number : winningNumbers) {
            winning.compareLottoNumber(lottoNumber, number);
        }

        winning.updateLottoStatus();
        statistics.calculateRank(winning.getLottoStatus(), winning.getEarnMoney());
    }

}
