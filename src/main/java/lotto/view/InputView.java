package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;

public class InputView {
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    public static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Long askTotalMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.valueOf(SCANNER.nextLine());
    }

    public static int askNumberOfManualLottoTicket() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static LottoTickets askManualTicketNumbers(int numberOfManualLottoTicket) {
        if (numberOfManualLottoTicket <= 0) {
            return new LottoTickets(Collections.emptyList());
        }
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfManualLottoTicket; i++) {
            String lottoNumbers = SCANNER.nextLine();
            LottoTicket lottoTicket = Arrays.stream(lottoNumbers.split(LOTTO_NUMBER_DELIMITER))
                    .map(Integer::new)
                    .map(LottoNumber::of)
                    .collect(collectingAndThen(toSet(), LottoTicket::new));
            lottoTickets.add(lottoTicket);
        }
        return new LottoTickets(lottoTickets);
    }

    public static Set<LottoNumber> askLastWeekWinningNumbers() {
        System.out.println("지난주 당첨번호를 입력해주세요.");
        String winningNumbers = SCANNER.nextLine();
        return Arrays.stream(winningNumbers.split(LOTTO_NUMBER_DELIMITER))
                .map(winningNumber -> Integer.valueOf(winningNumber.trim()))
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public static int askBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요");
        return Integer.parseInt(SCANNER.nextLine());
    }

}
