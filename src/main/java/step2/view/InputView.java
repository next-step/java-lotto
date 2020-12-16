package step2.view;

import step2.domain.Request;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.*;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public Request putPurchaseMoney() {
        printMessage("구입금액을 입력해 주세요.");
        Request request = null;
        try {
            int money = scanner.nextInt();
            checkMoney(money);
            request = new Request(money);
            scanner.nextLine();
        } catch (Exception e) {
            scanner.close();
            throw new IllegalArgumentException("1,000원 이상의 금액을 숫자로 입력하세요", e);
        }
        return request;
    }

    public List<Integer> putTargetNumber() {
        printMessage("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> target = null;
        try {
            String input = scanner.nextLine();
            String[] numbers = input.split(",");
            checkNumber(numbers);
            target = getTargetNumbers(numbers);
        } catch (Exception e) {
            throw new IllegalArgumentException("지난주 당첨 번호를 6개 입력하세요", e);
        } finally {
            scanner.close();
        }
        return target;
    }

    private void checkMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("1,000원 이상의 금액을 입력하세요");
        }
    }

    private void checkNumber(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("6개의 숫자가 필요합니다");
        }
    }

    private List<Integer> getTargetNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(t -> Integer.parseInt(t.trim()))
                .boxed()
                .collect(toList());
    }
}
