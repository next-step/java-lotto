package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int PRICE_OF_LOTTO = 1_000;

    public List<LottoNumber> buy (long money) {
        validate(money);

        List<LottoNumber> lottos = new ArrayList<>();
        IntStream.range(0, numberOfLottoTickets(money))
                .forEach(i -> lottos.add(new LottoNumber()));
        return lottos;
    }

    private static void validate(long money) {
        if (money < 1000) {
            throw new IllegalArgumentException("최소 1,000원 이상 입력해야 합니다.");
        }
    }

    private int numberOfLottoTickets(long money) {
        return (int) money / PRICE_OF_LOTTO;
    }
}
