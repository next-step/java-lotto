package lottoauto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final int LOTTO_SIZE = 6;
    private static List<LottoNumber> lottoNumbersCache = LottoNumber.rangedClosed().mapToObj(LottoNumber::from).collect(Collectors.toList());

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE + "개의 로또 번호를 입력해야 합니다.(중복된 번호 입력 불가)");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createAuto() {
        Collections.shuffle(lottoNumbersCache);
        Set<LottoNumber> lottoNumbers = lottoNumbersCache.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toCollection(TreeSet::new));
        return new Lotto(lottoNumbers);
    }

    public static Lotto from(String numbers) {
        return from(numbers.split(LOTTO_NUMBER_DELIMITER));
    }

    public static Lotto from(String[] numbers) {
        Set<LottoNumber> lottoNumbers = Arrays.stream(numbers).map(LottoNumber::from).collect(Collectors.toCollection(TreeSet::new));
        return new Lotto(lottoNumbers);
    }

    public int findMatchingCount(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> lotto.contains(lottoNumber))
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
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
