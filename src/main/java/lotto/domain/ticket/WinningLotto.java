package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.exception.DuplicateBonusNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    private WinningLotto(LottoTicket winningTicket, LottoNumber bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(LottoTicket winningTicket, LottoNumber bonusNumber) {
        return new WinningLotto(winningTicket, bonusNumber);
    }

    public static WinningLotto fromWinningNumbersAndBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        checkBonusNumberDuplicate(winningNumbers, bonusNumber);
        return WinningLotto.of(LottoTicket.of(generateLottoNumbers(winningNumbers)), LottoNumber.of(bonusNumber));
    }

    private static void checkBonusNumberDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (hasBonusNumberDuplicated(winningNumbers, bonusNumber)) {
            throw new DuplicateBonusNumberException();
        }
    }

    private static boolean hasBonusNumberDuplicated(List<Integer> winningNumbers, int bonusNumber) {
        return new HashSet<>(winningNumbers).contains(bonusNumber);
    }

    private static List<LottoNumber> generateLottoNumbers(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public boolean winningMatch(LottoNumber number) {
        return winningTicket.match(number);
    }

    public boolean isBonusMatch(LottoNumber number) {
        return bonusNumber.equals(number);
    }
}
