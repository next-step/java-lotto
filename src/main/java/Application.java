import domain.Lotto;
import domain.LottoGames;
import domain.RankRecord;
import utility.UserInput;
import view.View;

public class Application {
    public static void main(String[] args) {

        int buyInput = UserInput.tellHowManyBuy();
        LottoGames game = new LottoGames(buyInput);

        View.showLottoTickets(game.getLottos());

        Lotto winnerNumber = UserInput.getWinnerTicket();
        int bonusNumber = UserInput.inputBonusNumber();

        game.validateBonus(winnerNumber,bonusNumber);
        RankRecord record = game.getLottos().recordAllLottos(winnerNumber,bonusNumber);
        int sum = record.sumOfPrice();

        View.result(record, sum, buyInput);
    }
}
