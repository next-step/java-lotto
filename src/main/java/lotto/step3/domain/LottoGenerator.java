package lotto.step3.domain;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public final class LottoGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static final List<LottoNumber> allLottoNumbers = createAllNumbers();

    public static List<LottoNumber> createLotto() {
        Collections.shuffle(allLottoNumbers);
        List<LottoNumber> randomLottoNumbers = allLottoNumbers.stream()
                .limit(LOTTO_SIZE)
                .sorted()
                .collect(toList());
        return Collections.unmodifiableList(randomLottoNumbers);
    }

    public static List<LottoNumber> createWinningNumbers(List<Integer> numbers) {
        checkNumbers(numbers);
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(toList());
        return Collections.unmodifiableList(lottoNumbers);
    }

    private static List<LottoNumber> createAllNumbers() {
        return rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(toList());
    }

    private static void checkNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("6자리 입력해주세요");
        }
        long count = numbers.stream()
                .mapToInt(n -> n)
                .distinct()
                .count();
        if (count != LOTTO_SIZE) {
            throw new IllegalArgumentException("중복 번호는 안됩니다");
        }
    }

}
