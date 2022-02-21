package lotto.domain.winning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumber;

public class WinningNumbers {

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(String[] numbers, String bonusNumber) {
        validateBonusNumberDuplication(numbers, bonusNumber);
        this.winningNumbers = createWinningNumbers(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private List<LottoNumber> createWinningNumbers(String[] numbers) {
        return Arrays.stream(numbers)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    private void validateBonusNumberDuplication(String[] numbers, String bonusNumber) {
        if (Arrays.asList(numbers).contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호가 같습니다.");
        }
    }

    public List<LottoNumber> getWinningNumbers() {
        return new ArrayList<>(winningNumbers);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
