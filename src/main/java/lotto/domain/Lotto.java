package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 01:05
 */
public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final Pattern NUMERIC = Pattern.compile("^[0-9]+$");
    private static final Predicate<String> IS_NUMERIC = str -> NUMERIC.matcher(str).matches();
    private List<LottoNumber> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개로 이루어져야 합니다.");
        }

        if (lottoNumbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복이 불가능 합니다.");
        }

        this.lottoNumbers = lottoNumbers.stream().map(LottoNumber::of).collect(Collectors.toList());
    }

    public static final Lotto of(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static final Lotto of(Integer... lottoNumbers) {
        return new Lotto(Arrays.asList(lottoNumbers));
    }

    public static final Lotto of(String lottoNumbers) {
        return new Lotto(Arrays.stream(lottoNumbers.split(","))
                            .map(String::trim)
                            .filter(IS_NUMERIC)
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
    }

    private boolean contains(LottoNumber number) {
        return this.lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(number));
    }

    public Long match(Lotto userLotto) {
        return this.lottoNumbers.stream()
                .filter(lottoNumber -> userLotto.contains(lottoNumber)).count();
    }

    public List<Integer> getLottoNumber() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::convertIntValue)
                .collect(Collectors.toList());
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
}
