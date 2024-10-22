package lotto.view;

import lotto.utils.StringUtils;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator inputValidator = new InputValidator();

    public int getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");

        String inputPrice = scanner.nextLine();
        inputValidator.validate(inputPrice);

        return Integer.parseInt(inputPrice);
    }

    public int getPassiveLottoTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        String inputPassiveLottoTicketCount = scanner.nextLine();
        inputValidator.validate(inputPassiveLottoTicketCount);

        return Integer.parseInt(inputPassiveLottoTicketCount);
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String inputWinningNumbers = scanner.nextLine();

        return Arrays.stream(StringUtils.splitByComma(inputWinningNumbers))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine());
    }

}
