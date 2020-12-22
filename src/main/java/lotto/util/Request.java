package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Match;

import java.util.List;
import java.util.Map;

public class Request {
    private static final int PER_PRICE = 1000;
    private final int money;
    private final int totalAmount;

    private final Lotto lotto = new Lotto();

    public Request(int money) {
        this.money = money;
        this.totalAmount = money / PER_PRICE;

        makeAmountLottoNumbers();
    }

    private void makeAmountLottoNumbers() {
        for (int amount = 0; amount < totalAmount; amount++) {
            lotto.addLottoNumbers(new LottoNumbers(LottoNumberGenerator.makeLottoNumber()));
        }
    }

    public int getMoney() {
        return money;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public List<LottoNumbers> getLotto() {
        return lotto.getLottoNumbers();
    }

    public Map<Match, List<Match>> getMatchLottoCount(List<Integer> targetNumbers) {
        return lotto.getMatchLottoCount(targetNumbers);
    }
}
