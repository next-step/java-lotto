package lotto.controller;

import lotto.LottoStore;
import lotto.model.Lotto;
import lotto.model.LottoBall;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.service.ProfitStrategy;
import lotto.service.impl.ManualNumberPicker;
import lotto.service.impl.RandomNumberPicker;
import lotto.service.impl.RelativeProfitStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LottoApp {

    private static final Logger LOGGER = Logger.getLogger(LottoApp.class.getName());
    private static final int SINGLE_LOTTO = 1;

    private static final int FIRST = 0;

    public static void main(String[] args) {
        try (InputView inputView = getInputView()) {
            ManualNumberPicker manualNumberPicker = new ManualNumberPicker(inputView);
            Integer money = inputView.getMoney();
            Integer manualLottoNumber = inputView.getManualLottoNumber();

            inputView.printManualLottoNumber();
            Lottos lottos = new Lottos(manualLottoNumber, manualNumberPicker);
            Lottos automaticLottos = getStore().buy(money, manualLottoNumber);
            inputView.printLottoBuyMsg(automaticLottos.size(), manualLottoNumber);
            lottos.add(automaticLottos);

            OutputView.printLottos(lottos);

            inputView.printWinningNumberQst();
            WinningLotto winningLotto = getWinningLotto(inputView, manualNumberPicker);
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

    private static WinningLotto getWinningLotto(InputView inputView, ManualNumberPicker manualNumberPicker) throws IOException {
        Lotto winningLotto = new Lottos(SINGLE_LOTTO, manualNumberPicker).getLottos().get(FIRST);
        LottoBall bonusBall = new LottoBall(inputView.getBonusBall());
        return new WinningLotto(winningLotto, bonusBall);
    }

    private static LottoStore getStore() {
        return new LottoStore(new RandomNumberPicker());
    }

    private static InputView getInputView() {
        return new InputView(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static ProfitStrategy getProfitStrategy() {
        return new RelativeProfitStrategy();
    }
}
