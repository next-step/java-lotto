package lotto_auto.view;

import lotto_auto.model.LottoNumbers;
import lotto_auto.model.Money;
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
        Money money = enterMoney();
        List<LottoNumbers> manualLottoNumbers = enterLottoNumbers();
        return new Order(manualLottoNumbers, money);
    }

    public static Money enterMoney() {
        System.out.println(ENTER_BUY_LOTTO_MONEY_MESSAGE);
        int money = scanner.nextInt();
        return new Money(money);
    }

    private static int enterManualLottoCount() {
        System.out.println(ENTER_MANUAL_LOTTO_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    private static List<LottoNumbers> enterLottoNumbers() {
        int count = enterManualLottoCount();
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
