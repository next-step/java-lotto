package step2.view;

import step2.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static LottoDto inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseMoney = scanner.nextInt();

        return new LottoDto.Builder()
                .purchaseMoney(purchaseMoney)
                .build();
    }

    public static LottoDto inputCustomLottoNumberList() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int numberOfNonAutoLotto = scanner.nextInt();

        System.out.println("수동으로 구매할 로또 번호를 입력해 주세요.");
        List<String> nonLottoNumberList = new ArrayList<>();

        scanner.nextLine();

        for (int i = 0; i < numberOfNonAutoLotto; i++) {
            nonLottoNumberList.add(scanner.nextLine());
        }

        return new LottoDto.Builder()
                .nonAutoLottoNumberList(nonLottoNumberList)
                .numberOfNonAutoLotto(numberOfNonAutoLotto)
                .build();
    }

    public static LottoDto inputWinningLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String winningLottoNumber = scanner.nextLine();

        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.next();

        return new LottoDto.Builder()
                .winningLottoNumber(winningLottoNumber)
                .bonusNumber(bonusNumber)
                .build();
    }

}
