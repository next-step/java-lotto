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
        PurchaseQuantity purchaseQuantity = getPurchaseAmount();
        LottoTicket lottoTicket = getLottoTicket(purchaseQuantity);
        LottoNumbers winningLottoNumbers = getWinningLottoNumbers();
        MatchResult matchResult = lottoTicket.match(winningLottoNumbers);
        outputView.printMatchResult(matchResult);
        outputView.printLotteryYield(purchaseQuantity.getPurchaseAmount(), matchResult.calculateTotalWinningAmount());
    }

    private PurchaseQuantity getPurchaseAmount() {
        outputView.printPurchaseAmountInputMessage();
        PurchaseQuantity purchaseQuantity = inputView.getPurchaseAmount();
        outputView.printPurchaseCount(purchaseQuantity.getQuantity());
        return purchaseQuantity;
    }

    private LottoTicket getLottoTicket(PurchaseQuantity purchaseQuantity) {
        LottoTicket lottoTicket = LottoTicket.of(lottoNumbersGenerator.generate(purchaseQuantity.getQuantity()));
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
