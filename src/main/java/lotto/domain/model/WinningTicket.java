package lotto.domain.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningTicket {
    private final List<LottoNumber> winNumbers;
    private final LottoNumber bonusNumber;

    public WinningTicket(List<Integer> winNumbers, int bonusNumber) {
        validate(winNumbers, bonusNumber);
        this.winNumbers = winNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validate(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Bonus number must not be in winning numbers.");
        }
    }

    public List<LottoNumber> getWinNumbers() {
        return winNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
