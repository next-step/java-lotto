package step4.domain;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lotto {
    public static final int SIZE = 6;
    public static final Money PRICE = Money.of(1000);
    private static final String RANGE_EXCEPTION_MESSAGE = "로또의 숫자 개수가 맞지 않습니다.";

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(String lottoInput) {
        return Arrays.stream(lottoInput.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(collectingAndThen(toList(), Lotto::of));
    }

    public static Lotto of(List<LottoNumber> lottoNumbers) {

        if (lottoNumbers == null || lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }

        List<LottoNumber> copy = new ArrayList<>(lottoNumbers);

        Collections.sort(copy);
        return new Lotto(copy);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(lottoNumber -> LottoNumber.of(lottoNumber.getValue()))
                .collect(toList());
    }

    public long countOfMatch(Lotto winningLotto) {
        return lottoNumbers.stream()
                .filter(winningLotto::containLottoNumber)
                .count();
    }

    public boolean containLottoNumber(LottoNumber bonus) {
        return lottoNumbers.contains(bonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
