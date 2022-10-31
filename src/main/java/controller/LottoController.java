package controller;

import domain.*;
import util.View;
import view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    private final static String MESSAGE_FOR_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private final static String MESSAGE_FOR_NUMBER_OF_MANUAL_LOTTO = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final static String MESSAGE_FOR_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private final static String MESSAGE_FOR_WINNING_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private final static String MESSAGE_FOR_BONUS_LOTTO_NUMBER = "보너스 볼을 입력해 주세요.";

    private final static LottoGenerator LOTTO_GENERATOR = LottoGenerator.getInstance();
    public static void main(String[] args) {
        // 입력
        View.outputView.println(MESSAGE_FOR_PURCHASE_PRICE);
        Price purchasePrice = new Price(View.inputView.inputInt());

        // 수동 로또 생성
        View.outputView.println(MESSAGE_FOR_NUMBER_OF_MANUAL_LOTTO);
        int numberOfManualLotto = View.inputView.inputInt();

        View.outputView.println(MESSAGE_FOR_MANUAL_LOTTO_NUMBER);
        List<List<Integer>> manualLottoNumbers = View.inputView.inputStringsToIntegers(numberOfManualLotto, ",");
        List<Lotto> manualLottos = LOTTO_GENERATOR.generateLotto(numberOfManualLotto, manualLottoNumbers);

        // 자동 로또 생성
        Price manualPurchasePrice = LOTTO_GENERATOR.calculatePrice(manualLottos);
        List<Lotto> autoLottos = LOTTO_GENERATOR.generateLotto(purchasePrice.minus(manualPurchasePrice));

        // 중간 결과 출력
        ResultView.printLottos(autoLottos, manualLottos);

        // 당첨 로또 번호 입력
        View.outputView.println(MESSAGE_FOR_WINNING_LOTTO_NUMBERS);
        List<Integer> numbers = View.inputView.inputStringsToIntegers(",");

        // 보너스볼 입력
        View.outputView.println(MESSAGE_FOR_BONUS_LOTTO_NUMBER);
        Integer bonusNumber = View.inputView.inputInt();

        List<Lotto> totalLottos = Stream.of(autoLottos, manualLottos)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        // 로또 생성 및 결과 분석
        WinningLotto winningLotto = LOTTO_GENERATOR.generateWinningLotto(numbers, bonusNumber);
        LottoStatistics lottoStatistics = new LottoStatistics(totalLottos, winningLotto);
        lottoStatistics.analyzeRank();

        // 결과 출력
        ResultView.printStatistics(purchasePrice, lottoStatistics);
    }
}
