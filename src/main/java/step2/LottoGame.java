package step2;

import step2.domain.ResultOfLottos;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoMachine;
import step2.domain.lotto.LottoNumber;
import step2.domain.lotto.LottoStatistics;
import step2.domain.lotto.RandomStrategy;
import step2.domain.money.Cache;
import step2.domain.money.Money;
import step2.domain.user.User;
import step2.domain.user.Wallet;
import step2.view.InputView;
import step2.view.ResultView;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();
        User user = new User("pobi", new Wallet(new Cache(inputMoney)));
        LottoMachine lottoMachine = new LottoMachine(new RandomStrategy());

        Money allMoney = user.withDraw();
        List<Lotto> boughtLottos = lottoMachine.sell(allMoney);
        user.buyLotto(boughtLottos);

        ResultView.printCount(user.getLottos());
        ResultView.printLottos(user.getLottos());

        String[] lastWinOfLottoNumber = InputView.inputWinOfLottoNumber().split(",");
        List<Integer> winOfLottoNumbers = Stream.of(lastWinOfLottoNumber)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        LottoNumber winOfLottoNumber = new LottoNumber(winOfLottoNumbers);

        ResultView.printLottoStatistics(new LottoStatistics(winOfLottoNumber, user.getLottos(), new ResultOfLottos()));
    }
}
