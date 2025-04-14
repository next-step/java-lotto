package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int PRICE_OF_LOTTO = 1_000;

    public List<LottoNumbers> buy(long money) {
        validate(money);
        return IntStream.range(0, (int) money / PRICE_OF_LOTTO)
                .mapToObj(i -> LottoNumberGenerator.generate())
                .collect(Collectors.toList());
    }

    private void validate(long money) {
        if (money < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException("최소 1,000원 이상 입력해야 합니다.");
        }
    }
}