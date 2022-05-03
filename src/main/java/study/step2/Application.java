package study.step2;

import study.step2.domain.LottoStore;
import study.step2.domain.Ticket;
import study.step2.domain.User;
import study.step2.view.InputView;
import study.step2.view.ResultView;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();
        String lottoPurchasePrice = InputView.inputLottoPurchasePrice();
        List<Ticket> tickets = lottoStore.purchaseLotto(ResultView.issueLottos(lottoPurchasePrice));
        Map<String, Long> analyzeLotto = User.analyzeLottoNumber(tickets, InputView.inputLastWeekLottoNumber());
        ResultView.printAnalysisResult(lottoPurchasePrice, analyzeLotto);
    }
}
