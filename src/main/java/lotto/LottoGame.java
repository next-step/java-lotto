package lotto;

import java.util.ArrayList;
import java.util.Arrays;

public class LottoGame {
    private static Store lottoStore;
    private static ArrayList<LottoTicket> tickets;
    private static final int LOTTO_LEVEL_1=1;
    private static final int LOTTO_LEVEL_2=2;
    private static final int LOTTO_LEVEL_3=3;
    private static final int LOTTO_LEVEL_4=4;
    private static final int LOTTO_LEVEL_5=5;
    private static final int LOTTO_LEVEL_COUNT=3;
    private static final int LOTTO_LEVEL_LOSE=0;

    public LottoGame(int money) {
        lottoStore = new Store();
        tickets = lottoStore.buyLotto2(money);
    }

    private void check(LottoTicket ticket, String winNumber, String bonusNumber) {

        String[] lottoNumber = ticket.getLottoNumber().split(",");
        String[] winNumbers = winNumber.split(",");

        int winCount = 0;
        for (int ii = 0; ii < winNumbers.length; ii++)
            if (Arrays.asList(lottoNumber).contains(winNumbers[ii]))
                winCount++;
        winCount -= LOTTO_LEVEL_COUNT;
        if (winCount < LOTTO_LEVEL_LOSE) {
            ticket.setWinLevel(LOTTO_LEVEL_LOSE);
            return;
        }
        int winLevel = LOTTO_LEVEL_5;
        winLevel -= winCount;
        if (winLevel < LOTTO_LEVEL_3) {
            ticket.setWinLevel(winLevel);
            return;
        }
        if (winLevel == LOTTO_LEVEL_2) {
            ticket.setWinLevel(LOTTO_LEVEL_1);
            return;
        }
        if (Arrays.asList(lottoNumber).contains(bonusNumber))
            winLevel--;
        ticket.setWinLevel(winLevel);
        return;
    }

    public void checkWin(String winNumber, String bonusNumber) {
        for (int ii = 0; ii < tickets.size(); ii++)
            check(tickets.get(ii), winNumber, bonusNumber);
    }

    public  ArrayList<LottoTicket> getTickets() {
        return tickets;
    }
}
