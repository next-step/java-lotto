package step2;

import step2.domain.Cache;
import step2.domain.LottoMachine;
import step2.domain.LottoNumber;
import step2.domain.LottoStatistics;
import step2.domain.RandomStrategy;
import step2.domain.User;
import step2.domain.Wallet;
import step2.view.InputView;
import step2.view.ResultView;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        User user = new User("pobi", new Wallet(new Cache(money)));
        LottoMachine lottoMachine = new LottoMachine(new RandomStrategy());

        user.buyLotto(lottoMachine);

        ResultView.printCount(user.getLottos());
        ResultView.printLottos(user.getLottos());

        String[] lastWinOfLottoNumber = InputView.inputWinOfLottoNumber().split(",");
        List<Integer> winOfLottoNumbers = Stream.of(lastWinOfLottoNumber)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        LottoNumber winOfLottoNumber = new LottoNumber(winOfLottoNumbers);

        ResultView.printLottoStatistics(new LottoStatistics(winOfLottoNumber, user.getLottos()));

    }
}
