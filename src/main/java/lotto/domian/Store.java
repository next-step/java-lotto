package lotto.domian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Store {

    public static LottoBundle order(Money money) {
        return createLotto(decideCount(money));
    }

    public static Money orderManual(Money money, int manualOrderCount) {
        validateCount(manualOrderCount);
        validateMoney(money.amount(), manualOrderCount);
        return new Money(money.amount() - manualOrderCount * Lotto.PURCHASE_UNIT);
    }

    private static void validateCount(int manualOrderCount) {
        if (manualOrderCount < 0) {
            throw new IllegalArgumentException("수동로또 구매숫자는 음수가 될 수 없습니다.");
        }
    }
    private static void validateMoney(int amount, int manualOrderCount) {
        if (amount / Lotto.PURCHASE_UNIT < manualOrderCount) {
            throw new IllegalArgumentException("로또를 구매하기에 돈이 부족합니다.");
        }
    }

    private static LottoBundle createLotto(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(makeRandomLotto());
        }
        return new LottoBundle(lottoList);
    }

    private static Lotto makeRandomLotto() {
        List<Integer> lottoNumberBox = makeLottoBox();
        Collections.shuffle(lottoNumberBox);

        return new Lotto(makeLottoNumber(lottoNumberBox.subList(0, 6)));
    }

    private static int decideCount(Money money) {
        return money.amount() / Lotto.PURCHASE_UNIT;
    }

    private static Set<LottoNumber> makeLottoNumber(List<Integer> numberList) {
        return numberList.stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toSet());
    }

    private static List<Integer> makeLottoBox() {
        return IntStream.range(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }
}
