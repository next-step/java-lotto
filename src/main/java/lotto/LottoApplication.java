package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class LottoApplication {
    private static final String NUMBER_SEPERATOR = ",";

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoNumbersGenerater numbersGenerater;

    private LottoResult lottoResult;

    public LottoApplication(final InputView inputView, final ResultView resultView, final LottoNumbersGenerater numbersGenerater) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.numbersGenerater = numbersGenerater;
    }

    public void run(){
        int purchaseAmount = inputView.getPurchaseAmountFromUser();

        Lottos lottos = buyLotto(purchaseAmount);
        resultView.showLottos(lottos);

        WinningNumbers winningNumbers = createWinningNumbers();

        this.lottoResult = new LottoResult(lottos, winningNumbers);
        showLottoResult(this.lottoResult);
        showLottoProfit(purchaseAmount);
    }

    private Lottos buyLotto(int purchaseAmount){
        LottoMachine machine = new LottoMachine(purchaseAmount);

        List<String> manualNumbers = inputView.getManualLottosFromUser();
        Lottos manualLottos = machine.buyManualLottos(manualNumbers);
        Lottos autoLottos = machine.buyAutoLottos(numbersGenerater);

        resultView.showLottoCount(manualLottos.count(), autoLottos.count());
        manualLottos.add(autoLottos);
        return manualLottos;
    }

    private WinningNumbers createWinningNumbers() {
        String numbers = inputView.getWinningNumbersFromUser();
        int bonusBall = inputView.getBonusBallFromUser();
        return WinningNumbers.create(convertStringToLottoNumber(numbers), bonusBall);
    }

    private Set<LottoNumber> convertStringToLottoNumber(String numbers){
        return Arrays.stream(splitNumbers(numbers))
                .map(Integer::parseInt)
                .map(LottoNumber::valueOf)
                .collect(toSet());
    }

    private String[] splitNumbers(String numbers) {
        return numbers.replace(" ", "").split(NUMBER_SEPERATOR);
    }

    private void showLottoResult(LottoResult lottoResult) {
        resultView.showLottoResult(lottoResult);
    }

    private void showLottoProfit(int purchaseAmount){
        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);
        resultView.showLottoProfit(profitRate);
        showProfitStatus(profitRate);
    }

    private void showProfitStatus(double profitRate){
        ProfitStatus status = ProfitStatus.from(profitRate);
        resultView.showProfitStatus(status);
    }
}
