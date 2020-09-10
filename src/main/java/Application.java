import domain.*;
import utility.UserInput;
import view.View;

public class Application {
    public static void main(String[] args) {

        Money buyInput = UserInput.tellHowManyBuy();
        int totalTries = buyInput.getLottoTries();
        int manualTries = UserInput.tellHoWManyManualBuy();
        Lottos manuallyCreated = UserInput.createManualLotto(manualTries);
        int autoTries = totalTries - manualTries;

        LottoGames game = new LottoGames(autoTries, manuallyCreated);

        View.showManualAndAutoNumber(autoTries, manualTries);
        View.showLottoTickets(game.getLottos());

        WinnerNumber winnerNumber = UserInput.getWinnerTicket();
        RankRecord record = winnerNumber.checkAllLottosWithWinnerLotto(game.getLottos());

        Money sum = record.sumOfPrice();

        View.result(record, sum, totalTries);
    }
}
