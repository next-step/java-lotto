package lotto.controller;

import lotto.LottoStore;
import lotto.model.Lotto;
import lotto.model.LottoBall;
import lotto.model.Lottos;
import lotto.service.LottoNumberPicker;
import lotto.service.impl.ManualNumberPicker;
import lotto.service.impl.RandomNumberPicker;

import java.io.BufferedReader;
import java.io.IOException;

public class InputView implements AutoCloseable {

    private static final int FIRST = 0;
    private static final int SINLE_LOTTO_NUMBER = 1;
    private static final String LOTTO_BUY_MONEY_QST = "구입금액을 입력해 주세요.";
    private static final String BUY_NUMBER = "수동으로 %d장, 자동으로 %d개를 구매했습니다. \n";
    private static final String WINNING_NUMBER_QST = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_QST = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTO_BUY_NUMBER = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_QST = "수동으로 구매할 번호를 입력해 주세요.";
    private final BufferedReader bufferedReader;
    private final LottoNumberPicker manualNumberPicker;
    private final LottoStore store;

    public InputView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
        this.store = new LottoStore(new RandomNumberPicker());
        this.manualNumberPicker = new ManualNumberPicker(bufferedReader);
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


    public LottoBall getBonusBall() throws IOException {
        this.printBonusBallQst();
        return new LottoBall(getSingleNumber());
    }

    private void printBonusBallQst() {
        System.out.println(BONUS_BALL_QST);
    }

    public Lottos getManualLottos(int number) {
        this.printManualLottoNumber();
        return new Lottos(number, this.manualNumberPicker);
    }

    private void printManualLottoNumber() {
        System.out.println(MANUAL_LOTTO_NUMBER_QST);
    }

    public Lottos getAutomaticLottos(Integer money, Integer manualLottoNUmber) {
        Lottos lottos = this.store.buy(money, manualLottoNUmber);
        this.printLottoBuyMsg(lottos.size(), manualLottoNUmber);
        return lottos;
    }

    private void printLottoBuyMsg(int lottoNumber, int manualLottoNumber) {
        System.out.printf(BUY_NUMBER, manualLottoNumber, lottoNumber);
    }

    public Lotto getWinningLotto() {
        this.printWinningNumberQst();
        return new Lottos(SINLE_LOTTO_NUMBER, this.manualNumberPicker).getLottos().get(FIRST);
    }

    private void printWinningNumberQst() {
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
