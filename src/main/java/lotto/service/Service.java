package lotto.service;

import lotto.domain.*;
import lotto.domain.generator.IntegratedLottoGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.util.InputUtil;
import spark.Request;

import java.util.Arrays;
import java.util.List;

public class Service {
    private static Service service = new Service();
    private static LottoGame lottoGame = LottoGame.getInstance();

    private Service() {
    }

    public static Service getInstance() {
        return service;
    }

    public Lottos buyLotto(Request request) {
        String inputMoney = request.queryParams("inputMoney");
        String manualNumber = request.queryParams("manualNumber");
        Money payment = toMoney(inputMoney);
        List<String> manualLottos = toManualLottos(manualNumber);

        LottoOrder lottoOrder = receiveOrder(payment, manualLottos);
        IntegratedLottoGenerator integeratedLottoGenerator = new IntegratedLottoGenerator(lottoOrder);
        return lottoGame.purchase(integeratedLottoGenerator);
    }

    private Money toMoney(String inputMoney) {
        try {
            return new Money(Integer.parseInt(inputMoney));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액을 입력해주세요.");
        }
    }

    private List<String> toManualLottos(String manualNumber) {
        return Arrays.asList(InputUtil.splitLine(manualNumber));
    }

    private LottoOrder receiveOrder(Money payment, List<String> manualLottos) {
        return new LottoOrder(payment, manualLottos);
    }

    public LottosResult matchLotto(Request request, Lottos lottos) {
        try {
            String winningNumber = request.queryParams("winningNumber");
            int bonusNumber = Integer.parseInt(request.queryParams("bonusNumber"));

            WinningLotto winningLotto = LottoGenerator.generateWinningLotto(winningNumber, bonusNumber);
            return lottoGame.analyse(lottos, winningLotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스볼은 올바른 숫자로 입력해주세요.");
        }
    }
}
