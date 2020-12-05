package lotto.domain;

import java.util.List;

public class Scanner {


    private static WinningNumbers winningNumbers;
    private static LottoNumber bonusNumber;

    public Scanner(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new WinningNumbers(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public static Scanner newScanner(List<Integer> winningNumbers, int bonusNumber) {
        return new Scanner(winningNumbers, bonusNumber);
    }

    public static void scan(LottoTicket lottoTicket, LottoResult lottoResult) {
        long matchingScore = lottoTicket.getLottoNumbers()
                .stream()
                .filter(n -> winningNumbers.toIntegerList()
                        .contains(n.toInt()))
                .count();

        final boolean matchBonus = lottoTicket.getLottoNumbers()
                .stream()
                .anyMatch(n -> n.toInt() == bonusNumber.toInt());

        lottoResult.saveLottoResult(Long.valueOf(matchingScore).intValue(), matchBonus);
    }
}
