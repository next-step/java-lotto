package lotto.view;

import lotto.dto.ManualLottosRequestDto;
import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningNumbersRequestDto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public MoneyRequestDto inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        long money = parseLong(scanner.nextLine());
        return new MoneyRequestDto(money);
    }

    public ManualLottosRequestDto inputManualLottos() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        long manualCount = parseLong(scanner.nextLine());
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> lottos = LongStream.range(0, manualCount)
                .mapToObj(l -> parseLottoNumbers(scanner.nextLine().split(", ")))
                .collect(Collectors.toList());
        return new ManualLottosRequestDto(manualCount, lottos);
    }

    public WinningNumbersRequestDto inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] numbers = scanner.nextLine().split(", ");
        List<Integer> lottoNumbers = parseLottoNumbers(numbers);
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = parseInt(scanner.nextLine());
        return new WinningNumbersRequestDto(lottoNumbers, bonusNumber);
    }

    private long parseLong(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력했습니다. 입력 값: " + value);
        }
    }

    private List<Integer> parseLottoNumbers(String[] numbers) {
        try {
            return Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 중 숫자가 아닌 값이 있습니다. 입력 값: " + Arrays.toString(numbers));
        }
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력했습니다. 입력 값: " + value);
        }
    }
}
