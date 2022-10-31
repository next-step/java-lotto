package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.reducing;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class Lotto {

    public static final int VALID_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty() || lottoNumbers.size() != VALID_COUNT) {
            throw new IllegalArgumentException("로또번호 갯수가 유효하지 않습니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto ofInteger(List<Integer> lottoNumbers) {
        return new Lotto(mapToLottoNumber(lottoNumbers));
    }

    public static List<LottoNumber> mapToLottoNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static Lotto ofString(String[] lottoNumbers) {
        return new Lotto(mapToLottoNumber(lottoNumbers));
    }

    private static List<LottoNumber> mapToLottoNumber(String[] lottoNumbers) {
        return Stream.of(lottoNumbers)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static Lotto ofLottoNumber(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoResult getResult(Lotto winLottoNumber, LottoNumber bonusNumber) {
        return LottoResult.from(matchCount(winLottoNumber), hasBonusNumber(bonusNumber));
    }

    private boolean hasBonusNumber(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private int matchCount(Lotto winLottoNumber) {
        return winLottoNumber.getLottoNumbers()
                .stream()
                .filter(lottoNumbers::contains)
                .collect(reducing(0, e -> 1, Integer::sum));
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
        return lottoNumbers.toString();
    }
}
