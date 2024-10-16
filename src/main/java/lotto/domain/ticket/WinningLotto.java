package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;

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

    public static WinningLotto fromWinningNumbersAndBonusNumber(List<String> winningNumbers, int bonusNumber) {
        List<LottoNumber> lottoNumbers = generateLottoNumbers(winningNumbers);
        return WinningLotto.of(LottoTicket.of(lottoNumbers), LottoNumber.of(bonusNumber));
    }

    private static List<LottoNumber> generateLottoNumbers(List<String> winningNumbers) {
        return winningNumbers.stream()
                .map(Integer::parseInt)
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
