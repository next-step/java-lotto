package lotto.view;

import lotto.util.AwardNumberUtil;

import java.util.*;

public final class InputTable {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LAST_WEEK_AWARD_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INSERT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INSERT_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputTable() {
    }

    public static Long inputHaveMoney() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Long.parseLong(SCANNER.nextLine());
    }

    public static String inputAwardNumber() {
        System.out.println(LAST_WEEK_AWARD_NUMBER_MESSAGE);
        return SCANNER.nextLine();
    }

    public static Integer inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int inputManualCount() {
        System.out.println(INSERT_MANUAL_LOTTO_COUNT_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<Set<Integer>> inputManualLotto(int manalLottoCount) {
        if (manalLottoCount == 0) {
            return new ArrayList<>();
        }
        System.out.println(INSERT_MANUAL_LOTTO_MESSAGE);
        List<Set<Integer>> lottos = new ArrayList<>();
        while (manalLottoCount-- != 0) {
            lottos.add(AwardNumberUtil.getAwardNumbers(SCANNER.nextLine()));
        }
        return lottos;
    }
}
