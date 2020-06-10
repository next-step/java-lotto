package lotto.model;

public class PurchaseInfo {

    private final PurchasedLottoTickets manualTickets;
    private final PurchasedLottoTickets autoTickets;

    private PurchaseInfo(PurchasedLottoTickets manualTickets, PurchasedLottoTickets autoTickets) {
        validate(manualTickets, autoTickets);

        this.manualTickets = manualTickets;
        this.autoTickets = autoTickets;
    }

    public static PurchaseInfo create(PurchasedLottoTickets manualTickets, PurchasedLottoTickets autoTickets) {
        return new PurchaseInfo(manualTickets, autoTickets);
    }

    private void validate(PurchasedLottoTickets manualTickets, PurchasedLottoTickets autoTickets) {
        if (manualTickets == null || autoTickets == null) {
            throw new IllegalArgumentException("수동으로 구매할 로또와 자동으로 구매할 로또를 입력해주세요.");
        }
    }

    public int getCountOfManualTickets() {
        return manualTickets.count();
    }

    public int getCountOfAutoTickets() {
        return autoTickets.count();
    }

    public PurchasedLottoTickets getAllTickets() {
        return manualTickets.merged(autoTickets);
    }
}
