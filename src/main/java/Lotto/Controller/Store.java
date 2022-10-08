package Lotto.Controller;

import Lotto.model.*;
import Lotto.view.LottoInput;
import Lotto.view.LottoOutput;
import calculator.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Store {

    private static final String PRICE_ERROR_MESSAGE = "로또는 한개당 천원입니다.";
    private static final int LOTTO_PRICE = 1000;

    public void buyLotto() {
        int price = getPrice();
        int lottoCount = price / LOTTO_PRICE;
        Lottos lottos = createLottos(lottoCount);
        LottoOutput.noticeBuyLotto(lottos);
        Lotto luckyNumbers = new Lotto(getLuckyNumbers());
        Map<Rank, Integer> countingRank = lottos.summaryLottoResult(luckyNumbers);
        double profit = getProfit(countingRank, price);
        LottoOutput.noticeResult(countingRank, profit);
    }

    private double getProfit(Map<Rank, Integer> countingRank, int price) {
        double reward = 0;
        int count = 0;
        for (Rank rank : countingRank.keySet()) {
            count += countingRank.get(rank);
            reward += rank.getReward() * countingRank.get(rank);
        }
        if (count == 0) {
            return 0;
        }
        return reward / (double) price;
    }

    private List<LottoNumber> getLuckyNumbers() {
        List<String> numbers = LottoInput.getLuckyNumbers();
        return numbers.stream()
                .map(it -> new LottoNumber(Integer.parseInt(it)))
                .collect(Collectors.toList());
    }


    private int getPrice() {
        int price = LottoInput.getPrice();
        if (price % LOTTO_PRICE != 0) {
            new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
        return price;
    }

    private Lottos createLottos(int lottoCount) {
        LottoNumberPicker lottoNumberPicker = new LottoNumberPicker();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoNumberPicker.pick());
            lottos.add(lotto);
        }
        Lottos result = new Lottos(lottos);
        return result;
    }
}
