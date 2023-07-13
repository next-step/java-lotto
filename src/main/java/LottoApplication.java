import domain.Lotto;
import domain.LottoGenerator;
import domain.LottoNumber;
import domain.LottoResult;
import domain.Lottos;
import domain.WinningLotto;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("예상하지 못한 예외가 발생했습니다.");
        }
    }

    private static void run() {
        // 가격 입력
        final long money = InputView.readMoney();

        //수동으로 구매할 로또 수 입력
        final long manualPurchaseCount = InputView.readManualPurchaseCount();

        //수동으로 구매할 번호 입력
        List<List<Integer>> numberBundles = new ArrayList<>();
        InputView.printPromptMessageForManualPurchaseLottoNumbers();

        for (int count = 0; count < manualPurchaseCount; count++) {
            numberBundles.add(InputView.readLottoNumbers());
        }

        // 로또 만들고
        final List<Lotto> lottos = LottoGenerator.generateLottosManuallyAndThenAutomatically(money,
            manualPurchaseCount, numberBundles);

        // 구매 결과 출력
        OutputView.printLottosSize(lottos, manualPurchaseCount);

        // 로또 출력한다.
        OutputView.printLottos(lottos);

        // 당첨 번호 입력
        InputView.printPromptMessageForWinningLottoNumbers();
        final List<Integer> lottoNumbers = InputView.readLottoNumbers();
        final int lottoNumber = InputView.readLottoNumber();

        // 게임 진행해서
        final LottoResult lottoResult = play(lottos, lottoNumbers, lottoNumber);

        // 결과 출력
        OutputView.printStatistic(lottoResult, money);
    }

    private static LottoResult play(final List<Lotto> target, final List<Integer> lottoNumbers,
        final int lottoNumber) {
        final Lottos lottos = new Lottos(target);
        final WinningLotto winningLotto = new WinningLotto(new Lotto(lottoNumbers),
            new LottoNumber(lottoNumber));

        return new LottoResult(lottos.checkAllLottoResult(winningLotto));
    }
}
