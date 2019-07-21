package lotto.domain;

public class LottoWallet {
    private LottoTickets generated;
    private LottoTickets picked;

    public LottoWallet(LottoTickets generated, LottoTickets picked) {
        this.generated = generated;
        this.picked = picked;
    }

    public LottoTickets getGenerated() {
        return generated;
    }

    public LottoTickets getPicked() {
        return picked;
    }

    public LottoResult checkWin(LottoWinner winner) {
        LottoResult generatedResult = generated.checkWin(winner);
        LottoResult pickedResult = picked.checkWin(winner);

        return generatedResult.sum(pickedResult);
    }
}
