package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

public class InputView {

    public static Money totalPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new Money(scanner.nextInt());
    }

    public static int manualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<String> manualLottos(int numberOfLotto) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            result.add(scanner.nextLine());
        }
        return result;
    }

    public static Lotto winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new Lotto(scanner.nextLine());
    }

    public static LottoNumber bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return LottoNumber.of(scanner.nextInt());
    }
}
