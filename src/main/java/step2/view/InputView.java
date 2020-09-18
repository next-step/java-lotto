package step2.view;

import step2.dto.LottoDto;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static LottoDto inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseMoney = scanner.nextInt();

        return new LottoDto.Builder()
                .purchaseMoney(purchaseMoney)
                .build();
    }

    public static LottoDto inputWinningLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        String winningLottoNumber = scanner.nextLine();

        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.next();

        return new LottoDto.Builder()
                .winningLottoNumber(winningLottoNumber)
                .bonusNumber(bonusNumber)
                .build();
    }

}
