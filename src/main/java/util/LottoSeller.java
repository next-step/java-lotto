package util;

import domain.Lotto;
import domain.LottoNumber;
import domain.Money;
import domain.Number;
import dto.LottoBuyResult;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static util.LottoManager.createLotto;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;

    private LottoSeller(){
        throw new IllegalStateException("Utility class");
    }

    public static LottoBuyResult buyLotto(Money money) {
        final int lottoCount = money.value() / LOTTO_PRICE;

        final List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> createLotto())
                .collect(Collectors.toUnmodifiableList());

        final Money change = new Money(money.value() % LOTTO_PRICE);

        return new LottoBuyResult(lottos, change);
    }

    public static Money getLottoPrice(int lottoCount) {
        return new Money(LOTTO_PRICE * lottoCount);
    }

    public static LottoBuyResult buyManualLotto(List<LottoNumber> lottoNumbers, Money money) {
        return new LottoBuyResult(Collections.singletonList(new Lotto(lottoNumbers)), money.subtract(new Money(LOTTO_PRICE)));
    }
}
