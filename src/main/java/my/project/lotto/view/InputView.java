package my.project.lotto.view;


import my.project.lotto.domain.Lotto;
import my.project.lotto.dto.ManualCount;
import my.project.utils.Scan;
import my.project.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class InputView {
    public static final String ENTER_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String ENTER_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String ENTER_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String ENTER_LAST_WINNIG_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static int getMoney() {
        Scanner scanner = Scan.getInstance();
        System.out.println(ENTER_AMOUNT);
        return scanner.nextInt();
    }

    public static int getManualCount() {
        Scanner scanner = Scan.getInstance();
        System.out.println(ENTER_MANUAL_COUNT);
        return scanner.nextInt();
    }

    public static List<Lotto> getManualNumbers(ManualCount manualCount) {
        Scanner scanner = Scan.getInstance();
        System.out.println(ENTER_MANUAL_NUMBERS);
        List<Lotto> list = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < manualCount.getManualCount(); i++) {
            list.add(new Lotto(StringUtils.parseToIntList(scanner.nextLine())));
        }
        return list;
    }

    public static String getWinningNumbers() {
        Scanner scanner = Scan.getInstance();
        System.out.println(ENTER_LAST_WINNIG_NUMBERS);
        return scanner.next();
    }

    public static int getBonusNumber() {
        Scanner scanner = Scan.getInstance();
        System.out.println(ENTER_BONUS_NUMBER);
        return scanner.nextInt();
    }

    private InputView() {
    }

}
