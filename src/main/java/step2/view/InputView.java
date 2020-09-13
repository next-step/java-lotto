package step2.view;

import step2.Dto.LottoDto;
import step2.domain.Lotto;

import java.util.Scanner;

public class InputView {

    public static LottoDto inputPurchaseMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseMoney = scanner.nextInt();
        return new LottoDto(purchaseMoney);
    }

    public static LottoDto inputWinningLottoNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLottoNumber = scanner.next();
        return new LottoDto(winningLottoNumber);
    }

}
