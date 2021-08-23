package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            LottoTicket lottoTicket = createLottoTicket(purchaseMoney, getManualPurchaseQuantity());
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

    private LottoTicket createLottoTicket(Money purchaseMoney, PurchaseQuantity manualPurchaseQuantity) {
        List<LottoNumbers> manualLottoNumbers = getManualLottoNumbers(manualPurchaseQuantity);
        List<LottoNumbers> automaticLottoNumbers = lottoNumbersGenerator.generate(purchaseMoney, manualPurchaseQuantity);
        LottoTicket lottoTicket = LottoTicket.of(concat(manualLottoNumbers, automaticLottoNumbers));
        outputView.printPurchaseQuantity(manualLottoNumbers.size(), automaticLottoNumbers.size());
        outputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private List<LottoNumbers> concat(List<LottoNumbers> manualLottoNumbers, List<LottoNumbers> automaticLottoNumbers) {
        return Stream.of(manualLottoNumbers, automaticLottoNumbers)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
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
