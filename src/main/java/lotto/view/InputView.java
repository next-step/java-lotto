package lotto.view;

import lotto.domain.ticket.LottoNumber;
import lotto.domain.winning.WinningNumbers;
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

    public WinningNumbers getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        List<Integer> winningNumbers = Arrays.stream(StringUtils.splitByComma(scanner.nextLine()))
                                             .map(Integer::parseInt)
                                             .collect(Collectors.toList());

        return new WinningNumbers(winningNumbers, getBonusNumber());
    }

    public LottoNumber getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return new LottoNumber(Integer.parseInt(scanner.nextLine()));
    }

}
