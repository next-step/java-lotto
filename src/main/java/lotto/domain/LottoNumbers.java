package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.utils.Constants.*;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public LottoNumbers() {

    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers createAutoLottoNumbers() {
        List<Integer> defaultNumbers = IntStream.rangeClosed(NUMBER_ONE, NUMBER_FORTY_FIVE)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(defaultNumbers);
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = NUMBER_ZERO; i < NUMBER_SIX; i++) {
            randomNumbers.add(defaultNumbers.get(i));
        }
        lottoNumbers = randomNumbers.stream()
                .sorted().collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    public void validateLottoNumbersLength() {
        if (lottoNumbers.size() > NUMBER_SIX) {
            throw new IndexOutOfBoundsException(MSG_LOTTO_NUMBERS_LENGTH_ONLY_SIX);
        }
    }

    public void validateLottoNumbersOneToFortyfive() {
        lottoNumbers.forEach(lottoNumber -> {
            if (lottoNumber < NUMBER_ONE || lottoNumber > NUMBER_FORTY_FIVE) {
                throw new IndexOutOfBoundsException(MSG_LOTTO_NUMBER_ONE_TO_FORTY_FIVE);
            }
        });
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
