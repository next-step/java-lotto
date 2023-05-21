package step4.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> numbers) {
        validateLottoNumbers(numbers);
        this.lottoNumbers = numbers;
    }

    private void validateLottoNumbers(List<LottoNumber> numbers) {
        HashSet<LottoNumber> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %s개여야 합니다.", LOTTO_SIZE));
        }
    }

    public static Lotto of(List<Integer> integers) {
        return new Lotto(integers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}