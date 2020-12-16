package lotto.view;

import lotto.LottoWinCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * 지불 금액을 입력받아 로또를 몇 개 발급 받을 수 있는지 반환합니다.
     * @return
     */
    public int getLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        return this.calculateLottoAmountFromInsertSum(this.scanner.nextInt());
    }

    /**
     * 입력한 금액으로 로또를 몇 개 발급 받을 수 있는지 계산합니다.
     * 몫으로만 계산합니다.
     * @param sum
     * @return
     */
    private int calculateLottoAmountFromInsertSum(int sum) {
        return sum / LottoWinCalculator.LOTTO_PRICE;
    }

    /**
     * 당첨번호를 입력받습니다.
     * @return
     */
    public List<Integer> insertWinLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        this.scanner.nextLine();
        String nextLine = this.scanner.nextLine();
        return Arrays.asList(nextLine.split(",")).stream()
                                        .map(input -> Integer.parseInt(input.trim()))
                                        .collect(Collectors.toList());
    }

    /**
     * 보너스 번호를 입력받습니다.
     * @return
     */
    public int insertBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return this.scanner.nextInt();
    }
}
