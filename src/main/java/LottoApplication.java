import domain.Count;
import domain.Lotto;
import domain.LottoGenerator;
import domain.LottoNumber;
import domain.LottoResult;
import domain.Lottos;
import domain.Money;
import domain.WinningLotto;
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
        final Money money = Money.valueOf(InputView.readMoney());

        //수동으로 구매할 로또 수 입력
        final Count manualPurchaseCount = new Count(InputView.readManualPurchaseCount());

        //수동으로 구매할 번호 입력
        List<List<Integer>> numberBundles = InputView.readManualLottoNumbers(manualPurchaseCount);

        // 로또 만들고
        final List<Lotto> lottos = LottoGenerator.generateLottos(money, manualPurchaseCount,
            numberBundles);

        // 구매 결과 출력
        OutputView.printPurchaseCount(lottos, manualPurchaseCount);

        // 로또 출력한다.
        OutputView.printLottos(lottos);

        // 당첨 번호 입력
        final List<Integer> lottoNumbers = InputView.readWinningLottoNumbers();
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
