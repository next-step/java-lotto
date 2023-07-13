package lotto.view;

import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningLottoRequestDto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public MoneyRequestDto inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        long money = Long.parseLong(scanner.nextLine());
        return new MoneyRequestDto(money);
    }

    public WinningLottoRequestDto inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();
        List<Integer> lottoNumbers = Stream.of(numbers.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return new WinningLottoRequestDto(lottoNumbers, bonusNumber);
    }
}
