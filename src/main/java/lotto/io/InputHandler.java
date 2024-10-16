package lotto.io;

import java.util.List;

public interface InputHandler {

    long getPurchaseAmountFromUser();

    List<String> getWinningNumbersFromUser();

    int getBonusBallFromUser();
}
