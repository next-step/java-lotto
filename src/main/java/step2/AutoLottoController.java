package step2;

import step2.domain.AutoLottoMatchCount;
import step2.domain.Lotto;
import step2.domain.Prize;
import step2.domain.User;
import step2.util.StringUtil;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Iterator;

public class AutoLottoController {

    InputView inputView;
    ResultView resultView;
    User user;
    Lotto defaultLotto;
    AutoLottoMatchCount autoLottoMatchCount;

    public AutoLottoController() {
        inputView = new InputView();
        resultView = new ResultView();
        user = new User();
        defaultLotto = new Lotto();
        autoLottoMatchCount = new AutoLottoMatchCount();
    }

    public void run() {
        int lottoCount = inputView.inputPrize();
        resultView.displayLottoCount(lottoCount);

        buyLotto(lottoCount);

        Lotto winningLotto = new Lotto(StringUtil.stringToList(inputView.inputWinningLotto()));

        lottery(winningLotto);

        winningStatistics(lottoCount);
    }

    private void winningStatistics(int lottoCount) {
        // 당첨통계 랜더링
        int total = 0 ;
        Iterator<Integer> lottoMatchKey =
                autoLottoMatchCount.getLottoMatchCount().keySet().iterator();
        while (lottoMatchKey.hasNext()){
            Integer number = lottoMatchKey.next();
            Prize prize = Prize.of(number);
            System.out.println(String.format("%d 개 일치(%d원)- %d개",number,prize.getPrize(),autoLottoMatchCount.getLottoMatchCount().get(number)));

            total += (prize.getPrize() * autoLottoMatchCount.getLottoMatchCount().get(number));
        }

        // 수익률
        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 떄문에 결과적으로 손해라는 의미임", (double)total / lottoCount));
    }


    private void buyLotto(int count) {
        for (int i = 0; i < count; i++) {
            user.buyLottos(defaultLotto);
        }
        displayLotto();
    }

    private void displayLotto() {
        for (Lotto lotto : user.getLottoList()) {
            resultView.displayLotto(lotto);
        }
    }

    private void lottery(Lotto winningLotto) {
        for (Lotto lotto : user.getLottoList()) {
            autoLottoMatchCount.lottoCountPlus(user.winningConfirm(winningLotto, lotto));
        }
    }
}
