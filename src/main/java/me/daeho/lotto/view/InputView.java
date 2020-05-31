package me.daeho.lotto.view;

import me.daeho.lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final static String DELIMITER = ",";

    public static int amount() {
        System.out.println("구입금액을 입력해 주세요");
        return new Scanner(System.in).nextInt();
    }

    public static List<LottoNumber> lastWeekWinningNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return Arrays.stream(new Scanner(System.in).nextLine().split(DELIMITER))
                .map(Integer::valueOf)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
