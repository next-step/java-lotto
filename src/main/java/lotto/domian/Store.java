package lotto.domian;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Store {

    public static LottoBundle order(Money money) {
        return createLotto(decideCount(money));
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
        return money.amount() / LottoCompany.PURCHASE_UNIT;
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
