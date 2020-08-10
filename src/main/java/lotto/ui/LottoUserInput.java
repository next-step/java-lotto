package lotto.ui;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.ui.LottoDisplay.display;

public class LottoUserInput {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String SPLIT_STR = ",";

    public static int inputPurchaseAmount() {
        display("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static Set<Integer> inputWinLotto() {
        display("지난 주 당첨 번호를 입력해 주세요.");
        String[] lottos =  scanner.next()
                                 .trim()
                                 .split(SPLIT_STR);
        return Stream.of(lottos)
                     .map(String::trim)
                     .map(Integer::valueOf)
                     .collect(Collectors.toCollection(LinkedHashSet::new))
            ;
    }
}
