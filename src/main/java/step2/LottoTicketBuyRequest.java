package step2;

public class LottoTicketBuyRequest {
    private int amount;
    private int lottoCount;

    public LottoTicketBuyRequest(int amount, int lottoCount) {
        this.amount = amount;
        this.lottoCount = lottoCount;
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
