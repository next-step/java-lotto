package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LastWeekWinningNumber {

    private final List<LottoNumber> lastWeekNumbers;
    private final LottoNumber bonusNumber;
    public LastWeekWinningNumber(String lastWeekNumbers, String bonusNumber) {
        this.lastWeekNumbers = Arrays.stream(lastWeekNumbers.split(","))
                .map(Integer::valueOf)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        this.bonusNumber = new LottoNumber(Integer.parseInt(bonusNumber));
    }

    public List<LottoNumber> getLastWeekNumbers() {
        return lastWeekNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
