package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.utils.Constants.*;

public class LottoNumbers {
    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    public LottoNumbers() {

    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        lottoNumbers.forEach( lottoNumber -> {
            this.lottoNumbers.add(LottoNumber.of(lottoNumber));
        });
    }

    public LottoNumbers createAutoLottoNumbers(DefaultLottoNumbers defaultLottoNumbers) {
        defaultLottoNumbers.shuffleNumbers();
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = NUMBER_ZERO; i < NUMBER_SIX; i++) {
            randomNumbers.add(defaultLottoNumbers.getDefaultLottoNumberByIndex(i));
        }
        return new LottoNumbers(sortNumbers(randomNumbers));
    }

    public LottoNumbers createManualLottoNumbers(List<String> inputNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        inputNumbers.forEach(inputNumber -> {
            lottoNumbers.add(Integer.parseInt(inputNumber));
        });

        return new LottoNumbers(sortNumbers(lottoNumbers));
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> lottoNumbers = numbers.stream()
                .sorted().collect(Collectors.toList());
        return lottoNumbers;
    }

    public void validateLottoNumbersLength() {
        if (lottoNumbers.size() > NUMBER_SIX) {
            throw new IllegalArgumentException(MSG_LOTTO_NUMBERS_LENGTH_ONLY_SIX);
        }
    }

    public boolean isIncludeBonusNumber(int bonusNumber) {
        return lottoNumbers.contains(LottoNumber.of(bonusNumber));
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(new ArrayList(lottoNumbers));
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
