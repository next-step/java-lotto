package lotto.views;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domains.Lotto;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public String inputPurchaseCountByManual() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public List<String> inputLottoByManual(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> inputList = IntStream
                .range(0, count)
                .boxed()
                .map(i -> scanner.nextLine())
                .collect(Collectors.toList());
        System.out.println();
        return inputList;
    }

    public void printPurchasedLottoList(List<Lotto> manualLottoList, List<Lotto> autoLottoList) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottoList.size(), autoLottoList.size());
        System.out.println();
        manualLottoList.forEach(System.out::println);
        autoLottoList.forEach(System.out::println);
        System.out.println();
    }

    public String inputLastWinner() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input =  scanner.nextLine();
        System.out.println();
        return input;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }
}
