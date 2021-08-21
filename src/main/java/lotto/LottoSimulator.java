package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoSimulator {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public static void main(String[] args) {
        try {
            InputView inputView = InputView.of(System.in);
            OutputView outputView = OutputView.of(System.out);
            LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.rangeClosed(LottoNumber.getLowerBound(), LottoNumber.getUpperBound());
            LottoSimulator lottoSimulator = new LottoSimulator(inputView, outputView, lottoNumbersGenerator);
            lottoSimulator.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LottoSimulator(InputView inputView, OutputView outputView, LottoNumbersGenerator lottoNumbersGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    private void run() {
        try {
            Money purchaseMoney = getPurchaseMoney();
            PurchaseQuantity manualPurchaseQuantity = getManualPurchaseQuantity();
            PurchaseQuantity automaticPurchaseQuantity = PurchaseQuantity.withAutomatic(purchaseMoney, manualPurchaseQuantity);
            LottoTicket lottoTicket = createLottoTicket(manualPurchaseQuantity, automaticPurchaseQuantity);
            WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();
            MatchResult matchResult = lottoTicket.match(winningLottoNumbers);
            printMatchResult(purchaseMoney, matchResult);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            run();
        }
    }

    private Money getPurchaseMoney() {
        outputView.printPurchaseAmountInputMessage();
        return inputView.getPurchaseMoney();
    }

    private PurchaseQuantity getManualPurchaseQuantity() {
        outputView.printManualPurchaseQuantityInputMessage();
        return inputView.getManualPurchaseQuantity();
    }

    private LottoTicket createLottoTicket(PurchaseQuantity manualPurchaseQuantity, PurchaseQuantity automaticPurchaseQuantity) {
        List<LottoNumbers> lottoNumbers = getManualLottoNumbers(manualPurchaseQuantity);
        lottoNumbers.addAll(lottoNumbersGenerator.generate(automaticPurchaseQuantity));
        LottoTicket lottoTicket = LottoTicket.of(lottoNumbers);
        outputView.printPurchaseQuantity(manualPurchaseQuantity, automaticPurchaseQuantity);
        outputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private List<LottoNumbers> getManualLottoNumbers(PurchaseQuantity manualPurchaseQuantity) {
        outputView.printManualLottoNumbersInputMessage();
        return inputView.getManualLottoNumbers(manualPurchaseQuantity.getQuantity());
    }

    private WinningLottoNumbers getWinningLottoNumbers() {
        outputView.printWinningLottoNumbersInputMessage();
        LottoNumbers winningLottoNumbers =  inputView.getLottoNumbers();
        outputView.printBonusBallInputMessage();
        LottoNumber bonusBall = inputView.getBonusBall();
        return WinningLottoNumbers.of(winningLottoNumbers, bonusBall);
    }

    private void printMatchResult(Money purchaseMoney, MatchResult matchResult) {
        outputView.printMatchResult(matchResult);
        outputView.printLotteryYield(purchaseMoney, matchResult.calculateTotalWinningAmount());
    }
}
