package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class LottoUtils {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_VALUE = 1;
    private static final int LOTTO_MAX_VALUE = 45;

    private LottoUtils() {
    }

    public static List<Lotto> extractLottosFromStrings(String[] lottosStr) {
        return Arrays.stream(lottosStr)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public static List<Lotto> generateLottos(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int cnt = 0; cnt < size; cnt++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private static Lotto createLotto() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int num = LOTTO_MIN_VALUE; num <= LOTTO_MAX_VALUE; ++num) {
            numbers.add(new LottoNumber(num));
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, LOTTO_SIZE);
        numbers.sort((Comparator.comparingInt(LottoNumber::getLottoNumber)));
        return new Lotto(numbers);
    }

}
