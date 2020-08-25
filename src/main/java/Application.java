import domain.LottoGames;
import domain.Lottos;
import domain.WinnerNumber;
import utility.UserInput;
import view.View;

public class Application {
    public static void main(String[] args) {
        int buyInput = UserInput.tellHowManyBuy();
        LottoGames game = new LottoGames(buyInput);
        Lottos lottos = game.makeLottoTicket();

        View.showLottoTickets(lottos);

        WinnerNumber winnerNumber = UserInput.getWinnerTicket();
        int sum = winnerNumber.calculateCount(game.getTries(),lottos);

        View.result(winnerNumber,sum,game.getTries());
    }
}
