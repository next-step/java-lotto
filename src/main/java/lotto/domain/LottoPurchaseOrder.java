package lotto.domain;

public class LottoPurchaseOrder {

    private final Money GameMoney;
    private final int[][] manualLottoNumbers;

    public LottoPurchaseOrder(Money gameMoney, int[][] manualLottoNumbers) {
        GameMoney = gameMoney;
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public Money getGameMoney() {
        return GameMoney;
    }

    public int[][] getManualLottoNumbers() {
        return manualLottoNumbers;
    }

    public TicketCount getManualLottoTicketCount() {
        return new TicketCount(manualLottoNumbers.length);
    }
}
