import controller.LottoController;
import domain.LottoNumbers;
import domain.Lottos;
import view.InputView;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int price = inputView.inputPrice();

        LottoController controller = new LottoController(price);
        Lottos lottos = controller.initLottos();

        LottoNumbers winningNumbers = new LottoNumbers()
                .createWinningNumbers(inputView.inputLastWinningNumber());

//        Lotto.createLotto(winningNumbers);

//        controller.compileLottoStatistics(winningNumbers, lottos);
    }
}
