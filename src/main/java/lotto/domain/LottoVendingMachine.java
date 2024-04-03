package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoVendingMachine {


    private final static int lottoPrice = 1000;


    public List<LottoTicket> receive(int money) {
        validate(money);
        return Stream.generate(LottoTicket::new)
                .limit(getQuantity(money))
                .collect(Collectors.toList());
    }

    private static void validate(int money) {
        if (isNotDivided(money)) {
            throw new IllegalArgumentException("1000원 단위의 금액만 사용 가능합니다.");
        }
    }

    private static boolean isNotDivided(int money) {
        return money % 1000 != 0;
    }

    public int getQuantity(int money) {
        return money / lottoPrice;
    }

    private List<LottoTicket> generate(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(target -> new LottoTicket())
                .collect(Collectors.toList());
    }

    public LottoResult match(List<LottoTicket> lottoTickets, LottoTicket lastWeekLotto) {
        return new LottoResult(lottoTickets, lastWeekLotto);
    }
}
