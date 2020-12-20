package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(int... numbers) {
        if (numbers.length != LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException();

        this.lottoNumbers = Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getSortedNumbers() {
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Set<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

    public int matchNumberCount(Lotto lotto) {
        Set<LottoNumber> resultLottoNumbers = new HashSet<>(this.lottoNumbers);
        Set<LottoNumber> compareLottoNumbers = lotto.getNumbers();
        resultLottoNumbers.retainAll(compareLottoNumbers);
        return resultLottoNumbers.size();
    }

    public boolean matchBonus(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
