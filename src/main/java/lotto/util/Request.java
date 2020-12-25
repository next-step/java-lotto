package lotto.util;

import lotto.domain.LottoTicket;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class Request {
    private static final int PER_PRICE = 1000;
    private final int money;
    private final int totalAmount;

    private final LottoTicket lottoTicket = new LottoTicket();

    public Request(int money) {
        checkMoney(money);

        this.money = money;
        this.totalAmount = money / PER_PRICE;

        makeAmountLottoNumbers();
    }

    private void checkMoney(int money) {
        if(money % 1000 > 0 ) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
    }

    private void makeAmountLottoNumbers() {
        for (int amount = 0; amount < totalAmount; amount++) {
            lottoTicket.addLottoNumbers(new Lotto(LottoNumberGenerator.makeLottoNumber()));
        }
    }

    public int getMoney() {
        return money;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public List<Lotto> getLotto() {
        return lottoTicket.getLottoNumbers();
    }

    public Map<Rank, List<Rank>> getMatchLottoCount(List<Integer> targetNumbers) {
        return lottoTicket.getMatchLottoCount(targetNumbers);
    }
}
