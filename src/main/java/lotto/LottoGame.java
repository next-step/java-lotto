package lotto;

import lotto.exception.MoneyNotEnoughException;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.Money;
import lotto.model.Number;
import lotto.util.RandomIntUtil;

import java.util.*;

public class LottoGame {
    private final static int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;
    private Lotto winLotto;
    private Map<LottoPrize, Integer> lottoGameStatistics;
    private Money buyMoney;
    private Number bonusNumber;

    public LottoGame() {
        lottos = new ArrayList<>();
        lottoGameStatistics = new LinkedHashMap<>();

    }

    public void initializeStatistics() {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            lottoGameStatistics.put(lottoPrize, 0);
        }
    }

    public void buyLotto(Money buyMoney) {
        int buyAmount = buyMoney.amount() / LOTTO_PRICE;
        if (buyAmount <= 0) {
            throw new MoneyNotEnoughException("Money is not enough to buy lotto");
        }
        this.buyMoney = buyMoney;
        for (int i = 0; i < buyAmount; i++) {
            Lotto lotto = new Lotto(createRandomNumber());
            lottos.add(lotto);
        }
    }

    private List<Number> createRandomNumber() {
        List<Number> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            Number number = new Number(RandomIntUtil.getRandomInt());
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        Collections.sort(numbers);
        return numbers;
    }

    public void lastWinningLotto(Lotto winningLotto) {
        this.winLotto = winningLotto;
    }

    public void lottoWinners() {
        for (Lotto lotto : lottos) {
            LottoPrize lottoPrize = lotto.getPrize(winLotto, bonusNumber);
            if (lottoPrize != null) {
                lottoGameStatistics.put(lottoPrize, lottoGameStatistics.getOrDefault(lottoPrize, 0) + 1);
            }
        }
    }

    public float getProfit() {
        int winPrize = 0;
        for (LottoPrize lottoPrize : lottoGameStatistics.keySet()) {
            winPrize += lottoPrize.getPrize() * lottoGameStatistics.get(lottoPrize);
        }
        if (winPrize == 0) {
            return 0;
        }
        return ((float) winPrize / buyMoney.amount());
    }


    public Map<LottoPrize, Integer> getLottoGameStatistics() {
        return lottoGameStatistics;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public void setBonusNumber(Number bonusNumber) {
        if (winLotto.contain(bonusNumber)) {
            throw new IllegalArgumentException("bonus number already exists in winning numbers");
        }
        this.bonusNumber = bonusNumber;
    }
}
