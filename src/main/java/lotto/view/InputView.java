package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;
import static lotto.domain.LottoNumbers.LOTTO_SIZE;
import static lotto.domain.LottoPaper.LOTTO_PRICE;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int getPositiveNumberInputWithLowBound(String prompt) {
        return getNumberInput(prompt, LOTTO_PRICE + "이상의 정수만 허용됩니다. 다시 입력해 주세요.",
                input -> input >= LOTTO_PRICE);
    }

    public static int getLottoNumberInput(String prompt) {
        return getNumberInput(prompt, "1~45 사이의 정수만 허용됩니다. 다시 입력해 주세요.",
                input -> input >= MIN_LOTTO_NUMBER && input <= MAX_LOTTO_NUMBER);
    }

    public static int getPositiveNumberInput(String prompt) {
        return getNumberInput(prompt, "0 이상의 정수만 허용됩니다. 다시 입력해 주세요.",
                input -> input >= 0);
    }

    private static int getNumberInput(String prompt, String errorMessage, Predicate<Integer> predicate) {
        System.out.println(prompt);

        while (true) {
            try {
                int result = scanner.nextInt();

                // scanner.nextInt() 는 개행 문자를 제거하지 못해 nextInt 이후 nextLine 으로 개행 제거
                scanner.nextLine();

                if (predicate.test(result)) {
                    return result;
                }

                System.out.println(errorMessage + " input: " + result);
            } catch (InputMismatchException e) {
                System.out.println(errorMessage + scanner.nextLine());
            }
        }
    }

    public static List<Set<Integer>> getPositiveNumberSetInput(String prompt, String delimiter, int count) {
        System.out.println(prompt);

        List<Set<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            resultList.add(getPositiveNumberSetInput(delimiter));
        }

        return resultList;
    }

    public static Set<Integer> getPositiveNumberSetInput(String prompt, String delimiter) {
        System.out.println(prompt);
        return getPositiveNumberSetInput(delimiter);
    }

    private static Set<Integer> getPositiveNumberSetInput(String delimiter) {
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
            } catch (NumberFormatException ignored) {
            }
            System.out.println("입력은 숫자 포맷만 허용합니다. 다시 입력해 주세요.");
        }
    }
}
