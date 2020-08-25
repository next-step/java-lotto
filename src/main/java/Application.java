import domain.Lotto;
import domain.LottoGames;
import domain.Lottos;
import utility.UserInput;
import view.View;

public class Application {
    public static void main(String[] args) {
        int tries = UserInput.init();
        Lottos lottos = new LottoGames().run(tries);

        View.showLottoTickets(lottos);
        winnerNumber = UserInput.getWinnerTicket();
    }
}
