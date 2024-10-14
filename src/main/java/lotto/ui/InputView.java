package lotto.ui;

import java.util.List;
import java.util.Scanner;

public interface InputView {
    int getPurchaseAmountFromUser();
    List<String> getManualLottosFromUser();
    String getWinningNumbersFromUser();
    int getBonusBallFromUser();
}
