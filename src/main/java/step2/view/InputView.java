package step2.view;

import step2.domain.LottoRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.*;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public LottoRequest putPurchaseMoney() {
        printMessage("구입금액을 입력해 주세요.");
        LottoRequest lottoRequest = null;
        try {
            int money = scanner.nextInt();
            checkMoney(money);
            lottoRequest = new LottoRequest(money);
            scanner.nextLine();
        } catch (Exception e) {
            scanner.close();
            throw new IllegalArgumentException("1,000원 이상의 금액을 숫자로 입력하세요", e);
        }
        return lottoRequest;
    }

    public List<Integer> putTargetNumber() {
        printMessage("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> target = null;
        try {
            String input = scanner.nextLine();
            String[] numbers = input.split(",");
            target = getTargetNumbers(numbers);
            checkNumber(target, 6);
        } catch (Exception e) {
            scanner.close();
            throw new IllegalArgumentException("지난주 당첨 번호를 6개 입력하세요", e);
        }
        return target;
    }

    public Integer putBonusNumber(List<Integer> targetNumber) {
        printMessage("보너스 볼을 입력해 주세요.");
        List<Integer> bonus = null;
        Integer bonusNumber = 0;
        try {
            bonus = getTargetNumbers(scanner.nextLine());
            checkNumber(bonus, 1);
            bonusNumber = bonus.get(0);
            checkDuplicatedNumber(bonusNumber, targetNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("당첨 번호를 제외한 숫자를 입력하세요", e);
        } finally {
            scanner.close();
        }
        return bonusNumber;
    }

    private void checkDuplicatedNumber(Integer bonusNumber, List<Integer> targetNumber) {
        if (targetNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 중복됩니다");
        }
    }

    private void checkMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("1,000원 이상의 금액을 입력하세요");
        }
    }

    private void checkNumber(List<Integer> target, int length) {
        if (target.size() != length) {
            throw new IllegalArgumentException("1 ~ 45 범위의 " + length + "개의 숫자가 필요합니다");
        }
    }

    private List<Integer> getTargetNumbers(String... numbers) {
        return Arrays.stream(numbers)
                .distinct()
                .mapToInt(t -> Integer.parseInt(t.trim()))
                .filter(n -> n > 0 && n < 46)
                .boxed()
                .collect(toList());
    }
}
