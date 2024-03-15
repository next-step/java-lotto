package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoMachine {
    private static final int LOTTO_PER_MONEY = 1_000;
    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::new)
                .collect(toList());
    }

    private LottoMachine() {
    }

    public static int size() {
        return lottoNumbers.size();
    }

    public static List<Lotto> purchase(int money) {
        int numOfLotto = calculate(money);
        if (numOfLotto == 0) {
            return Collections.emptyList();
        }

        return prepare(numOfLotto);
    }

    private static int calculate(int money) {
        return money / LOTTO_PER_MONEY;
    }

    private static List<Lotto> prepare(int numOfLotto) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 1; i <= numOfLotto; i++) {
            result.add(selectRandomLottoNumbers());
        }

        return result;
    }

    private static Lotto selectRandomLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return new Lotto(lottoNumbers.subList(0, 6));
    }
}
