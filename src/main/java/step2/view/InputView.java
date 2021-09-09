package step2.view;

import step2.domain.lotto.*;
import step2.domain.statistics.Amount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public InputDto inputValue() {
        System.out.println("구입금액을 입력해 주세요.");
        final int price = Integer.parseInt(scanner.nextLine());

        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        final int amount = Integer.parseInt(scanner.nextLine());

        List<Lotto> lottoList = new ArrayList<>();
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < amount; i++) {
            final String inputManualLottoNumber = scanner.nextLine();
            lottoList.add(new Lotto(new LottoNumbers(convertStringToListOfNumber(inputManualLottoNumber))));
        }

        return new InputDto(new Price(price), new Amount(amount), lottoList);
    }

    public LottoNumbers inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        final String inputLastWeekWinningNumbers = scanner.nextLine();
        return new LottoNumbers(convertStringToListOfNumber(inputLastWeekWinningNumbers));
    }

    public static List<Integer> convertStringToListOfNumber(String input) {
        final String[] split = input.replaceAll(" ", "").split(",");
        return Arrays.stream(split)
                .map(Integer::valueOf)
                .collect(Collectors
                        .toList());
    }

    public LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(Integer.parseInt(scanner.nextLine()));
    }
}
