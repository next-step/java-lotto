package lotto.step2.domain;

import java.util.ArrayList;

public class LottoResult {

    private WinningNumber winningNumber;
    private Lotto lotto;
    public void checkLottoTicket(WinningNumber winningNumber, Lotto lotto){

    }
    public void checkLottoNumber(ArrayList<Integer> lottoTicket) {
        for (int number : lottoTicket){

        }

    }
    public void contains(int number){
        if (winningNumber.getWinningNumbers().contains(number)){

        }
    }
}
