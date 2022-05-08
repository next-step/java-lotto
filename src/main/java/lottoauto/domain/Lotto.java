package lottoauto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final int LOTTO_SIZE = 6;
    private static List<LottoNumber> lottoNumbersCache = LottoNumber.rangedClosed().mapToObj(LottoNumber::from).collect(Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (isDuplicated(lottoNumbers)) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE + "개의 로또 번호를 입력해야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    private boolean isDuplicated(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != lottoNumbers.stream().distinct().count();
    }

    public static Lotto createAuto() {
        Collections.shuffle(lottoNumbersCache);
        List<LottoNumber> lottoNumbers = lottoNumbersCache.stream()
                .limit(LOTTO_SIZE)
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public static Lotto from(String numbers) {
        return from(numbers.split(LOTTO_NUMBER_DELIMITER));
    }

    public static Lotto from(String[] numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers).map(LottoNumber::from).collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public int findMatchingCount(Lotto lotto) {
        return (int) lottoNumbers.stream().filter(lottoNumber -> lotto.contains(lottoNumber)).count();
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.stream().anyMatch(lottoNumber::equals);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "" + lottoNumbers;
    }
}
