package order;

public class LottoOrder {
    private final int manualTicketCounts;
    private final Money money;
    public LottoOrder(Money money, int manualTicketCounts) {
        validate(manualTicketCounts);
        this.money = money;
        this.manualTicketCounts = manualTicketCounts;
    }

    private void validate(int manualTicketCounts) {
        if (manualTicketCounts < 0) {
            throw new IllegalArgumentException("수동 티켓 장수는 음수일 수 없습니다");
        }
    }

    public int getManualTicketCounts() {
        return manualTicketCounts;
    }

    public int getMoney() {
        return money.getMoney();
    }
}
