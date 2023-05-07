package step2.view;

import step2.domain.entity.Lotto;
import step2.domain.entity.LottoFactory;
import step2.domain.vo.LottoNumber;
import step2.domain.vo.LottoType;
import step2.domain.vo.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Money inputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");

        final var money = SCANNER.nextInt();

        return new Money(money);
    }

    public static int inputManualLottoQuantity(Money input) {
        System.out.println(System.lineSeparator() + "수동으로 구매할 로또 수를 입력해 주세요.");

        final var money = input.getMoney();
        final var quantity = SCANNER.nextInt();
        final var needMoney = Lotto.PRICE * quantity;

        if (needMoney > money) {
            final var message = String.format(
                    "금액이 부족하여 로또를 구매할 수 없습니다. 구매 가능한 로또 수량: %d, 필요금액: %d, 보유금액: %d",
                    money / Lotto.PRICE,
                    needMoney,
                    money
            );
            throw new IllegalStateException(message);
        }

        return quantity;
    }

    public static List<Lotto> inputManualLotto(int quantity) {
        SCANNER.nextLine();

        System.out.println(System.lineSeparator() + "수동으로 구매할 번호를 입력해 주세요.");

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            final var numbers = SCANNER.nextLine();
            lottos.add(LottoFactory.of(LottoType.MANUAL, numbers));
        }

        return lottos;
    }

    public static String inputLastLottoNumbers() {
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");

        return SCANNER.nextLine();
    }

    public static LottoNumber inputBonusLottoNumber() {
        System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");

        final var number = SCANNER.nextLine();

        return new LottoNumber(Integer.parseInt(number));
    }
}
