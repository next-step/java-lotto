package lotto.step2.domain;

import java.util.List;

public class LottoTicket {

    private static List<Integer> lottoNumber;
    private static int matchCount;

    public LottoTicket() {
        this.lottoNumber = LottoMachine.mixLottoNumbers();
    }

    public static int matchWinningNumber(WinningNumber winningNumber) {
        for (int num : lottoNumber) {
            isContainNumber(winningNumber, num);
        }

        return matchCount;
    }

    public static void isContainNumber(WinningNumber winningNumber, int num) {
        if (winningNumber.getWinningNumbers().contains(num)) {
            matchCount++;
        }
    }
}
