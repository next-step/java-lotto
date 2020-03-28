package step2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    public static final Integer LOTTO_PRICE = 1000;

    public static Lottos createLottos(int money) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        int count = money / LOTTO_PRICE;

        for(int i = 0; i < count; i++) {
            lottos.add(new Lotto(createLotto()));
        }
        return new Lottos(lottos);
    }

    private static List<LottoNumber> createLotto() {
        List<LottoNumber> lotto = getShuffledNumber()
                .stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());

        return lotto;
    }

    private static List<LottoNumber> getShuffledNumber() {
        List<LottoNumber> shuffledNumber = getWholeNumber();
        Collections.shuffle(shuffledNumber);

        return shuffledNumber;
    }

    private static List<LottoNumber> getWholeNumber() {
        List<LottoNumber> numbers = new ArrayList<>();

        for(int i = 1; i <= 45; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }
}
