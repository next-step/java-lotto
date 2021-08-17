package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        PurchaseQuantity purchaseQuantity = getPurchaseQuantity();
        LottoTicket lottoTicket = getLottoTicket(purchaseQuantity);
        WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();
        MatchResult matchResult = lottoTicket.match(winningLottoNumbers);
        outputView.printMatchResult(matchResult);
        outputView.printLotteryYield(purchaseQuantity.getPurchaseAmount(), matchResult.calculateTotalWinningAmount());
    }

    private PurchaseQuantity getPurchaseQuantity() {
        outputView.printPurchaseAmountInputMessage();
        PurchaseQuantity purchaseQuantity = inputView.getPurchaseAmount();
        outputView.printPurchaseCount(purchaseQuantity.getQuantity());
        return purchaseQuantity;
    }

    private LottoTicket getLottoTicket(PurchaseQuantity purchaseQuantity) {
        LottoTicket lottoTicket = LottoTicket.of(lottoNumbersGenerator.generate(purchaseQuantity.getQuantity()));
        outputView.printLottoTicket(lottoTicket.getLottoNumbersList());
        return lottoTicket;
    }

    private WinningLottoNumbers getWinningLottoNumbers() {
        outputView.printWinningLottoNumbersInputMessage();
        LottoNumbers winningLottoNumbers =  inputView.getWinningLottoNumbers();
        outputView.printBonusBallInputMessage();
        LottoNumber bonusBall = inputView.getBonusBall();
        return WinningLottoNumbers.of(winningLottoNumbers, bonusBall);
    }
}
