package lotto.view;

import lotto.domain.Ball;
import lotto.domain.Lotto;
import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class InputView {


    private static Scanner scanner;

    public static int inputBuyMoney() {
        scanner = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주새요.");
        return scanner.nextInt();
    }

    public static int inputManualLottoCount() {
        scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Lotto> inputManualLottoNumbers(int count) {
        scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.from(StringUtils.generateStringToBalls(scanner.nextLine())));
        }
        return lottos;
    }

    public static Lotto inputPreviousLottoNumber() {
        scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Set<Ball> lottoNumbers = StringUtils.generateStringToBalls(scanner.nextLine());
        return Lotto.from(lottoNumbers);
    }

    public static Ball inputBonusNumber() {
        scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return Ball.from(scanner.nextInt());
    }

}
