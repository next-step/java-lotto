import domain.LottoGames;
import domain.Lottos;
import domain.RankRecord;
import domain.WinnerNumberManager;
import utility.UserInput;
import view.View;

public class Application {
    public static void main(String[] args) {
        int buyInput = UserInput.tellHowManyBuy();
        LottoGames game = new LottoGames(buyInput);
        Lottos lottos = game.makeLottoTicket();

        View.showLottoTickets(lottos);

        WinnerNumberManager manager = UserInput.getWinnerTicket();
        int sum = manager.calculateCount(game.getTries(),lottos);

        View.result(manager,sum,game.getTries());
    }
}
