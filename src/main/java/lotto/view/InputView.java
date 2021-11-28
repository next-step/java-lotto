package lotto.view;

import lotto.domain.Numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    public static final int PRICE_PER_LOTTO = 1000;
    private static final int NUMBERS_SIZE = 6;
    private static final int LAST_NUMBER_INDEX = 5;
    private final Scanner scanner;
    private final List<Numbers> numbers;

    public InputView() {
        scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        int money = scanner.nextInt();
        int count = money / PRICE_PER_LOTTO;
        numbers = IntStream.range(0, count).mapToObj(i -> new Numbers()).collect(Collectors.toList());
        System.out.println(count + "개를 구매했습니다.");
        printNumbers();
        System.out.println();
    }

    private void printNumbers() {
        this.numbers.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public List<Numbers> getNumbers() {
        return numbers;
    }

    public Numbers getPrizeNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, NUMBERS_SIZE).forEach(i -> list.add(parseInteger(i, scanner.next())));
        return new Numbers(list);
    }

    private Integer parseInteger(int i, String token) {
        if (i == LAST_NUMBER_INDEX) {
            return Integer.parseUnsignedInt(token);
        }
        return Integer.parseUnsignedInt(token.substring(0, token.length() - 1));
    }

}