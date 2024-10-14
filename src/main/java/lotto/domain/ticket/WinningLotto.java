package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final LottoTicket winningTicket;

    private WinningLotto(LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
    }

    public static WinningLotto of(LottoTicket winningTicket) {
        return new WinningLotto(winningTicket);
    }

    public static WinningLotto fromWinningNumbers(List<String> winningNumbers) {
        List<LottoNumber> lottoNumbers = generateLottoNumbers(winningNumbers);
        return WinningLotto.of(LottoTicket.of(lottoNumbers));
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
}
