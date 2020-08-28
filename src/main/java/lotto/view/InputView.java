package lotto.view;

import lotto.domain.LottoTickets;

import java.util.Scanner;
import java.util.stream.IntStream;

import static lotto.utils.CommonConstant.NUMBER_ZERO;

public class InputView {
    private static final String INPUT_BUY_PRICE = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO_QUANTITY = "개를 구매했습니다.";
    private static final String PRINT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PRINT_BONUS_LOTTONUMBER = "보너스 볼을 입력해 주세요.";

    public static int setPayPriceLotto(Scanner scanner) {
        System.out.println(INPUT_BUY_PRICE);
        return scanner.nextInt();
    }

    public static void printLottoBuyQuantity(int quantity) {
        System.out.println(quantity + BUY_LOTTO_QUANTITY);
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        IntStream.range(NUMBER_ZERO, lottoTickets.size())
                .mapToObj(lottoTickets::getLottoTicket)
                .forEach(System.out::println);
        System.out.println();
    }

    public static String setWinningNumber(Scanner scanner) {
        scanner.nextLine();
        System.out.println(PRINT_WINNING_NUMBER);
        return scanner.nextLine();
    }

    public static int setBonusLottoNumber(Scanner scanner) {
        System.out.println(PRINT_BONUS_LOTTONUMBER);
        return scanner.nextInt();
    }

}
