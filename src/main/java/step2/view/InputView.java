package step2.view;

import step2.domain.entity.Lotto;
import step2.domain.vo.LottoNumber;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");

        return SCANNER.nextInt();
    }

    public static Lotto inputLastLottoNumbers() {
        SCANNER.nextLine();

        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");

        final var number = SCANNER.nextLine();

        return Lotto.winner(number);
    }

    public static LottoNumber inputBonusLottoNumber() {
        System.out.println(System.lineSeparator() + "보너스 볼을 입력해 주세요.");

        final var number = SCANNER.nextLine();

        return new LottoNumber(Integer.parseInt(number));
    }
}
