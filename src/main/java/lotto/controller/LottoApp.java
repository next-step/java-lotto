package lotto.controller;

import lotto.LottoStore;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.ProfitStrategy;
import lotto.service.impl.RandomNumberPicker;
import lotto.service.impl.RelativeProfitStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoApp {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Integer money = getMoneyFromUser(br);
            Lottos lottos = getLottos(money);

            Lotto winningLotto = getWinningLottoFromUser(br);
            OutputView.printSummary(lottos.getMatchNumbers(winningLotto));

            ProfitStrategy profitStrategy = getProfitStrategy();
            OutputView.printProfit(profitStrategy.calculate(money, lottos.getWinningMoney(winningLotto)));
        } catch (IllegalArgumentException e) {
            System.out.println("유효하지 않은 입력값입니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Integer getMoneyFromUser(BufferedReader br) throws IOException {
        InputView.printMoneyQst();
        int money = Integer.parseInt(br.readLine().trim());
        if (money <= 0) {
            throw new IllegalArgumentException("돈은 0 또는 음수일수 없습니다.");
        }
        return money;
    }

    private static Lottos getLottos(Integer money) {
        Lottos lottos = new LottoStore(new RandomNumberPicker()).buy(money);
        InputView.printLottoBuyMsg(lottos.getSize());
        OutputView.printLottos(lottos);
        return lottos;
    }

    private static Lotto getWinningLottoFromUser(BufferedReader br) throws IOException {
        InputView.printWinningNumberQst();
        return new Lotto(Arrays.stream(br.readLine().split(InputView.DEFAULT_WINNNING_NUMBER_SEPARATOR)).map((num) -> Integer.valueOf(num.trim()))
                .collect(Collectors.toList()));
    }

    private static ProfitStrategy getProfitStrategy() {
        return new RelativeProfitStrategy();
    }
}
