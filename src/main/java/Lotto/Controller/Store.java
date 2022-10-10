package Lotto.Controller;

import Lotto.model.*;
import Lotto.view.LottoInput;
import Lotto.view.LottoOutput;

import java.util.List;
import java.util.Map;

public class Store {

    private static final String PRICE_ERROR_MESSAGE = "로또는 한개당 천원입니다.";
    private static final int LOTTO_PRICE = 1000;

    public void buyLotto() {
        LottoNumberCreateMachine lottoNumberCreateMachine = new LottoNumberCreateMachine();
        int lottoCount = getLottoCount();
        Lottos lottos = lottoNumberCreateMachine.createLottos(lottoCount);
        LottoOutput.noticeBuyLotto(lottos);
        Lotto luckyNumbers = lottoNumberCreateMachine.getLuckyNumbers(getLuckyNumber());
        Map<Rank, Integer> countingRank = lottos.summaryLottoResult(luckyNumbers);
        double profit = getProfit(countingRank, lottoCount);
        LottoOutput.noticeResult(countingRank, profit);
    }

    private int getLottoCount() {
        int price = LottoInput.getPrice();
        if (price % LOTTO_PRICE != 0) {
            new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
        return price / LOTTO_PRICE;
    }

    private List<String> getLuckyNumber() {
        return LottoInput.getLuckyNumbers();
    }

    private double getProfit(Map<Rank, Integer> countingRank, int lottoCount) {
        double reward = 0;
        int count = 0;
        double price = lottoCount * LOTTO_PRICE;
        for (Rank rank : countingRank.keySet()) {
            count += countingRank.get(rank);
            reward += rank.getReward() * countingRank.get(rank);
        }
        if (count == 0) {
            return 0;
        }
        return reward / price;
    }
}
