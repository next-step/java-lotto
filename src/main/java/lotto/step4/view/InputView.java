package lotto.step4.view;

import lotto.step4.domain.LottoCount;
import lotto.step4.domain.ManualLotto;
import lotto.step4.domain.WinningNumbers;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_TEXT_BUY = "구입금액을 입력해 주세요.";
    public static final String TEXT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String NUMBER_DELIMITER = ",";
    public static final String TEXT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String TEXT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String TEXT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.(숫자 6개 쉼표로 구분 후 개행, 입력을 다하셨으면 enter를 한 번 더 입력해주세요.)";
    public static List<Set<Integer>> manualLottos = new ArrayList<>();
    public LottoCount lottoCount;

    public LottoCount inputPrice() {
        System.out.println(INPUT_TEXT_BUY);
        int price = SCANNER.nextInt();
        lottoCount = new LottoCount(price);
        return lottoCount;
    }

    public ManualLotto inputManualLotto() {
        System.out.println(TEXT_MANUAL_LOTTO_COUNT);
        int count = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println(TEXT_MANUAL_LOTTO_NUMBERS);
        while (SCANNER.hasNextLine()) {
            String line = SCANNER.nextLine();
            if (line.isEmpty()) {
                break;
            }
            Set<Integer> lotto = Arrays.stream(line.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
            manualLottos.add(lotto);
        }

        int manualCount = manualLottos.size();
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + (lottoCount.getLottoCount() - manualCount) + "개를 구매했습니다.");
        return new ManualLotto(count, manualLottos);
    }

    public WinningNumbers inputWinningNumbers() {
        System.out.println();
        System.out.println(TEXT_WINNING_NUMBERS);
        String[] numbers = SCANNER.next().split(NUMBER_DELIMITER);
        Set<Integer> winningNumbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        System.out.println(TEXT_BONUS_NUMBER);
        int bonusNumber = SCANNER.nextInt();

        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}
