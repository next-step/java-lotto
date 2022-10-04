package lotto.controller;

import java.io.BufferedReader;
import java.io.IOException;

public class InputView implements AutoCloseable {

    private static final String LOTTO_BUY_MONEY_QST = "구입금액을 입력해 주세요.";
    private static final String BUY_NUMBER = "수동으로 %d장, 자동으로 %d개를 구매했습니다. \n";
    private static final String WINNING_NUMBER_QST = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_QST = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTO_BUY_NUMBER = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_QST = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String DEFAULT_DELIMITER = ",";
    private final BufferedReader bufferedReader;

    public InputView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public Integer getMoney() throws IOException {
        this.printMoneyQst();
        return getSingleNumber();
    }

    private void printMoneyQst() {
        System.out.println(LOTTO_BUY_MONEY_QST);
    }


    public Integer getManualLottoNumber() throws IOException {
        this.printManualLottoBuyMsg();
        return getSingleNumber();
    }

    private void printManualLottoBuyMsg() {
        System.out.println(MANUAL_LOTTO_BUY_NUMBER);
    }


    public Integer getBonusBall() throws IOException {
        this.printBonusBallQst();
        return getSingleNumber();
    }

    private void printBonusBallQst() {
        System.out.println(BONUS_BALL_QST);
    }

    public String[] getSplitedInput() {
        try {
            return this.bufferedReader.readLine().split(DEFAULT_DELIMITER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printManualLottoNumber() {
        System.out.println(MANUAL_LOTTO_NUMBER_QST);
    }

    public void printLottoBuyMsg(int lottoNumber, int manualLottoNumber) {
        System.out.printf(BUY_NUMBER, manualLottoNumber, lottoNumber);
    }

    public void printWinningNumberQst() {
        System.out.println(WINNING_NUMBER_QST);
    }

    private int getSingleNumber() throws IOException {
        int number = Integer.parseInt(this.bufferedReader.readLine().trim());
        if (number < 0) {
            throw new IllegalArgumentException("입력값은 음수일수 없습니다.");
        }
        return number;
    }


    @Override
    public void close() throws Exception {
        this.bufferedReader.close();
    }


}
