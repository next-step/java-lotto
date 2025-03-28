package lotto.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.LottoConfig.LOTTO_PRICE;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPositiveNumberInput(String prompt) {
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

    public static Set<Integer> getPositiveNumberSetInput(String prompt, String delimiter, int count) {
        System.out.println(prompt);

        while (true) {
            try {
                String line = scanner.nextLine();

                String[] split = line.split(delimiter);
                Set<Integer> result = Arrays.stream(split)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet());

                if (result.size() == count)
                    return result;

                System.out.println("당첨 번호는 중복이 허용되지 않습니다. " + count + "개의 숫자를 다시 입력해 주세요. input: " + result);
            } catch (NumberFormatException e) {
                System.out.println("입력은 숫자 포맷만 허용합니다. 다시 입력해 주세요.");
            }
        }
    }
}
