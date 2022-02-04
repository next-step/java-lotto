package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoFullNumber;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

public class UserConsole {

    private static final String FIRST_MESSAGE = "구입 금액을 입력해 주세요";
    private static final String SECOND_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String THIRD_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String SPACE_DELIMITER = " ";
    private static final String BLANK_DELIMITER = "";
    private static final String COMMA = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private UserConsole() {

    }

    public static Money inputString() {
        System.out.println(FIRST_MESSAGE);
        int money = Integer.valueOf(scanner.nextLine());
        return new Money(money);
    }

    public static LottoFullNumber winningLottoNumber() {
        System.out.println(SECOND_MESSAGE);
        String input = scanner.nextLine();
        List<LottoNumber> winningLottoNumber =
            Arrays.stream(input.replace(SPACE_DELIMITER, BLANK_DELIMITER).split(COMMA))
                .mapToInt(Integer::new)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoFullNumber(winningLottoNumber);
    }

    public static LottoNumber bonusLottoNumber() {
        System.out.println(THIRD_MESSAGE);
        int bonusLottoNumber = Integer.valueOf(scanner.nextLine());
        return new LottoNumber(bonusLottoNumber);
    }
}

