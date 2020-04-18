package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public static Lotto ofComma(String lottoNumbersString) {
        List<Integer> collect = getIntLottoNumbers(lottoNumbersString);
        return of(collect);
    }

    private static List<Integer> getIntLottoNumbers(String lottoNumbersString) {
        // TODO: validate
        String[] lottoNumbers = lottoNumbersString.split(",");
        return Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private static void validateLottoNumbers(List<Integer> lottoNumbers) {
        checkLottoSize(lottoNumbers);
        checkDuplicatedNumber(lottoNumbers);
    }

    private static void checkDuplicatedNumber(List<Integer> lottoNumbers) {
        Set<Integer> numberSet = new HashSet<>(lottoNumbers);
        if (numberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호 중복");
        }
    }

    private static void checkLottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호가 6개가 아닙니다");
        }
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
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
