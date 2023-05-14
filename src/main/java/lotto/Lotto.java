package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private List<LottoNumber> numbers = new ArrayList<>();
    public static final int LOTTO_PRICE = 1000;

    public static final int LOTTO_NUMBER_COUNT = 6;

    public Lotto() {
        this.numbers = LottoNumber.generate();
    }

    public Lotto(Set<Integer> lottoNumbers) {
        validateNumberCount(lottoNumbers);
        for (int lottoNumber : lottoNumbers) {
            this.numbers.add(LottoNumber.of(lottoNumber));
        }
    }

    private void validateNumberCount(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야만 합니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

    private int matchCount(List<LottoNumber> winNumbers) {
        Set<LottoNumber> set = new HashSet<>(numbers);
        return (int) set.stream()
                .filter(winNumbers::contains)
                .count();
    }

    private boolean hasNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public KLottoRank checkRank(WinNumber winNumbers) {
        return KLottoRank.find(matchCount(winNumbers.getWinNumbers()), hasNumber(winNumbers.getBonusNumber()));
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
