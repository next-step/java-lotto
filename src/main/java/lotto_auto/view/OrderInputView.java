package lotto_auto.view;

import lotto_auto.ErrorMessage;
import lotto_auto.model.LottoNumbers;
import lotto_auto.model.LottoTicket;
import lotto_auto.model.Order;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderInputView {

    private static final String ENTER_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ENTER_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String ENTER_BUY_LOTTO_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static Order enterOrder() {
        int money = enterMoney();
        int ticketCount = money / LottoTicket.PRICE;
        int count = enterManualLottoCount();
        List<LottoNumbers> lottoNumbers = enterLottoNumbers(count);
        return new Order(lottoNumbers, ticketCount - lottoNumbers.size());
    }

    public static int enterMoney() {
        System.out.println(ENTER_BUY_LOTTO_MONEY_MESSAGE);
        int money = scanner.nextInt();
        throwIfNegativeMoney(money);
        return money;
    }

    private static void throwIfNegativeMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_MONEY);
        }
    }

    private static int enterManualLottoCount() {
        System.out.println(ENTER_MANUAL_LOTTO_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    private static List<LottoNumbers> enterLottoNumbers(int count) {
        System.out.println(ENTER_MANUAL_LOTTO_NUMBERS_MESSAGE);
        return IntStream.range(0, count)
                .boxed()
                .map(item -> {
                    String lottoNumberString = scanner.next();
                    LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberString);
                    return lottoNumbers;
                })
                .collect(Collectors.toList());
    }
}
