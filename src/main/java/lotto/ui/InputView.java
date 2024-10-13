package lotto.ui;

import java.util.Scanner;

public interface InputView {
    int getPurchaseAmountFromUser();
    String[] getManualLottosFromUser();
    String getWinningNumbersFromUser();
    int getBonusBallFromUser();
}
