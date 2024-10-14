package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumbers.LOTTO_NUMBER_COUNT;

public class WinningLottoNumbers {
    private final List<Integer> lottoNumbers;

    public WinningLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호 개수는 6개입니다.");
        }

        lottoNumbers.forEach(WinningLottoNumbers::validate);

        this.lottoNumbers = lottoNumbers;
    }

    public WinningLottoNumbers(int... lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .boxed()
                .collect(Collectors.toList()));
    }

    private static void validate(int lottoNumber) {
        if (!LottoNumbers.LOTTO_NUMBER_SET.contains(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호의 범위는 1~45까지입니다.");
        }
    }

    public int getMatchedNumberCount(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers.getLottoNumbers()
                .stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }
}
