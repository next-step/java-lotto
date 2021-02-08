package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Money;
import lotto.util.InfoStrings;

public class InputView {

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String getMoneyToBuyLotto() {
        System.out.println(InfoStrings.INFO_INPUT_PURCHASE_MONEY);
        return scanner.nextLine();
    }

    public int getManualLottoCnt() {
        System.out.println(InfoStrings.INFO_INPUT_MANUAL_LOTTO_CNT);
        int ManualLottoCnt = scanner.nextInt();
        return ManualLottoCnt;
    }

    public List<String> getManualLottoNumberList(int manualLottoCnt) {
        List<String> manualNumberList = new ArrayList<>();
        System.out.println(InfoStrings.INFO_INPUT_MANUAL_LOTTO_NUMBER_LIST);
        scanner.nextLine();
        for (int i = 0; i < manualLottoCnt; i++) {
            String ManualLottoNumber = scanner.nextLine();
            manualNumberList.add(ManualLottoNumber);
        }
        return manualNumberList;
    }

    public String getWinningLotto() {
        System.out.println(InfoStrings.INFO_INPUT_WINNING_LOTTO_NUMBERS);
        String winningLottoNumber = scanner.nextLine();
        return winningLottoNumber;
    }

    public int getBonusBall() {
        System.out.println(InfoStrings.INFO_INPUT_BONUS_NUMBER);
        int bonusBall = scanner.nextInt();
        return bonusBall;
    }
}
