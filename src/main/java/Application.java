import domain.LottoGames;
import domain.WinnerNumber;
import utility.UserInput;
import view.View;

public class Application {
    public static void main(String[] args) {

        int price = UserInput.tellHowManyBuy();
        LottoGames game = new LottoGames(price);

        View.showLottoTickets(game.getLottos());

        WinnerNumber winnerNumber = UserInput.getWinnerTicket();
        int sum = game.calculateWinnerPrice(winnerNumber);

        View.result(game, sum);
    }
}
