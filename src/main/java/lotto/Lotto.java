package lotto;

import java.util.*;

public class Lotto {

    private final Set<LottoNumber> lottoNumbers;


    public Lotto() {
        this(LottoNumberGenerator.generateLottoNumbers());
    }

    public Lotto(int[] numbers) {
        checkLottoNumberSize(numbers);
        lottoNumbers = Set.of(
                Arrays.stream(numbers)
                        .mapToObj(LottoNumber::new)
                        .toArray(LottoNumber[]::new)
        );
    }

    private void checkLottoNumberSize(int[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("로또는 총 6개의 숫자로 구성되어 있습니다.");
        }
    }

    public Lotto(String numberString) {
        this(parseIntsFromString(numberString));
    }


    private static int[] parseIntsFromString(String numberString) {
        return Arrays.stream(numberString.split(","))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }

    public int[] getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }
}
