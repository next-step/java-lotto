package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final int LOTTO_ONE_TIME_COST = 1000;
    private final Scanner scanner = new Scanner(System.in);

    /**
     * 지불 금액을 입력받아 로또를 몇 개 발급 받을 수 있는지 반환합니다.
     * @return
     */
    public int insertPayToSum() {
        System.out.println("구입금액을 입력해 주세요.");
        return this.calculateLottoAmountFromInsertSum(scanner.nextInt());
    }

    /**
     * 입력한 금액으로 로또를 몇 개 발급 받을 수 있는지 계산합니다.
     * 몫으로만 계산합니다.
     * @param sum
     * @return
     */
    private int calculateLottoAmountFromInsertSum(int sum) {
        return sum / LOTTO_ONE_TIME_COST;
    }
}
