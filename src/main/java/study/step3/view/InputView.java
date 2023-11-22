package study.step3.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import study.step3.domain.Lotto;
import study.step3.domain.LottoNumber;
import study.step3.domain.dto.LottoCount;
import study.step3.domain.dto.PurchaseAmount;

import static study.step3.view.InputParser.parse;

public class InputView {

    public static PurchaseAmount inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return new PurchaseAmount(scanner.nextInt());
    }

    public static LottoCount inputManualLottoCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return new LottoCount(scanner.nextInt());
    }

    public static List<Lotto> inputManualLottoNumbers(LottoCount lottoCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, lottoCount.count())
            .mapToObj(n -> new Lotto(parse(scanner.nextLine())))
            .collect(Collectors.toList());
    }

    public static Lotto inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(parse(scanner.nextLine()));
    }

    public static LottoNumber inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(scanner.nextInt());
    }
}
