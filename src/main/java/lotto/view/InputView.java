package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public int buyLotto() {
        System.out.println("구매할 로또 금액을 입력하세요.");
        return sc.nextInt();
    }

    public List<Integer> lastWeekendNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        List<Integer> lastLottos = makeCorrectNumber(sc.next());
        Collections.sort(lastLottos);
        return lastLottos;
    }

    private List<Integer> makeCorrectNumber(String text) {
        return Arrays.stream(text.split(","))
                     .map(str -> Integer.parseInt(str))
                     .collect(Collectors.toList());
    }
}
