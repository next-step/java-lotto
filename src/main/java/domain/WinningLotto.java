package domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final int BONUS_AVAILABLE_MATCH_COUNT = 5;

    private LottoNumbers winningNumber;
    private Number bonusNumber;

    public WinningLotto(String[] inputWinnigNumber, int bonusNumber) {
        this.winningNumber = convertToLottoNumbers(inputWinnigNumber);
        this.bonusNumber = Number.createInstance(bonusNumber);
    }

    private LottoNumbers convertToLottoNumbers(String[] inputWinningNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (String str: inputWinningNumber) {
            numbers.add(Integer.parseInt(str));
        }

        return LottoNumbers.createInstance(numbers);
    }

    public LottoResultStatus result(Lotto lotto) { //1,2,3,4,5
        int countainsWinningNumberCount = 0;

        for( Number number : winningNumber.getNumbers()) {
            if(lotto.getLottoNumbers().contains(number)) {
                countainsWinningNumberCount++;
            }
        }

        if (countainsWinningNumberCount == BONUS_AVAILABLE_MATCH_COUNT && lotto.getLottoNumbers().contains(bonusNumber)) {
            return  LottoResultStatus.findByMatchCount(countainsWinningNumberCount, true);
        }

        return LottoResultStatus.findByMatchCount(countainsWinningNumberCount, false);
    }
}
