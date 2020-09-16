package step2.view;

import step2.dto.LottoDto;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static LottoDto inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseMoney = scanner.nextInt();

        return new LottoDto(purchaseMoney);
    }

    public static LottoDto inputWinningLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLottoNumber = scanner.next();

        return new LottoDto(winningLottoNumber);
    }

}
