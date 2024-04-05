package lotto.view;

import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String SEPARATOR = ",";

    Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        int money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public LottoTicket lastWeekLottoNumber() {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Integer[] lastWeekLottoNumber = Arrays.stream(scanner.nextLine().split(SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
      return   new LottoTicket(lastWeekLottoNumber);
    }
}
