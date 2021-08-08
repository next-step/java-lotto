package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSimulator {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoSimulator(InputView inputView, OutputView outputView, LottoNumbersGenerator lottoNumbersGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    private void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        LottoTicket lottoTicket = getLottoTicket(purchaseAmount);
        LottoNumbers winningLottoNumbers = getWinningLottoNumbers();
    }

    private PurchaseAmount getPurchaseAmount() {
        outputView.printPurchaseAmountInputMessage();
        PurchaseAmount purchaseAmount = inputView.getPurchaseAmount();
        outputView.printPurchaseCount(purchaseAmount.getPurchaseQuantity());
        return purchaseAmount;
    }

    private LottoTicket getLottoTicket(PurchaseAmount purchaseAmount) {
        LottoTicket lottoTicket = LottoTicket.of(lottoNumbersGenerator.generate(purchaseAmount.getPurchaseQuantity()));
        outputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private LottoNumbers getWinningLottoNumbers() {
        outputView.printWinningLottoNumbersInputMessage();
        return inputView.getWinningLottoNumbers();
    }

    public static void main(String[] args) {
        try {
            InputView inputView = InputView.of(System.in);
            OutputView outputView = OutputView.of(System.out);
            LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.of(createLottoNumbers());
            LottoSimulator lottoSimulator = new LottoSimulator(inputView, outputView, lottoNumbersGenerator);
            lottoSimulator.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<LottoNumber> createLottoNumbers() {
        return IntStream.rangeClosed(LottoNumber.getLowerBound(), LottoNumber.getUpperBound())
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
