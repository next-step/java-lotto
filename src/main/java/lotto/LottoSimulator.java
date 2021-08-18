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
        PurchaseQuantity totalPurchaseQuantity = getTotalPurchaseQuantity();
        PurchaseQuantity manualPurchaseQuantity = getManualPurchaseQuantity();
        LottoTicket lottoTicket = createLottoTicket(manualPurchaseQuantity, totalPurchaseQuantity.subtract(manualPurchaseQuantity));
        WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();
        MatchResult matchResult = lottoTicket.match(winningLottoNumbers);
        printMatchResult(totalPurchaseQuantity, matchResult);
    }

    private PurchaseQuantity getTotalPurchaseQuantity() {
        outputView.printPurchaseAmountInputMessage();
        return inputView.getTotalPurchaseQuantity();
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
        outputView.printLottoTicket(lottoTicket.getLottoNumbersList());
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

    private void printMatchResult(PurchaseQuantity totalPurchaseQuantity, MatchResult matchResult) {
        outputView.printMatchResult(matchResult);
        outputView.printLotteryYield(totalPurchaseQuantity.getPurchaseAmount(), matchResult.calculateTotalWinningAmount());
    }
}
