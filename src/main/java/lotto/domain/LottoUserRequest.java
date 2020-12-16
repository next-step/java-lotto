package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LottoUserRequest {

    private final int ticketCount;
    private List<String> manualNumbers;

    public LottoUserRequest(int money) {
        this(money, null);
    }

    public LottoUserRequest(int money, List<String> manualNumbers) {
        this.ticketCount = toTicketCount(money);
        this.manualNumbers = toManualNumbers(manualNumbers);
    }

    private List<String> toManualNumbers(List<String> manualNumbers) {
        validateTicketCount(manualNumbers);
        return manualNumbers == null ? Collections.emptyList() : manualNumbers;
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

    private void validateTicketCount(List<String> manualTickets) {
        if (manualTickets == null) {
            return;
        }

        if (this.ticketCount < manualTickets.size()) {
            throw new IllegalArgumentException("구입가능한 로또 수를 초과했습니다.");
        }
    }

    public boolean hasManualIssueTarget() {
        return !manualNumbers.isEmpty();
    }

    public boolean hasAutoIssueTarget() {
        if (!hasManualIssueTarget()) {
            return true;
        }

        return this.ticketCount > manualNumbers.size();
    }

    public List<String> getManualNumbers() {
        return manualNumbers;
    }

    public int getAutoTicketCount() {
        return this.ticketCount - getManualTicketCount();
    }

    public int getManualTicketCount() {
        return manualNumbers.size();
    }
}
