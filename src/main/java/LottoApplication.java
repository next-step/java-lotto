import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(InputView.getPrice());
        ResultView.printBuyLotto(lottoMachine.getTryNo());
        List<Lotto> lottos = new ArrayList<>();
        while (!lottoMachine.isEnd()) {
            Lotto lotto = lottoMachine.machineStart();
            lottos.add(lotto);
            ResultView.printLottoNumber(lotto);
        }
        ResultView.printStatics(new LottoResult(lottos, InputView.getWinningNumbers(), InputView.getBonusNumber()));
    }
}
