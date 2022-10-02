package lotto.controller;

import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.service.ProfitStrategy;
import lotto.service.impl.RelativeProfitStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LottoApp {

    private static final Logger LOGGER = Logger.getLogger(LottoApp.class.getName());

    public static void main(String[] args) {
        try (InputView inputView = getInputView()) {
            Integer money = inputView.getMoneyFromUser();
            Integer manualLottoNumber = inputView.getManualLottoNumber();

            Lottos lottos = inputView.getManualLottos(manualLottoNumber);
            lottos.add(inputView.getAutomaticLottos(money, manualLottoNumber));
            OutputView.printLottos(lottos);

            WinningLotto winningLotto = new WinningLotto(inputView.getWinningLotto(), inputView.getBonusBallFromUser());
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

    private static ProfitStrategy getProfitStrategy() {
        return new RelativeProfitStrategy();
    }
}
