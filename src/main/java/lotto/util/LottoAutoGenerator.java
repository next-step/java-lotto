package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoAutoGenerator {

    private static final List<LottoNumber> LOTTO_BASE_NUMBERS;

    static {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = LottoNumber.LOTTO_MIN_NUMBER; i <= LottoNumber.LOTTO_MAX_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
        LOTTO_BASE_NUMBERS = Collections.unmodifiableList(numbers);
    }

    private LottoAutoGenerator() {
        throw new UnsupportedOperationException("유틸형 클래스는 생성할 수 없습니다");
    }

    public static List<Lotto> generate(final int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(createLottoNumbers()))
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> createLottoNumbers() {
        List<LottoNumber> shuffledNumbers = new ArrayList<>(LOTTO_BASE_NUMBERS);
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers.subList(0, Lotto.LOTTO_SIZE);
    }
}
