package lotto;

import java.util.*;

public class LottoFactory {
    private final static int NUMBER_COUNT = 6;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private static final List<LottoNumber> ALL_LOTTO_NUMBERS = allLottoNumbers(MIN_NUMBER, MAX_NUMBER);

    private static List<LottoNumber> allLottoNumbers(int min, int max) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number = min; number <= max; number++) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return lottoNumbers;
    }

    public static List<Lotto> createLottos(int automaticLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < automaticLottoCount; i++) {
            lottoList.add(new Lotto());
        }

        return Collections.unmodifiableList(lottoList);
    }

    public static List<Lotto> createLottos(int automaticLottoCount, List<String> manualLottos) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < automaticLottoCount; i++) {
            lottoList.add(new Lotto());
        }

        for(String inputManualLotto : manualLottos) {
            lottoList.add(new Lotto(inputManualLotto));
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
