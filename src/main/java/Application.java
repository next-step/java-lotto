import domain.LottoGames;
import domain.RankRecord;
import domain.WinnerNumber;
import utility.UserInput;
import view.View;

import java.math.BigInteger;


public class Application {
    public static void main(String[] args) {

        int buyInput = UserInput.tellHowManyBuy();
        int manual = UserInput.tellHoWManyManualBuy();

        LottoGames game = new LottoGames(buyInput,manual);
//        LottoGames game = new LottoGames(buyInput);

        View.showManualAndAutoNumber(buyInput,manual);
        View.showLottoTickets(game.getLottos());

        WinnerNumber winnerNumber = UserInput.getWinnerTicket();
        RankRecord record = winnerNumber.checkAllLottosWithWinnerLotto(game.getLottos());

        long sum = record.sumOfPrice();

        View.result(record, sum, buyInput);
    }
}
