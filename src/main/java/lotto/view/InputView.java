package lotto.view;

import lotto.request.ManualRequest;
import lotto.request.MoneyRequest;
import lotto.request.WinningLottoRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String MONEY_NOT_NUMBER_MESSAGE = "구입 금액은 숫자여야 합니다. 숫자를 입력해 주세요.";
    private static final String WINNING_NOT_NUMBER_MESSAGE = "당첨 번호는 숫자여야 합니다. 숫자를 입력해 주세요.";
    private static final String BONUS_NOT_NUMBER_MESSAGE = "보너스 볼은 숫자여야 합니다. 숫자를 입력해 주세요.";
    private static final String COUNT_NOT_NUMBER_MESSAGE = "수동 로또 개수는 숫자여야 합니다. 숫자를 입력해 주세요.";
    private static final String LOTTO_NOT_NUMBER_MESSAGE = "로또 번호는 숫자여야 합니다. 숫자를 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);

    public MoneyRequest inputMoney() {
        return processInput(this::readMoney, MONEY_NOT_NUMBER_MESSAGE);
    }

    private MoneyRequest readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        long money = Long.parseLong(scanner.nextLine());
        System.out.println();
        return new MoneyRequest(money);
    }

    public ManualRequest inputManualLottoNumber() {
        int count = processInput(this::readManualCount, COUNT_NOT_NUMBER_MESSAGE);
        System.out.println();
        ManualRequest manualRequest = new ManualRequest(readManualLottoNumbers(count));
        System.out.println();
        return manualRequest;
    }

    private int readManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    private List<List<Integer>> readManualLottoNumbers(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = processInput(this::readLottoNumbers, LOTTO_NOT_NUMBER_MESSAGE);
            manualLottos.add(lottoNumbers);
        }
        return manualLottos;
    }

    public WinningLottoRequest inputWinningLotto() {
        List<Integer> lottoNumbers = processInput(this::readWinningNumbers, WINNING_NOT_NUMBER_MESSAGE);
        int bonusNumber = processInput(this::readBonusNumber, BONUS_NOT_NUMBER_MESSAGE);
        System.out.println();
        return new WinningLottoRequest(lottoNumbers, bonusNumber);
    }

    private int readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    private List<Integer> readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return readLottoNumbers();
    }

    private List<Integer> readLottoNumbers() {
        String numbers = scanner.nextLine();
        return Stream.of(numbers.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private <T> T processInput(Supplier<T> supplier, String message) {
        try {
            return supplier.get();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }
}
