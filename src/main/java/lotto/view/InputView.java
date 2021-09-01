package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.Money;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static String GUIDE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final static String NOTI_INVALID_MONEY = "구입금액으로 유효하지 않습니다.";
    private static final String GUIDE_INPUT_WIN_NUMS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INST_INPUT_BONUS_NUM = "보너스 볼을 입력해 주세요";
    private static final int NUMS_PER_LOTTO = 6;

    public static int inputMoney() {
        Scanner scanner = new Scanner(System.in);
        int money;

        do {
            System.out.println(GUIDE_INPUT_MONEY);
            money = scanner.nextInt();
        } while (!isValidMoney(money));

        return money;
    }

    static boolean isValidMoney(int money) {
        try {
            Money.checkValidMoney(money);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static List<Integer> inputWinningNums() {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        do {
            System.out.println(GUIDE_INPUT_WIN_NUMS);
            input = scanner.nextLine();
        } while (!isValidWinningNums(input));

        return toWinningNums(input);
    }

    private static List<Integer> toWinningNums(String input) {
        String[] nums = input.split(",");
        List<Integer> winningNums = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            winningNums.add(Integer.parseInt(nums[i].trim()));
        }

        return winningNums;
    }

    static boolean isValidWinningNums(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }

        String[] nums = input.split(",");

        return isValidNums(nums);
    }

    static boolean isValidNums(String[] nums) {
        if (nums.length != NUMS_PER_LOTTO) {
            return false;
        }

        boolean result = true;
        for (int i = 0; i < nums.length; i++) {
            result &= isInteger(nums[i]);
        }

        return result;
    }

    static boolean isInteger(String num) {
        return !StringUtils.isBlank(num) || NumberUtils.isNumber(num);
    }

    public static int inputBonusNum() {
        int bonusNum;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(INST_INPUT_BONUS_NUM);
            bonusNum = scanner.nextInt();
        } while (!isValidBonusNum(bonusNum));

        return bonusNum;
    }

    static boolean isValidBonusNum(int bonusNum) {
        if (bonusNum < 1 || bonusNum > LottoMachine.LOTTO_MAX_NUM) {
            return false;
        }

        return true;
    }
}
