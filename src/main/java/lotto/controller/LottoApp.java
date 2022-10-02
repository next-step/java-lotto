package lotto.controller;

import lotto.LottoStore;
import lotto.model.Lotto;
import lotto.model.LottoBall;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.service.ProfitStrategy;
import lotto.service.impl.RandomNumberPicker;
import lotto.service.impl.RelativeProfitStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LottoApp {

    private static final Logger LOGGER = Logger.getLogger(LottoApp.class.getName());

    public static void main(String[] args) {
        try (InputView inputView = new InputView(new BufferedReader(new InputStreamReader(System.in)),new LottoStore(new RandomNumberPicker()))) {
            Integer money = inputView.getMoneyFromUser();
            Integer manualLottoNumber =  inputView.getManualLottoNumber();
            Lottos manualLottos = inputView.getManualLotto(manualLottoNumber);
            Lottos lottos = inputView.getLottos(money);

            Lotto lotto = inputView.getWinningLottoFromUser();
            LottoBall bonusBall = inputView.getBonusBallFromUser();
            WinningLotto winningLotto = new WinningLotto(lotto, bonusBall);

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

    private static ProfitStrategy getProfitStrategy() {
        return new RelativeProfitStrategy();
    }
}
