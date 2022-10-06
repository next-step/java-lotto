package lotto.controller;

import lotto.LottoStore;
import lotto.model.Lotto;
import lotto.model.LottoBall;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.service.LottoNumberPicker;
import lotto.service.ProfitStrategy;
import lotto.service.impl.RelativeProfitStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoApp {

    private static final Logger LOGGER = Logger.getLogger(LottoApp.class.getName());

    public static void main(String[] args) {
        try (InputView inputView = getInputView()) {
            Integer money = inputView.getMoney();
            Integer manualLottoNumber = inputView.getManualLottoNumber();

            inputView.printManualLottoNumber();
            Lottos lottos = getManualLottos(inputView, manualLottoNumber);
            Lottos automaticLottos = LottoStore.buy(money, manualLottoNumber);
            inputView.printLottoBuyMsg(automaticLottos.size(), manualLottoNumber);
            lottos.add(automaticLottos);

            OutputView.printLottos(lottos);

            inputView.printWinningNumberQst();
            WinningLotto winningLotto = getWinningLotto(inputView);
            OutputView.printSummary(lottos.getMatchNumbers(winningLotto));

            ProfitStrategy profitStrategy = getProfitStrategy();
            OutputView.printProfit(profitStrategy.calculate(money, lottos.getWinningMoney(winningLotto)));
        } catch (IllegalArgumentException e) {
            System.out.println("유효하지 않은 입력값입니다.");
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static InputView getInputView() {
        return new InputView(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static Lottos getManualLottos(InputView inputView, Integer manualLottoNumber) {
        return Lottos.getManualLottos(IntStream.range(0, manualLottoNumber)
                .mapToObj((idx) -> getSingleManualLotto(inputView))
                .collect(Collectors.toList()));
    }

    private static WinningLotto getWinningLotto(InputView inputView) throws IOException {
        Lotto winningLotto = getSingleManualLotto(inputView);
        LottoBall bonusBall = new LottoBall(inputView.getBonusBall());
        return new WinningLotto(winningLotto, bonusBall);
    }

    private static Lotto getSingleManualLotto(InputView inputView) {
        return new Lotto(LottoNumberPicker.pick(inputView.getManualNumber()));
    }

    private static ProfitStrategy getProfitStrategy() {
        return new RelativeProfitStrategy();
    }
}
