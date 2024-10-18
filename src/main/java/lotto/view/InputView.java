package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static LottoTickets getLottoTickets() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(SCANNER.nextLine());
        return LottoTickets.createByPrice(price);
    }

    public static LottoTicket getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new LottoTicket(Arrays.stream(SCANNER.nextLine().split(", "))
                                     .map(Integer::parseInt)
                                     .collect(Collectors.toList()));
    }
}
