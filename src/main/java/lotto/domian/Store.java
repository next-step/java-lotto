package lotto.domian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Store {

    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> order(Money money) {
        return createLotto(makeFromMoney(money));
    }

    private static List<Lotto> createLotto(int count) {
        List<Lotto> lottoList = new ArrayList<>();  // todo : lottoList -> lottoGroup? 으로 변경하기
        for (int i = 0; i < count; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto() {
        List<Integer> lottoNumberBox = IntStream.range(1, 45)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(lottoNumberBox);

        return new Lotto(makeLottoNumber(lottoNumberBox.subList(0, 6)));
    }

    private static int makeFromMoney(Money money) {
        return money.amount() / LOTTO_PRICE;
    }

    private static List<LottoNumber> makeLottoNumber(List<Integer> numberList) {
        return numberList.stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }

}
