package lotto.view;

import lotto.domain.model.lotto.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public PurchaseAmount inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new PurchaseAmount(Integer.parseInt(scanner.nextLine()));
    }

    public TicketCount inputManualTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new TicketCount(Integer.parseInt(scanner.nextLine()));
    }

    public List<LottoTicket> inputManualTicketNumbers(final TicketCount manualTicketCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoTicket> tickets = new ArrayList<>();
        
        for (int i = 0; i < manualTicketCount.getCount(); i++) {
            tickets.add(new LottoTicket(inputLottoNumbers()));
        }
        
        return tickets;
    }

    public BonusNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new BonusNumber(Integer.parseInt(scanner.nextLine()));
    }

    public Set<LottoNumber> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return inputLottoNumbers();
    }

    private Set<LottoNumber> inputLottoNumbers() {
        String[] tokens = scanner.nextLine().split(",");

        return Stream.of(tokens)
                .map(token -> Integer.parseInt(token.trim()))
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    public void close() {
        scanner.close();
    }
}
