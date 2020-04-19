package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        checkLottoSize(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        checkDuplicatedNumber(lottoNumbers);
        return new Lotto(lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    public static Lotto ofComma(String lottoNumbersString) {
        List<Integer> collect = getIntLottoNumbers(lottoNumbersString);
        return of(collect);
    }

    private static List<Integer> getIntLottoNumbers(String lottoNumbersString) {
        String[] lottoNumbers = lottoNumbersString.split(",");
        return Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void checkDuplicatedNumber(List<Integer> lottoNumbers) {
        Set<Integer> numberSet = new HashSet<>(lottoNumbers);
        if (numberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호 중복");
        }
    }

    private static void checkLottoSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호가 6개가 아닙니다");
        }
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> lottoNumbers = this.lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int match(Lotto lotto) {
        int match = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            match += lotto.get1IfContains(lottoNumber);
        }
        return match;
    }

    private int get1IfContains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber) ? 1 : 0;
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
