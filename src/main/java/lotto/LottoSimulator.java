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
        outputView.printPurchaseCount(purchaseAmount.getPurchaseQuantity());
        LottoTicket lottoTicket = LottoTicket.of(getLottoNumbers(purchaseAmount));
        outputView.printLottoTicket(lottoTicket);
    }

    private PurchaseAmount getPurchaseAmount() {
        outputView.printPurchaseAmountInputMessage();
        return inputView.getPurchaseAmount();
    }

    private List<LottoNumbers> getLottoNumbers(PurchaseAmount purchaseAmount) {
        return lottoNumbersGenerator.generate(purchaseAmount.getPurchaseQuantity());
    }

    public static void main(String[] args) {
        InputView inputView = InputView.of(System.in);
        OutputView outputView = OutputView.of(System.out);
        LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.of(createLottoNumbers());
        LottoSimulator lottoSimulator = new LottoSimulator(inputView, outputView, lottoNumbersGenerator);
        lottoSimulator.run();
    }

    private static List<LottoNumber> createLottoNumbers() {
        return IntStream.rangeClosed(LottoNumber.getLowerBound(), LottoNumber.getUpperBound())
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
