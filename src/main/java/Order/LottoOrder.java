package Order;

public class LottoOrder extends Order{
    private final int manualTicketCounts;
    public LottoOrder(int money, int manualTicketCounts) {
        super(money);
        validate(manualTicketCounts);
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
}
