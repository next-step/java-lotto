package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Lotto {
    public static final int LOTTO_ALL_NUMBER = 45;
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_UNIT_NUMBER = 6;
    private static List<Integer> allLottoNumbers = new ArrayList<>();

    static {
        IntStream.range(LOTTO_MINIMUM_NUMBER, LOTTO_ALL_NUMBER)
                .forEach(number -> allLottoNumbers.add(number));
    }

    private final List<LottoNumber> lottoNumbers;

    private Lotto() {
        lottoNumbers = new ArrayList<>();
        Collections.shuffle(allLottoNumbers);

        allLottoNumbers.stream()
                .limit(LOTTO_UNIT_NUMBER)
                .sorted()
                .forEach(number -> lottoNumbers.add(LottoNumber.of(number)));
    }

    private Lotto(List<Integer> lottoNumbers) {
        List<LottoNumber> temporaryLottoNumbers = new ArrayList<>();
        lottoNumbers.forEach(lottoNumber -> temporaryLottoNumbers.add(LottoNumber.of(lottoNumber)));

        this.lottoNumbers = new ArrayList<>(temporaryLottoNumbers);
    }

    public static Lotto of() {
        return new Lotto();
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        if (Set.copyOf(lottoNumbers).size() != LOTTO_UNIT_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 서로다른 6개의 값이어야 합니다.");
        }
        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(this.lottoNumbers);
    }

    public int numberOfSame(Lotto lotto) {
        return (int) lotto.lottoNumbers.stream()
                .filter(lottoNumber -> this.lottoNumbers.contains(lottoNumber))
                .count();
    }

    public boolean isSameNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.stream().anyMatch(lottoNumber::isSameNumber);
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
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
