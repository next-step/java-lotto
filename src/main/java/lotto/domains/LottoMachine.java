package lotto.domains;

import lotto.ui.InputUI;
import lotto.ui.OutputUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int PRINT_MIN_MATCH_NUMBER = 3;
    private static final int PRINT_MAX_MATCH_NUMBER = 6;
    private static final String SPLIT_REGEX = ",";
    private int amount;
    private Lottos lottos;
    private LottoNumbers winningLottoNumber;

    public void buyLottos() {
        OutputUI.printInputPurchasingAmount();
        this.amount = InputUI.inputPurchasingAmount();
        this.lottos = makeLottos(new Cash(amount));
        OutputUI.printNumberOfPurchases(lottos.count());
        OutputUI.printLottosNumbers(lottos);
    }

    public Lottos makeLottos(Cash cash) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < cash.numberOfPurchasesAvailable(); i++) {
            lottoList.add(new Lotto());
        }
        return new Lottos(lottoList);
    }
    
    public void inputWinningNumber() {
        OutputUI.printInputWinningLottoNumbers();
        String winningNumbers = InputUI.inputWinningNumbers();
        this.winningLottoNumber = new LottoNumbers(convertStringToList(winningNumbers));
    }

    public void printStatistics() {
        LottoStatistics lottoStatistics = lottos.getStatistics(winningLottoNumber);
        for (int i = PRINT_MIN_MATCH_NUMBER; i <= PRINT_MAX_MATCH_NUMBER; i++) {
            OutputUI.printStatistics(i, lottoStatistics.count(i));
        }
        OutputUI.printRateOfReturn(lottoStatistics.rateOfReturn(amount));

    }

    public List<Integer> convertStringToList(String data) {
        return Arrays.stream(data.split(SPLIT_REGEX))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }
}
