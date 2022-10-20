package lotto.view;

import lotto.domain.ManualLottoCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
        throw new AssertionError("InputView는 생성자를 호출할 수 없습니다.");
    }

    public static String receiveMoney() {
        System.out.println("로또 금액을 입력해주세요. 로또는 개당 천원입니다.");
        return new Scanner(System.in).nextLine()
                .trim();
    }

    public static List<String> receiveLastWeekWinningNumber() {
        System.out.println("지난주 당첨 번호를 입력해 주세요. 콤마로 숫자 6개를 구분해주세요.");
        String lastWeekNumberString = new Scanner(System.in).nextLine();
        String[] lastWeekNumbers = lastWeekNumberString.split(",");
        return Arrays.stream(lastWeekNumbers)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static String receiveBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextLine()
                .trim();
    }

    public static String receiveManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new Scanner(System.in).nextLine()
                .trim();
    }

    public static List<String> receiveManualLottos(ManualLottoCount manualLottoCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 번호를 입력해 주세요.");
        List<String> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount.getValue(); i++) {
            lottos.add(scanner.nextLine());
        }
        return lottos;
    }
}
