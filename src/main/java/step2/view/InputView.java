package step2.view;

import step2.domain.Lottos;
import step2.domain.Shop;

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

    public static List<Integer> lastWeekLottoNum() {
        viewLastWeekLottoNum();
        String lastWeekLottoNum = scanner.next();
        return getLastWeekLottoNum(lastWeekLottoNum);
    }

    static public void viewLastWeekLottoNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static List<Integer> getLastWeekLottoNum(String text) {
        List<Integer> nums = split(text);
        validateLottoNum(nums);
        return nums;
    }

    private static List<Integer> split(String text) {
        return Arrays.stream(text.split("[,:]")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validateLottoNum(List<Integer> nums) {
        if (nums.stream().anyMatch(i -> i > 45 || i <= 0)) {
            throw new RuntimeException("로또 번호는 1 ~ 45 사이의 번호여야 합니다");
        }

        if (nums.size() != LOTTO_NUM_SIZE) {
            throw new RuntimeException("로또 번호의 갯수는 6개여야 합니다");
        }
    }
}
