package lotto.ui;


import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static int getLottoPurchaseAmount() {
        String line = SCANNER.nextLine();
        return parseInt(line);
    }

    private static int parseInt(String numericString) {
        try {
            return Integer.parseInt(numericString.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요 " + numericString);
        }
    }

    public static List<Integer> getLastWinningNumber() {
        return getNumberList();
    }

    public static int getBonusNumber() {
        return getANumber();
    }

    public static int getCountOfManualLotto() {
        return getANumber();
    }

    private static int getANumber() {
        String line = SCANNER.nextLine();
        return parseInt(line);
    }

    public static Lottos getManualLottos(int countOfManualLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countOfManualLottos; i++) {
            lottos.add(new Lotto(getNumberList()));
        }
        return new Lottos(lottos);
    }

    private static List<Integer> getNumberList() {
        String line = SCANNER.nextLine();
        String[] numericStrings = line.split(DELIMITER);

        return toIntegerList(numericStrings);
    }

    private static List<Integer> toIntegerList(String[] numericStrings) {
        List<Integer> integerList = new ArrayList<>();
        for (String numericString : numericStrings) {
            integerList.add(parseInt(numericString));
        }
        return integerList;
    }

}
