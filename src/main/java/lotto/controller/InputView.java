package lotto.controller;


import lotto.LottoStore;
import lotto.model.Lotto;
import lotto.model.LottoBall;
import lotto.model.Lottos;
import lotto.service.impl.RandomNumberPicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView implements AutoCloseable {

    private static final String LOTTO_BUY_MONEY_QST = "구입금액을 입력해 주세요.";
    private static final String BUY_NUMBER = "%d개를 구매했습니다. \n";
    private static final String WINNING_NUMBER_QST = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String DEFAULT_WINNNING_NUMBER_SEPARATOR = ",";

    private static final String BONUS_BALL_QST = "보너스 볼을 입력해 주세요.";
    private final BufferedReader bufferedReader;

    public InputView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    private void printMoneyQst() {
        System.out.println(LOTTO_BUY_MONEY_QST);
    }

    private void printLottoBuyMsg(int lottoNumber) {
        System.out.printf(BUY_NUMBER, lottoNumber);
    }

    private void printWinningNumberQst() {
        System.out.println(WINNING_NUMBER_QST);
    }

    private void printBonusBallQst(){
        System.out.println(BONUS_BALL_QST);
    }

    public Integer getMoneyFromUser() throws IOException {
        this.printMoneyQst();
        int money = Integer.parseInt(this.bufferedReader.readLine().trim());
        if (money <= 0) {
            throw new IllegalArgumentException("돈은 0 또는 음수일수 없습니다.");
        }
        return money;
    }

    public Lottos getLottos(Integer money) {
        Lottos lottos = new LottoStore(new RandomNumberPicker()).buy(money);
        this.printLottoBuyMsg(lottos.size());
        OutputView.printLottos(lottos);
        return lottos;
    }

    public Lotto getWinningLottoFromUser() throws IOException {
        this.printWinningNumberQst();
        return new Lotto(Arrays.stream(this.bufferedReader.readLine().split(InputView.DEFAULT_WINNNING_NUMBER_SEPARATOR)).map((num) -> LottoBall.noBonusBall(Integer.valueOf(num.trim())))
                .collect(Collectors.toList()));
    }

    public LottoBall getBonusBallFromUser() throws IOException {
        this.printBonusBallQst();
        return LottoBall.bonusBall(Integer.parseInt(this.bufferedReader.readLine()));
    }

    @Override
    public void close() throws Exception {
        this.bufferedReader.close();
    }
}
