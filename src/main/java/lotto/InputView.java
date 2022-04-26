package lotto;

import lotto.util.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class InputView {

    private static final String USER_INPUT_DELIMITER = ", ";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int insertLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputScannerInt();
    }

    private int inputScannerInt() {
        return scanner.nextInt();
    }

    public Lotto insertWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String winningLotto = inputScannerString();

        return stream(winningLotto.split(USER_INPUT_DELIMITER))
                .map(LottoNumber::new)
                .collect(collectingAndThen(toList(), Lotto::new));
    }

    private String inputScannerString() {
        return scanner.nextLine();
    }

    public int insertBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return inputScannerInt();
    }

    public int insertDirectlyBoughtCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return inputScannerInt();
    }

    public List<String[]> insertDirectlyBoughtLottoList(int directlyBoughtCount) {
        scanner.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<String[]> directlyStringList = new ArrayList<>();

        for (int i = 0; i < directlyBoughtCount; i++) {
            directlyStringList.add(scanner.nextLine().split(USER_INPUT_DELIMITER));
        }

        return directlyStringList;
    }
}
