package step4.View;

import step4.Lotto;
import step4.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public int inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int passivePurchase() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public void passiveLottoNumberPrint() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public String passiveLottoNumber() {
        return scanner.next();
    }

    public Lotto inputLastInteger() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] convertText = scanner.next().split(",");
        return new Lotto(
                Arrays.stream(convertText)
                        .map(LottoNumber::of)
                        .collect(Collectors.toSet()));
    }

    public int inputBonus() {
        System.out.println("보너스 번호 입력해주세요.");
        return scanner.nextInt();
    }


}
