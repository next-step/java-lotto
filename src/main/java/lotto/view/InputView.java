package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final int ONE_SALE_PRICE = 1000;
    private static final Scanner scanner = new Scanner(System.in);

    public void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        int lottoCount = money / ONE_SALE_PRICE;

        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputNumbers = scanner.nextLine().split(",");
        return  Stream.of(inputNumbers).map(Integer::parseInt).collect(Collectors.toList());
    }
}
