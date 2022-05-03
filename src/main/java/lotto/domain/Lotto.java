package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_COUNT = 6;
    private static final String DELIMITER = ",[ ]*";
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(String input) {
        List<LottoNumber> newLottoNumbers = Arrays.stream(input.split(DELIMITER))
                .map(LottoNumber::createNewNumber)
                .sorted()
                .collect(Collectors.toList());
        lottoNumbers.addAll(validateLottoNumbers(newLottoNumbers));
    }

    public Lotto(GenerateNumberStrategy strategy) {
        while (lottoNumbers.size() < LOTTO_COUNT) {
            LottoNumber newLottoNumber = LottoNumber.createNewNumber(strategy);
            if (checkAlreadyContainNumber(newLottoNumber)) continue;
            lottoNumbers.add(newLottoNumber);
        }
        Collections.sort(lottoNumbers);
    }

    private List<LottoNumber> validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다.");
        }
        return lottoNumbers;
    }

    public int countMatchNumber(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto.lottoNumbers::contains)
                .count();
    }

    private boolean checkAlreadyContainNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
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
