package lotto.domain;

import lotto.view.InputView;

import java.io.InputStream;
import java.util.List;

/**
 * Created by yusik on 2019/11/05.
 */
public class LotteryMachine {

    private final InputStream in;

    public LotteryMachine(InputStream in) {
        this.in = in;
    }

    public void run() {
        InputView inputView = new InputView(in);

        int amount = inputView.receiveAmount();
        System.out.println(amount);

        List<Integer> winningNumbers = inputView.receiveWinningNumbers();
        System.out.println(winningNumbers);
    }
}
