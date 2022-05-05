package lottoauto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    private final int bonusNumber;
    private boolean isBonusNumberSame = false;
    private List<Integer> numbers;
    private int matchCount;

    public Lotto(List<Integer> inputNumbers, int bonusNumber) {
        if(inputNumbers.size() > LottoGenerator.LOTTO_LENGTH){
            throw new IllegalArgumentException("로또의 숫자는 6개 입니다.");
        }
        this.numbers = inputNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public void match(Lotto winnerLotto) {
        matchCount = 0;
        for (Integer number : winnerLotto.getNumbers()) {
            if(numbers.contains(number)) matchCount += 1;
        }
        if (winnerLotto.getBonusNumber() == getBonusNumber()){
            isBonusNumberSame = true;
        }
    }

    private int getBonusNumber() {
        return bonusNumber;
    }

    public LottoStatus isStatus() {
        if (matchCount == 3){
            return LottoStatus.FIFTH;
        }
        if (matchCount == 4){
            return LottoStatus.FOURTH;
        }
        if (matchCount == 5 && isBonusNumberSame){
            return LottoStatus.SECOND;
        }
        if (matchCount == 5){
            return LottoStatus.THIRD;
        }
        if (matchCount == 6){
            return LottoStatus.FIRST;
        }
        return LottoStatus.NOTHING;
    }
}
