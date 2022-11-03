package lotto.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.function.LongToDoubleFunction;
import java.util.stream.Collectors;

public class InputView {

    private static final String COMMA = ",";

    private InputView() {
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static int getPrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("로또 구매가격은 숫자만 입력 가능합니다");
        }
    }

    public static Set<Integer> getWeekendNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getLottoNumbers();
    }

    public static Set<Integer> getLottoNumbers() {
        return Arrays.stream(scanner.next().split(COMMA))
            .map(Integer::parseInt)
            .collect(Collectors.toSet());
    }

    public static int getWeekendBonusNumber() {
        try {
            System.out.println("보너스 볼을 입력해 주세요.");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력 가능합니다");
        }
    }

    public static int getManualLottoCount(int lottoCount) {
        int count = 0;
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            count = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("로또 구매가격은 숫자만 입력 가능합니다");
        }

        if (count > lottoCount) {
            throw new IllegalArgumentException("수동으로 구매가능한 갯수를 초과 하였습니다");
        }

        return count;
    }
}
