package lotto.domain;

import lotto.exception.NotEnoughMoneyException;

public class LottoPurchaseOrder {

    private final int money;
    private final int autoTicketCount;
    private final int[][] manualLottoNumbers;

    public LottoPurchaseOrder(int money, int[][] manualLottoNumbers) {
        checkMoneyAmount(money);
        this.money = money;
        this.autoTicketCount = getAutoTicketCount(money, getManualLottoTicketCount());
        this.manualLottoNumbers = manualLottoNumbers;
    }

    private int getAutoTicketCount(int money, int manualTicketCount) {
        int availableTicketCount = getAllAvailableTicketCount(money);
        return availableTicketCount - manualTicketCount;
    }


    public int getAllAvailableTicketCount(int money) {

        checkMoneyAmount(money);

        int availableTicketCount = money / LottoTicket.PRICE;

        return availableTicketCount;

    }


    private void checkMoneyAmount(int money) {
        if (LottoTicket.PRICE > money) {
            throw new NotEnoughMoneyException(
                String.format("로또를 구입할만한 금액이 입력되지 않았습니다. 입력금액: %s", money));
        }
    }

    public int getMoney() {
        return money;
    }

    public int[][] getManualLottoNumbers() {
        return manualLottoNumbers;
    }

    public int getManualLottoTicketCount() {
        return manualLottoNumbers.length;
    }

    public int getAutoTicketCount() {
        return autoTicketCount;
    }
}
