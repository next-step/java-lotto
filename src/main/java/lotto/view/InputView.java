package lotto.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

import lotto.domain.User;
import lotto.domain.vo.Money;
import lotto.view.exception.InvalidInputException;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public User getUserInput() {
        return wrapMethodCall(this::doGetUserInput);
    }

    public List<Integer> getLastWeekLottoResult() {
        return wrapMethodCall(this::doGetLastWeekLottoResult);
    }

    private User doGetUserInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        User user = new User(new Money(scanner.nextInt()));
        clearBuffer();

        return user;
    }

    private List<Integer> doGetLastWeekLottoResult() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> lottoNumbers = Arrays.stream(scanner.nextLine().split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());
        System.out.println();

        return lottoNumbers;
    }

    private <T> T wrapMethodCall(Supplier<T> method) {
        try {
            return method.get();
        } catch (Exception e) {
            throw new InvalidInputException("잘못된 형식의 입력을 입력하셨습니다.");
        }
    }

    private void clearBuffer() {
        scanner.nextLine();
    }
}
