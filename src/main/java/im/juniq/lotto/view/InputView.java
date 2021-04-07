package im.juniq.lotto.view;

import im.juniq.lotto.domain.LottoNumber;
import im.juniq.lotto.domain.LottoNumbers;
import im.juniq.lotto.domain.Price;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static Price purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new Price(scanner.next());
    }

    public static LottoNumbers winningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new LottoNumbers(scanner.next());
    }

    public static LottoNumber bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new LottoNumber(scanner.next());
    }

    public static List<LottoNumbers> manualLottoes() {
        int manualLottoesCount = manualLottoesCount();
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<LottoNumbers> list = new ArrayList<>();
        for (int i = 0; i < manualLottoesCount; i++) {
            list.add(new LottoNumbers(scanner.next()));
        }
        return list;
    }

    private static int manualLottoesCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.next());
    }
}
