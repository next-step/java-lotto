package lotto;

import lotto.exception.MoneyNotEnoughException;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    static final int LOTTO_PRICE = 1000;
    final static String DELIMITER = ",";
    OutputView outputView;
    List<Lotto> lottos;
    Lotto winLotto;
    Map<LottoPrize, Integer> lottoGameStatistics;
    private int money;

    public LottoGame() {
        outputView = new OutputView();
        lottos = new ArrayList<>();
        lottoGameStatistics = new HashMap<>();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            lottoGameStatistics.put(lottoPrize, 0);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lotto getWinLotto() {
        return winLotto;
    }


    public void buyLotto(int buyMoney) {
        int buyAmount = buyMoney / LOTTO_PRICE;
        if (buyAmount <= 0) {
            throw new MoneyNotEnoughException("Money is not enough to buy lotto");
        }
        this.money = buyMoney;
        outputView.printBoughtLottoCount(buyAmount);

        for (int i = 0; i < buyAmount; i++) {
            Lotto lotto = new Lotto();
            lotto.createRandomNumber();
            outputView.printLottoNumbers(lotto);
            lottos.add(lotto);
        }
        outputView.printLine();
    }

    public void lastWinningLotto(String winningNumbers) {
        winLotto = new Lotto(winningNumbers.split(DELIMITER));
    }

    public void lottoWinners() {
        for (Lotto lotto : lottos) {
            LottoPrize lottoPrize = lotto.getPrize(winLotto);
            if (lottoPrize != null) {
                lottoGameStatistics.put(lottoPrize, lottoGameStatistics.getOrDefault(lottoPrize, 0) + 1);
            }
        }
        outputView.printLottoStatistics(lottoGameStatistics);
        outputView.printProfit(getProfit());
    }

    private float getProfit() {
        int winPrize = 0;
        for (LottoPrize lottoPrize : lottoGameStatistics.keySet()) {
            winPrize += lottoPrize.getPrize() * lottoGameStatistics.get(lottoPrize);
        }
        if (winPrize == 0) {
            return 0;
        }
        return ((float) winPrize / money);
    }
}