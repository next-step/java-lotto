package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.*;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<LottoNumber> LOTTO_NUMBER_CACHE = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableSet(new TreeSet<>(lottoNumbers));
    }

    public static Lotto of(List<LottoNumber> numbers) {
        validateInputs(numbers);

        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        for (LottoNumber number : numbers) {
            addUniqueLottoNumber(number, lottoNumbers);
        }

        return new Lotto(lottoNumbers);
    }

    public static Lotto generateRandomly() {
        Collections.shuffle(LOTTO_NUMBER_CACHE);
        return Lotto.of(Lotto.LOTTO_NUMBER_CACHE.subList(0, LOTTO_NUMBER_COUNT));
    }

    public int countNumberMatchCount(Set<LottoNumber> numbers) {
        return (int) lottoNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean isNumberMatched(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    private static void addUniqueLottoNumber(LottoNumber lottoNumber, Set<LottoNumber> lottoNumbers) {
        if (isNotUniqueLottoNumber(lottoNumber, lottoNumbers)) {
            throw new IllegalArgumentException("중복되는 번호가 있습니다. 중복된 번호: " + lottoNumber);
        }
    }

    private static boolean isNotUniqueLottoNumber(LottoNumber lottoNumber, Set<LottoNumber> lottoNumbers) {
        return !lottoNumbers.add(lottoNumber);
    }

    private static void validateInputs(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            String messageFormat = "로또는 %d개의 숫자로 구성되어 있습니다. 입력된 숫자 수: %d";
            throw new IllegalArgumentException(String.format(messageFormat, LOTTO_NUMBER_COUNT, lottoNumbers.size()));
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

}
