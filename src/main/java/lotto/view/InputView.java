package lotto.view;

import lotto.domain.numbers.LottoNumber;
import lotto.domain.numbers.LottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPLIT_TEXT = ", ";
    private static final Scanner scanner = new Scanner(System.in);

    public static long enterMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해 주세요.");
        }
    }

    public static int enterManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해 주세요.");
        }
    }

    public static List<LottoTicket> enterManualLottoNumbers(int countOfManualLottoTicket) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        for (int index = 0; index < countOfManualLottoTicket; index++) {
            manualLottoTickets.add(new LottoTicket(makeLottoNumbers(scanner.nextLine())));
        }
        return manualLottoTickets;
    }

    public static List<LottoNumber> enterWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return makeLottoNumbers(scanner.nextLine());
    }

    public static int enterBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해 주세요.");
        }
    }

    private static List<LottoNumber> makeLottoNumbers(String numbers) {
        return Arrays.stream(numbers.split(SPLIT_TEXT))
                .map(number -> LottoNumber.of(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }
}
