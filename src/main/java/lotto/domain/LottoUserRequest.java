package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LottoUserRequest {
    private final int ticketCount;
    private Optional<List<String>> manualNumbers;

    public LottoUserRequest(int money) {
        this(money, null);
    }

    public LottoUserRequest(int money, String[] manualTickets) {
        this.ticketCount = toTicketCount(money);
        this.manualNumbers = toManualTickets(manualTickets);
    }

    private Optional<List<String>> toManualTickets(String[] manualTickets) {
        if (manualTickets == null) {
            return Optional.empty();
        }

        validateTicketCount(manualTickets);
        return Optional.of(Arrays.asList(manualTickets));
    }

    private int toTicketCount(int money) {
        validateMoney(money);
        return money / LottoTickets.TICKET_PRICE;
    }

    private void validateMoney(int money) {
        if (money < LottoTickets.TICKET_PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

    private void validateTicketCount(String[] manualTickets) {
        if (manualTickets == null) {
            return;
        }

        if (this.ticketCount < manualTickets.length) {
            throw new IllegalArgumentException("구입가능한 로또 수를 초과했습니다.");
        }
    }

    public boolean hasManualIssueTarget() {
        return manualNumbers.isPresent();
    }

    public boolean hasAutoIssueTarget() {
        if (!hasManualIssueTarget()) {
            return true;
        }

        return this.ticketCount > manualNumbers.get().size();
    }

    public Optional<List<String>> getManualNumbers() {
        return manualNumbers;
    }

    public int getAutoTicketCount() {
        if (!hasManualIssueTarget()) {
            return this.ticketCount;
        }

        return this.ticketCount - manualNumbers.get().size();
    }
}
