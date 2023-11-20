package lotto;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class LottoFactory {
    private final static int NUMBER_COUNT = 6;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 10;
    private static final List<LottoNumber> ALL_LOTTO_NUMBERS = lottoAllNumbers();

    private static List<LottoNumber> lottoAllNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return lottoNumbers;
    }

    public static List<Lotto> createLottoList(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(createLotto()));
        }

        return Collections.unmodifiableList(lottoList);
    }

    public static List<LottoNumber> createLotto(String inputNumbers) {
        String[] arrayNumbers = inputNumbers.split(",");
        List<LottoNumber> lottoNumbers = Arrays.stream(arrayNumbers)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        return createLotto(lottoNumbers);
    }

    public static List<LottoNumber> createLotto(List<LottoNumber> lottoNumbers) {
        checkLottoSizeIsValid(lottoNumbers);
        return Collections.unmodifiableList(lottoNumbers);
    }

    private static void checkLottoSizeIsValid(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumberSet.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않은 6자리 숫자여야 합니다");
        }
    }

    public static List<LottoNumber> createLotto() {
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
