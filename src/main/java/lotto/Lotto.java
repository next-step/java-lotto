package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private List<LottoNumber> numbers = new ArrayList<>();
    public static final int LOTTO_PRICE = 1000;

    public Lotto() {
        this.numbers = LottoNumber.generate();
    }

    public Lotto(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            this.numbers.add(LottoNumber.of(lottoNumber));
        }
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

    private int matchCount(List<LottoNumber> winNumbers) {
        Set<LottoNumber> set = new HashSet<>(numbers);
        return (int) winNumbers.stream()
                .filter(set::contains)
                .count();
    }

    private boolean hasNumber(int bonusNumber) {
        return numbers.contains(LottoNumber.of(bonusNumber));
    }

    public KLottoRank checkRank(WinNumber winNumbers) {
        return KLottoRank.find(matchCount(winNumbers.getWinNumbers()), hasNumber(winNumbers.getBonusNumber()));
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
