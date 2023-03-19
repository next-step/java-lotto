package lottoGame;

import java.util.List;

public class InputView {
    public static void printTicket(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }
}
