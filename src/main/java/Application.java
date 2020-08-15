import lotto.LottoGame;
import lotto.domain.RandomLottoCreator;
import lotto.domain.LottoResultNumber;
import lotto.ui.LottoInput;
import lotto.ui.LottoResultInput;

public class Application {
    public static void main(String[] args) {

        LottoInput lottoInput = new LottoInput(20000);

        LottoGame lottoGame = new LottoGame(lottoInput.getMoney(), RandomLottoCreator.createLottoList(lottoInput.getMoney()));
        lottoGame.buy();

        LottoResultInput lottoResultInput = new LottoResultInput(
                new LottoResultNumber(RandomLottoCreator.createTicket())
        );

        lottoGame.winning(lottoResultInput.getLottoResultNumber());
    }
}
