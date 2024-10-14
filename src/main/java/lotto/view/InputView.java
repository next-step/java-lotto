package lotto.view;


import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String CASH_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매하셨습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public int getCashAmount() {
        try {
            int cashAmount = 0;
            System.out.println(CASH_AMOUNT_MESSAGE);
            cashAmount = sc.nextInt();
            sc.nextLine();
            return cashAmount;
        } catch (Exception e) {
            sc.nextLine();
            return 0;
        }
    }

    public int getManualLottoCount() {
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            int count = sc.nextInt();
            sc.nextLine();
            return count;
        } catch (Exception e) {
            sc.nextLine();
            return 0;
        }
    }

    public List<Lotto> getManualLottoNumbers(int count) {
        try {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            List<Lotto> lottoList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                List<Integer> numbers = Arrays.stream(sc.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                lottoList.add(new Lotto(new HashSet<>(numbers)));
            }
            return lottoList;
        } catch (Exception e) {
            sc.nextLine();
            return new ArrayList<>();
        }
    }

    public void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COUNT_MESSAGE);
    }

    public Set<Integer> getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        String[] balls = sc.nextLine().split(", ");
        return Arrays.stream(balls)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public int getBonusNumber() {
        try {
            System.out.println("보너스 볼을 입력해 주세요.");
            int number = sc.nextInt();
            sc.nextLine();
            return number;
        } catch (Exception e) {
            sc.nextLine();
            return getBonusNumber();
        }
    }
}
