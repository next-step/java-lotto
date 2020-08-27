import domain.LottoGames;
import domain.WinnerNumber;
import domain.WinnerNumberManager;
import utility.UserInput;
import view.View;

public class Application {
    public static void main(String[] args) {
        int buyInput = UserInput.tellHowManyBuy();
        LottoGames game = new LottoGames(buyInput);

        View.showLottoTickets(game.getLottos());

//        WinnerNumberManager manager = UserInput.getWinnerTicket();
        WinnerNumber winnerNumber = UserInput.getWinnerTicket();

//        int sum = manager.calculateCount(game.getLottos());
        WinnerNumberManager manager = new WinnerNumberManager(winnerNumber);

        int sum = manager.calculateWinnerPrice(game.getLottos());

        View.result(manager,sum,game.getLottos().getNumOfLottos());
    }
}
