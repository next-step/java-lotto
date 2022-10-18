package lotto.view;

import com.sun.nio.sctp.SctpChannel;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String MSG_INPUT_AUTO_PURCHASE_NUMBER = "구입금액을 입력해 주세요.";
    public static final String MSG_INPUT_MANUAL_PURCHASE_NUMBER = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MSG_INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String MSG_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);
    public static final String MSG_INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    public static int inputAutoPurchaseNumber() {
        System.out.println(MSG_INPUT_AUTO_PURCHASE_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputManualPurchaseNumber() {
        System.out.println(MSG_INPUT_MANUAL_PURCHASE_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> inputManualLottoNumber(int cnt) {
        List<String> lottoList = new ArrayList<>();
        System.out.println(MSG_INPUT_MANUAL_LOTTO_NUMBERS);
        for (int i = 0; i < cnt; i++) {
            String lotto = scanner.nextLine();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public static String inputWinningNumber() {
        System.out.println(MSG_INPUT_WINNING_NUMBER);
        return scanner.nextLine();
    }

    public static int inputBonusBall() {
        System.out.println(MSG_INPUT_BONUS_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }
}
