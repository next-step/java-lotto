package step2.view;

import step2.domain.lotto.WinningNumber;

import java.util.Scanner;

public interface InputView {
    int getUseAmount(Scanner scanner);
    WinningNumber getWinningNumber(Scanner scanner);
}
