package lotto;

import java.util.*;

public class LottoFactory {
    private final static int NUMBER_COUNT = 6;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private static final List<LottoNumber> ALL_LOTTO_NUMBERS = allLottoNumbers();

    private static List<LottoNumber> allLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return lottoNumbers;
    }

    public static List<Lotto> createLottos(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }

        return Collections.unmodifiableList(lottoList);
    }

    public static List<LottoNumber> createLottoNumbers() {
        List<LottoNumber> randomLottoNumbers = sortedRandomNumbers();
        return Collections.unmodifiableList(randomLottoNumbers);
    }

    private static List<LottoNumber> sortedRandomNumbers() {
        Collections.shuffle(LottoFactory.ALL_LOTTO_NUMBERS);
        List<LottoNumber> randomLottoNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_COUNT; i++) {
            randomLottoNumbers.add(LottoFactory.ALL_LOTTO_NUMBERS.get(i));
        }

        randomLottoNumbers.sort(Comparator.comparingInt(LottoNumber::lottoNumber));
        return randomLottoNumbers;
    }
}
