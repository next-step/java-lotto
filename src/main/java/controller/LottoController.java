package controller;

import domain.Lotto;
import domain.LottoGenerator;
import domain.LottoStatistics;
import domain.Price;
import util.View;
import view.ResultView;

import java.util.List;

public class LottoController {

    private final static String MESSAGE_FOR_PURCHASING_LOTTO = "구입금액을 입력해 주세요.";
    private final static String MESSAGE_FOR_WINNING_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    public static void main(String[] args) {
        // 입력
        View.outputView.println(MESSAGE_FOR_PURCHASING_LOTTO);
        Price purchasePrice = new Price(View.inputView.inputInt());

        // 로또 생성
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        List<Lotto> lottos = lottoGenerator.generate(purchasePrice);
        ResultView.printLottos(lottos);

        // 중간 결과 출력
        View.outputView.println(MESSAGE_FOR_WINNING_LOTTO_NUMBERS);

        // 당첨 로또 번호 입력
        List<Integer> numbers = View.inputView.inputStringsToIntegers(",");

        // 로또 생성 및 결과 분석
        Lotto winningLotto = lottoGenerator.generate(numbers);
        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winningLotto, purchasePrice);
        lottoStatistics.analyzeRank();

        // 결과 출력
        ResultView.printStatistics(lottoStatistics);
    }
}
