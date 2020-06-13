package lotto.model;

public class PurchaseInfo {

    private final PurchasedLottoTickets manualTickets;
    private final PurchasedLottoTickets automaticTickets;

    private PurchaseInfo(PurchasedLottoTickets manualTickets, PurchasedLottoTickets automaticTickets) {
        validate(manualTickets, automaticTickets);

        this.manualTickets = manualTickets;
        this.automaticTickets = automaticTickets;
    }

    public static PurchaseInfo create(PurchasedLottoTickets manualTickets, PurchasedLottoTickets automaticTickets) {
        return new PurchaseInfo(manualTickets, automaticTickets);
    }

    private void validate(PurchasedLottoTickets manualTickets, PurchasedLottoTickets automaticTickets) {
        if (manualTickets == null || automaticTickets == null) {
            throw new IllegalArgumentException("수동으로 구매할 로또와 자동으로 구매할 로또를 입력해주세요.");
        }
    }

    public int getCountOfManualTickets() {
        return manualTickets.count();
    }

    public int getCountOfAutomaticTickets() {
        return automaticTickets.count();
    }

    public PurchasedLottoTickets getAllTickets() {
        return manualTickets.merged(automaticTickets);
    }
}
