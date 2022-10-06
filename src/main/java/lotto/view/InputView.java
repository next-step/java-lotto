package lotto.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lotto.domain.User;
import lotto.domain.vo.Money;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public User getUserInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        User user = new User(new Money(scanner.nextInt()));
        clearBuffer();

        return user;
    }

    public List<Integer> getLastWeekLottoResult() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> lottoNumbers = Arrays.stream(scanner.nextLine().split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());
        System.out.println();

        return lottoNumbers;
    }

    private void clearBuffer() {
        scanner.nextLine();
    }
}
