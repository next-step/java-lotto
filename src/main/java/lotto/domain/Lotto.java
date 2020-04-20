package lotto.domain;

import lotto.exception.InvalidLottoNumbersException;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.toIntExact;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public static Lotto getNewInstance() {
        List<LottoNumber> lottoNumbers = LottoNumber.getRandomListInstance(LOTTO_SIZE);
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    public static Lotto of(List<Integer> numbers) {
        if (!isValidNumbers(numbers)) {
            throw new InvalidLottoNumbersException();
        }

        return new Lotto(numbers.stream()
                .map(LottoNumber::getInstance)
                .collect(Collectors.toList()));
    }

    private static boolean isValidNumbers(List<Integer> numbers) {
        return !Objects.isNull(numbers) &&
                numbers.size() == LOTTO_SIZE;
    }

    public static List<LottoNumber> valueOf(Lotto lotto) {
        return lotto.lottoNumbers;
    }

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public int countMatches(Lotto lotto) {
        return toIntExact(Lotto.valueOf(lotto).stream()
                .filter(this::isContain)
                .count());
    }

    public boolean isContain(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

}
