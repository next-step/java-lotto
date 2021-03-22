package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoPlay.LOTTO_LENGTH;

public class WinningNumber {

    private final Set<LottoNumber> winningNumber;
    private final LottoNumber bonusBall;

    public WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        this.bonusBall = null;

        isValidate();
    }

    public WinningNumber(List<Integer> winningNumber, int bonusBall) {
        if (winningNumber.contains(bonusBall)) {
            throw new IllegalArgumentException();
        }

        this.winningNumber = winningNumber.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        this.bonusBall = new LottoNumber(bonusBall);

        isValidate();
    }

    public List<LottoNumber> getWinningNumber() {
        return new ArrayList<>(winningNumber);
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    public void isValidate() {
        if (winningNumber.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
