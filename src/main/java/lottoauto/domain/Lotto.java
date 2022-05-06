package lottoauto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    private List<Integer> numbers;
    private int matchCount;
    private boolean isBonusNumberSame = false;

    public Lotto(List<Integer> inputNumbers) {
        if(inputNumbers.size() > LottoGenerator.LOTTO_LENGTH){
            throw new IllegalArgumentException("로또의 숫자는 6개 입니다.");
        }
        this.numbers = inputNumbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public void match(WinningLotto winningLotto) {
        matchCount = 0;
        for (Integer number : winningLotto.getWinnerLottoNumbers()) {
            if(numbers.contains(number)) matchCount += 1;
        }
        if (numbers.contains(winningLotto.getBonusNumber())){
            isBonusNumberSame = true;
        }
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
