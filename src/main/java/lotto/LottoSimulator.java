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
        PurchaseQuantity totalPurchaseQuantity = getTotalPurchaseQuantity();
        PurchaseQuantity manualPurchaseQuantity = getManualPurchaseQuantity();
        // TODO: 수동으로 구매할 번호 입력
        // TODO: 수동/자동 구매한 로또 수 출력
        outputView.printPurchaseCount(totalPurchaseQuantity.getQuantity());
        LottoTicket lottoTicket = getLottoTicket(totalPurchaseQuantity);
        WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();
        MatchResult matchResult = lottoTicket.match(winningLottoNumbers);
        outputView.printMatchResult(matchResult);
        outputView.printLotteryYield(totalPurchaseQuantity.getPurchaseAmount(), matchResult.calculateTotalWinningAmount());
    }

    private PurchaseQuantity getManualPurchaseQuantity() {
        outputView.printManualPurchaseQuantityInputMessage();
        return inputView.getManualPurchaseQuantity();
    }

    private PurchaseQuantity getTotalPurchaseQuantity() {
        outputView.printPurchaseAmountInputMessage();
        return inputView.getTotalPurchaseQuantity();
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
