import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(InputView.getPrice());
        ResultView.printBuyLotto(lottoMachine.getTryNo());

        List<List<Integer>> selectedLottoNumbers = new ArrayList<>();
        while (!lottoMachine.isEnd()) {
            List<Integer> selectedLottoNumber = lottoMachine.machineStart();
            selectedLottoNumbers.add(selectedLottoNumber);
            ResultView.printLottoNumber(selectedLottoNumber);
        }
        ResultView.printStatics(new LottoResult(selectedLottoNumbers, InputView.getWinningNumbers()));
    }
}
