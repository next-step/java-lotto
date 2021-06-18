package lotto.ui;

import lotto.objects.*;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    public Money enterPurchaseMoney() {
        Print print = new Print("구입금액을 입력해주세요.");
        print.printMention();

        return Input.inputMoney();
    }

    public Lotto enterLastWeekWinningNumbers() {
        Print print = new Print("지난 주 당첨 번호를 입력해 주세요.");
        print.printMention();

        return Input.inputLastWinningLotto();
    }

    public BonusBall enterBonusBallNumber() {
        Print print = new Print("보너스 볼을 입력해 주세요.");
        print.printMention();

        return Input.inputBonusBall();
    }
}
