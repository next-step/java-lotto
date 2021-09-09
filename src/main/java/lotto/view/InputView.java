package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static String GUIDE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String GUIDE_INPUT_WIN_NUMS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String GUIDE_INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요";
    private static final String INST_INPUT_BONUS_NUM = "보너스 볼을 입력해 주세요";
    private static final String GUIDE_INPUT_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요";
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

        return toIntList(input);
    }

    private static List<Integer> toIntList(String input) {
        String[] nums = input.split(",");
        List<Integer> intList = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            intList.add(Integer.parseInt(nums[i].trim()));
        }

        return intList;
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
        Scanner scanner = new Scanner(System.in);
        int bonusNum;

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

    public static int inputManualLottoCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(GUIDE_INPUT_MANUAL_COUNT);
        return scanner.nextInt();
    }

    public static List<Lotto> inputManualLotto(int manualLottoCount) {
        if (manualLottoCount == 0) {
            return new ArrayList<>();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println(GUIDE_INPUT_MANUAL_LOTTO);
        String input = "";
        List<Lotto> lottoList = new ArrayList<>(manualLottoCount);

        for (int i = 0; i < manualLottoCount; i++) {
            input = scanner.nextLine();
            lottoList.add(new Lotto(toIntList(input)));
        }

        return lottoList;
    }
}
