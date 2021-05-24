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
        //TODO 피드백: 수익률 계산이 프린트메서드에 있는것은 아닌듯 어떤객체에 위임을 할지 고민
        /*
            출력을 담당하는 부분에 수익률을 구하는 부분이 같이 있습니다 😄
            이미 결과를 담당하고 있는 LottoStatistics 에게 위임하여 물어보거나
            아니면 Cash에게 역할을 위임해보시는 건 어떨까요??
            수익률을 계산하는 부분이 출력을 담당하는 부분에 있어서 다소 어색합니다 😅
            이 부분도 개선검토 해주시면 감사하겠습니다 🙇
         */
        OutputUI.printRateOfReturn(((double)lottoStatistics.totalPayout() / amount));

    }

    public List<Integer> convertStringToList(String data) {
        return Arrays.stream(data.split(SPLIT_REGEX))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }
}
