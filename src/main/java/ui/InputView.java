package ui;

import exception.InvalidBonusNumberException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INSERT_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INSERT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INSERT_MANUAL_NUMBER_OF_LOTTOS = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INSERT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요." ;
    private static final String COMMA = ",";
    private static final String SKIP_LINE = "[\\r\\n]+";
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_LIMIT = 45;
    private static final int MIN_LIMIT = 1;

    public static Long askMoneyAmount(){
        System.out.println(INSERT_MONEY_AMOUNT);
        return scanner.nextLong();
    }

    public static List<Integer> askWinningNumbers() {
        System.out.println(INSERT_WINNING_NUMBERS);

        List<Integer> winningNumbers = Arrays.stream(scanner.nextLine().split(COMMA))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        return winningNumbers;
    }

    public static int askBonusNumber() throws InvalidBonusNumberException {
        System.out.println(INSERT_BONUS_NUMBER);
        int bonusNumber =  scanner.nextInt();

        if(bonusNumber > MAX_LIMIT || bonusNumber < MIN_LIMIT) {
            throw new InvalidBonusNumberException();
        }

        return bonusNumber;
    }

    public static int askNumberOfManualLottos() {
        System.out.println(INSERT_MANUAL_NUMBER_OF_LOTTOS);
        return scanner.nextInt();
    }

    public static List<List<Integer>> askManualLottoNumbers(int numberOfManualLottos) throws Exception {
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();

        System.out.println(INSERT_MANUAL_LOTTO_NUMBERS);
        scanner.skip(SKIP_LINE);

        for(int i = 0; i < numberOfManualLottos; i++) {
            manualLottoNumbers.add(Arrays.stream(scanner.nextLine().split(COMMA))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList()));
        }

        return manualLottoNumbers;
    }
}
