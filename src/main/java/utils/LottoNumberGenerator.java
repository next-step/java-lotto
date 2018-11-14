package utils;

import domain.Lotto;
import domain.wrapper.Money;

import java.util.*;

public class LottoNumberGenerator implements LottoGenerator {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_COUNT = 6;

    public static List<Integer> generateNumberList(int lottoCount) {
        List<Integer> numbers = getLottoNumInit();
        numbers = getShuffle(numbers, lottoCount);
        return numbers;
    }

    private static List<Integer> getShuffle(List<Integer> numbers, int lottoCount) {
        Collections.shuffle(numbers, new Random());
        numbers = numbers.subList(0, lottoCount);
        Collections.sort(numbers);
        return numbers;
    }

    private static List<Integer> getLottoNumInit() {

        List<Integer> numbers = new ArrayList<>();
        for (int i = LOTTO_MIN_NUM; i <= LOTTO_MAX_NUM; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.getCount(); i++) {
            Lotto lotto = new Lotto(generateNumberList(LOTTO_COUNT));
            lottos.add(lotto);
        }
        return lottos;
    }

}
