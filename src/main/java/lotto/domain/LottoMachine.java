package lotto.domain;

import lotto.exception.LottoApplicationException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public Lottos buy(Money money, LottoGenerator lottoGenerator) {
        checkMoney(money);
        int lottoCount = (int) money.divideBy(LOTTO_PRICE);

        List<Lotto> lottoList = IntStream.range(0, lottoCount)
                .mapToObj((num) -> lottoGenerator.generate())
                .collect(Collectors.toList());

        return new Lottos(lottoList);
    }

    private void checkMoney(Money money) {
        if (money.lt(LOTTO_PRICE)) {
            throw new LottoApplicationException("최소 구매금액은 1000원 입니다.");
        }

        if (money.isNotDivisibleBy(LOTTO_PRICE)) {
            throw new LottoApplicationException("1000원 단위로 구매해주세요.");
        }
    }

}
