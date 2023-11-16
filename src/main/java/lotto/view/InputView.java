package lotto.view;

import lotto.domain.LottoCenter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public int buyTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        int cash = scanner.nextInt();
        int issuedTicket = new LottoCenter().buyLotto(cash);

        System.out.println(issuedTicket + "개를 구매했습니다.");
        return issuedTicket;
    }

    public List<Integer> winningNumberInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String input = scanner.nextLine().replaceAll("\\s", "");
        String[] split = input.split(",");

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
