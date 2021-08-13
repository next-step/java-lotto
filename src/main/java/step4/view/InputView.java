package step4.view;

import step4.domain.Lottos;
import step4.domain.Shop;
import step4.lottoPlace.LastWeekLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final int LOTTO_NUM_SIZE = 6;

    private InputView() {
    }

    public static Lottos buyLotto() {
        List<List<Integer>> manualNumList = new ArrayList<>();

        viewGetMoney();
        int money = scanner.nextInt();
        viewGetManualCount();
        int manualCount = scanner.nextInt();
        viewGetManual();
        for (int i = 0; i < manualCount; i++) {
            String manualNumsText = scanner.next();
            manualNumList.add(split(manualNumsText));
        }

        return Shop.buyLotto(money, manualNumList);
    }

    public static void viewGetMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void viewGetManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void viewGetManual() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static LastWeekLotto lastWeekLottoNum() {
        viewLastWeekLottoNum();
        String lastWeekLottoNum = scanner.next();
        viewBonusLottoNum();
        int bonusNum = scanner.nextInt();
        return getLastWeekLottoNum(lastWeekLottoNum, bonusNum);
    }

    public static void viewLastWeekLottoNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void viewBonusLottoNum() {
        System.out.println("보너스 볼을 입력해 주세요..");
    }

    public static LastWeekLotto getLastWeekLottoNum(String text, int bonusNum) {
        List<Integer> nums = split(text);
        return LastWeekLotto.of(nums, bonusNum);
    }

    private static List<Integer> split(String text) {
        return Arrays.stream(text.split("[,:]"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
