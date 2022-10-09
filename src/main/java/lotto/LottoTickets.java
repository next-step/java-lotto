package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;
    private final int ticket;
    private List<List<LottoNumber>> lottoList = new ArrayList<>();
    private double rate;
    private Money money;

    private LottoResult result = LottoResult.of(new HashMap<>());

    private LottoTickets(int money) {
        this.money = Money.from(money);
        this.ticket = money / LOTTO_PRICE;
    }

    private LottoTickets(int money, List<LottoNumber> testResultNumberList) {
        this.money = Money.from(money);
        this.ticket = money / LOTTO_PRICE;
        this.lottoList.add(testResultNumberList);
    }

    public static LottoTickets from(int money) {
        valid(money);
        return new LottoTickets(money);
    }

    public static LottoTickets from(int money, List<LottoNumber> testResultNumberList) {
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

    public List<List<LottoNumber>> createTickets() {
        for (int i = 0; i < ticket; i++) {
            List<LottoNumber> generateNumberList = LottoNumberRandomGenerator.generate();
            lottoList.add(generateNumberList);
        }
        return lottoList;
    }

    public LottoResult result(List<LottoNumber> winningNumbers) {
        for (List<LottoNumber> lotto : lottoList) {
            int count = 0;
            for (LottoNumber lottoNumber : lotto) {
                if (winningNumbers.contains(lottoNumber)) {
                    count += 1;
                }
            }
            Rank calculate = Rank.calculate(count);

            result.put(calculate);
        }
        return result;
    }

}
