package step3.view;

import step3.domain.Lottos;
import step3.domain.Shop;
import step3.lottoPlace.LastWeekLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private InputView() {
    }

    private static final int LOTTO_NUM_SIZE = 6;

    public static Lottos buyLotto() {
        viewGetMoney();
        int money = scanner.nextInt();
        return Shop.buyLotto(money);
    }

    static public void viewGetMoney() {
        System.out.println("구입금액을 입력해 주세요.");
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
        validateLottoNum(nums);
        validateBonusNum(bonusNum);
        return LastWeekLotto.of(nums, bonusNum);
    }

    private static List<Integer> split(String text) {
        return Arrays.stream(text.split("[,:]")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validateLottoNum(List<Integer> nums) {
        if (nums.stream().anyMatch(i -> !inRange(i))) {
            throw new RuntimeException("로또 번호는 1 ~ 45 사이의 번호여야 합니다");
        }

        if (nums.size() != LOTTO_NUM_SIZE) {
            throw new RuntimeException("로또 번호의 갯수는 6개여야 합니다");
        }
    }

    private static void validateBonusNum(int bonusNum) {
        if (!inRange(bonusNum)) {
            throw new RuntimeException("로또 번호는 1 ~ 45 사이의 번호여야 합니다");
        }
    }

    private static boolean inRange(int num) {
        return num <= 45 && num > 0;
    }
}
