package lotto.web;

import lotto.domain.LottoBundle;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRunner;
import lotto.domain.WinningLotto;
import lotto.parser.LottoNumberParser;
import lotto.vo.LottoGameResult;
import lotto.vo.Money;
import org.apache.commons.lang3.StringUtils;
import spark.Request;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    public LottoBundle buyLotto(Request request) {
        String inputMoney = request.queryParams("inputMoney");
        Money money = new Money(Long.parseLong(inputMoney));
        String manualNumber = request.queryParams("manualNumber");

        if (StringUtils.isBlank(manualNumber)) {
            return LottoMachine.buyLottos(money);
        }

        return LottoMachine.buyLottos(toManualLottos(manualNumber), money);
    }

    private List<String> toManualLottos(String manualNumber) {
        String[] manualLottos = manualNumber.split(System.lineSeparator());

        return Arrays.stream(manualLottos)
                .collect(Collectors.toList());
    }

    public LottoGameResult matchLotto(Request request, LottoBundle lottoBundle) {
        String winningNumber = request.queryParams("winningNumber");
        String bonusNumber = request.queryParams("bonusNumber");
        WinningLotto winningLotto = LottoNumberParser.parseWinningLotto(winningNumber, bonusNumber);

        return LottoRunner.runLotto(winningLotto, lottoBundle);
    }
}
