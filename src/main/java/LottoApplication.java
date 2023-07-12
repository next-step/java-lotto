import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

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

        // 로또 만들고
        final List<Lotto> lottos = LottoGenerator.generateAutomatically(money);

        // 구매 결과 출력
        OutputView.printLottosSize(lottos);

        // 로또 출력한다.
        OutputView.printLottos(lottos);

        // 당첨 번호 입력
        final List<Integer> lottoNumbers = InputView.readLottoNumbers();
        final int lottoNumber = InputView.readLottoNumber();

        // 게임 진행해서
        final LottoResult lottoResult = play(lottos, lottoNumbers, lottoNumber);

        // 결과 출력
        OutputView.printStatistic(lottoResult, money);
    }

    private static LottoResult play(final List<Lotto> target, final List<Integer> lottoNumbers, final int lottoNumber) {
        final Lottos lottos = new Lottos(target);
        final WinningLotto winningLotto = new WinningLotto(new Lotto(lottoNumbers), new LottoNumber(lottoNumber));

        return new LottoResult(lottos.checkAllLottoResult(winningLotto));
    }
}
