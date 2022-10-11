package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;

    private final int ticket;
    private List<LottoNumbers> lottoNumbers = new ArrayList<>();
    private final Money money;

    private LottoResult result = LottoResult.of(new HashMap<>());

    private LottoTickets(int money) {
        this.money = Money.from(money);
        this.ticket = money / LOTTO_PRICE;
    }

    private LottoTickets(int money, LottoNumbers testResultNumberList) {
        this.money = Money.from(money);
        this.ticket = money / LOTTO_PRICE;
        this.lottoNumbers.add(testResultNumberList);
    }

    public static LottoTickets from(int money) {
        valid(money);
        return new LottoTickets(money);
    }

    public static LottoTickets from(int money, LottoNumbers testResultNumberList) {
        return new LottoTickets(money, testResultNumberList);
    }

    private static void valid(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE + " 미만은 로또를 구매할 수 없습니다.");
        }
    }

    public int countTicket() {
        return this.ticket;
    }

    public List<LottoNumbers> createTickets() {
        for (int i = 0; i < ticket; i++) {
            LottoNumbers generateNumbers = LottoNumberRandomGenerator.generate();
            lottoNumbers.add(generateNumbers);
        }
        return lottoNumbers;
    }

    public LottoResult result(LottoNumbers winningNumbers) {
        for (LottoNumbers lotto : lottoNumbers) {
            int count = lotto.matches(winningNumbers);
            Rank calculate = Rank.calculate(count);

            result.put(calculate);
        }
        return result;
    }

}
