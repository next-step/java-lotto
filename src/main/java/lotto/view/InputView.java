package lotto.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.LottoResult;
import lotto.domain.vo.Money;
import lotto.domain.User;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public User getUserInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        User user = new User(new Money(scanner.nextInt()));
        clearBuffer();

        return user;
    }

    public LottoResult getLastWeekLottoResult() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<LottoNumber> lottoNumbers = Arrays.stream(scanner.nextLine().split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(toList());
        System.out.println();

        return new LottoResult(lottoNumbers);
    }

    private void clearBuffer() {
        scanner.nextLine();
    }
}
