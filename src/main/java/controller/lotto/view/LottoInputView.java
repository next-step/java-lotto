package controller.lotto.view;

import domain.common.Money;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    private final static Scanner scanner = new Scanner(System.in);
    private final static String DELIMITER = ", ";

    public static Long createMoneyView() {
        System.out.println("구입금액을 입력해주세요");
        return createLongByScanner();


    }

    public static List<Integer> createWinningInterList() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return convertInterList(getStringNumbers());

    }

    private static void verifyLottoSize(String[] split) {
        if (split == null || split.length != 6) {
            throw new IllegalArgumentException("로또 당첨 번호는 6개의 숫자여야 합니다.");
        }
    }

    private static void verifyEmptyString(String stringNumberList) {
        if (StringUtils.isBlank(stringNumberList)) {
            throw new IllegalArgumentException("당첨 번호를 입력하지 않았습니다.");
        }
    }

    private static List<Integer> convertInterList(String[] split) {
        return Arrays.stream(split)
                .map(item -> Integer.valueOf(item))
                .collect(Collectors.toList());
    }

    public static int createBonusNumberView() {
        System.out.println("보너스 볼을 입력해 주세요");
        return createIntByScanner();
    }

    public static long createLongByScanner() {
        long result = scanner.nextLong();
        scanner.nextLine();
        return result;
    }

    public static int createIntByScanner() {
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public static int createCustomLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return createIntByScanner();
    }

    public static List<List<Integer>> createCustomLottoIntegerList(Integer customLottoCount) {
        List<List<Integer>> result = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < customLottoCount; i++) {
            result.add(convertInterList(getStringNumbers()));
        }
        return result;
    }

    private static String[] getStringNumbers() {
        String stringNumberList = scanner.nextLine();
        verifyEmptyString(stringNumberList);

        String[] split = stringNumberList.split(DELIMITER);
        verifyLottoSize(split);
        return split;
    }
}
