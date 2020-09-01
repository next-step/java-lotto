import domain.LottoGames;
import domain.RankRecord;
import domain.WinnerNumber;
import utility.UserInput;
import view.View;

public class Application {
    public static void main(String[] args) {

        int buyInput = UserInput.tellHowManyBuy();
        LottoGames game = new LottoGames(buyInput);

        View.showLottoTickets(game.getLottos());

        WinnerNumber winnerNumber = UserInput.getWinnerTicket();
        RankRecord record = game.getLottos().calculateWinnerPrice(winnerNumber);
        int sum = record.sumOfPrice();

        View.result(record, sum, buyInput);
    }
}
