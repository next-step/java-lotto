package lotto.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;
import static lotto.domain.LottoNumbers.LOTTO_SIZE;
import static lotto.domain.LottoStore.LOTTO_PRICE;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int getPositiveNumberInputWithLowBound(String prompt) {
        System.out.println(prompt);

        while (true) {
            try {
                int result = scanner.nextInt();

                if (result > LOTTO_PRICE)
                    return result;

                System.out.println(LOTTO_PRICE + "이상의 정수만 허용됩니다. 다시 입력해 주세요. input: " + result);
            } catch (InputMismatchException e) {
                System.out.println(LOTTO_PRICE + "이상의 정수만 허용됩니다. 다시 입력해 주세요. input: " + scanner.nextLine());
            }
        }
    }

    public static int getPositiveNumberInput(String prompt) {
        System.out.println(prompt);

        while (true) {
            try {
                int result = scanner.nextInt();

                if (result >= MIN_LOTTO_NUMBER && result <= MAX_LOTTO_NUMBER) {
                    return result;
                }
            } catch (InputMismatchException ignored) {
            }
            System.out.println("1~45 사이의 정수만 허용됩니다. 다시 입력해 주세요. input: " + scanner.nextLine());
        }
    }

    public static Set<Integer> getPositiveNumberSetInput(String prompt, String delimiter) {
        System.out.println(prompt);

        while (true) {
            try {
                String line = scanner.nextLine();

                String[] split = line.split(delimiter);
                Set<Integer> result = Arrays.stream(split)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet());

                if (result.size() == LOTTO_SIZE)
                    return result;

                System.out.println("당첨 번호는 중복이 허용되지 않습니다. " + LOTTO_SIZE + "개의 숫자를 다시 입력해 주세요. input: " + result);
            } catch (NumberFormatException e) {
                System.out.println("입력은 숫자 포맷만 허용합니다. 다시 입력해 주세요.");
            }
        }
    }
}
