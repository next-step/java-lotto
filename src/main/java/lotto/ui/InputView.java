package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String SPACE_REGEX = "\\s+";
    private static final String COMMA_REGEX = ",";
    private static final String EMPTY = "";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int askToPay() {
        System.out.println("구입금액을 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public int askManualTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<List<Integer>> askLottoNumbers(int ticketCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> tickets = new ArrayList<>();
        IntStream.range(0, ticketCount)
                .forEach(i -> tickets.add(lottoNumbers()));
        return tickets;
    }

    public List<Integer> askWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return lottoNumbers();
    }

    private List<Integer> lottoNumbers() {
        String[] userInputs = scanner.nextLine().replaceAll(SPACE_REGEX, EMPTY).split(COMMA_REGEX);
        return Arrays.stream(userInputs)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public int askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
