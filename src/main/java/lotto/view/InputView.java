package lotto.view;

import lotto.model.LottoTicket;
import lotto.model.LottoTicketBundle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int inputPayAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return nextIntFromScanner();
    }

    public int inputManualLottoTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return nextIntFromScanner();
    }

    public void printManualLottoNumbers() {
        scanner.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return readIntegerListFromInput();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return nextIntFromScanner();
    }

    public LottoTicketBundle inputManualLottoNumbers(int manualLottoTicketCount) {
        return new LottoTicketBundle(
                IntStream.range(0, manualLottoTicketCount)
                        .mapToObj(i -> new LottoTicket(readIntegerListFromInput()))
                        .collect(Collectors.toList())
        );
    }

    private int nextIntFromScanner() {
        return scanner.nextInt();
    }

    private List<Integer> readIntegerListFromInput() {
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
