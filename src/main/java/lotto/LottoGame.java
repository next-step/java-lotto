package lotto;

import java.util.ArrayList;
import java.util.Arrays;

public class LottoGame {
    private static Store lottoStore;
    private static ArrayList<LottoTicket> tickets;
    public static final int LOTTO_LEVEL_1=1;
    public static final int LOTTO_LEVEL_2=2;
    public static final int LOTTO_LEVEL_3=3;
    public static final int LOTTO_LEVEL_4=4;
    public static final int LOTTO_LEVEL_5=5;
    private static final int LOTTO_LEVEL_COUNT=3;
    private static final int LOTTO_LEVEL_LOSE=0;

    public LottoGame(int money) {
        lottoStore = new Store();
        tickets = lottoStore.buyLotto2(money);
    }

    private void check(LottoTicket ticket, String winNumber, String bonusNumber) {
        String newTicketNumber = ticket.getLottoNumber().replaceAll("[\\[\\]@$^ ]", "");
        String newWinNumber = winNumber.replaceAll(" ", "");
        int[] lottoNumber = Arrays.stream(newTicketNumber.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] winNumbers = Arrays.stream(newWinNumber.split(",")).mapToInt(Integer::parseInt).toArray();

        int winCount = 0;
        for (int number: winNumbers) {
            if (Arrays.stream(lottoNumber).anyMatch(i -> i == number))
                winCount++;
        }

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
        if (Arrays.stream(lottoNumber).anyMatch(i -> i == Integer.parseInt(bonusNumber)))
            winLevel--;
        ticket.setWinLevel(winLevel);
        return;
    }

    public void checkWin(String winNumber, String bonusNumber) {
        for (LottoTicket newTicket : tickets)
            check(newTicket, winNumber, bonusNumber);
    }

    public  ArrayList<LottoTicket> getTickets() {
        return tickets;
    }
}
