package lotto.view;

import lotto.domain.Lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int input = inputSingleNumber();
        checkPositive(input);
        return input;
    }

    public static int inputSelfCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int input = inputSingleNumber();
        checkPositive(input);
        return input;
    }

    private static int inputSingleNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("1개의 숫자가 입력되어야 합니다.");
        }
    }

    private static void checkPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("0보다 큰 값을 입력해야 합니다");
        }
    }

    public static List<Lotto> inputSelfLottos(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        return IntStream.range(0, count)
                .mapToObj(i -> inputLotto())
                .collect(Collectors.toList());
    }

    public static Lotto inputWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLotto();
    }

    private static Lotto inputLotto() {
        String input = scanner.next();
        Set<Integer> result = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        return new Lotto(new ArrayList<>(result));
    }

    public static int inputBonusNumber(Lotto winNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        int input;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("1개의 보너스 번호가 입력되어야 합니다.");
        }
        checkBonusInput(input, winNumbers);
        return input;
    }

    private static void checkBonusInput(int bonusNumber, Lotto winNumbers) {
        if (Lotto.MIN > bonusNumber || bonusNumber > Lotto.MAX) {
            throw new IllegalArgumentException("입력 범위를 벗어났습니다.");
        }
        if (winNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 달라야 합니다.");
        }

    }
}
