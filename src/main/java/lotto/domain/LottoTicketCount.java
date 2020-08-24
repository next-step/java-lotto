package lotto.domain;

public class LottoTicketCount {

    private static final int LOTTO_PRICE = 1000;
    public static final int MIN_COUNT = 0;
    private int autoLottoTicketCount;
    private int manualLottoTicketCount;

    private LottoTicketCount(int money, int manualLottoCount) {
        validateCount(manualLottoCount);
        this.autoLottoTicketCount = calculateAutoLottoTicketCount(money) - manualLottoCount;
        this.manualLottoTicketCount = manualLottoCount;
    }

    public static LottoTicketCount valueOf(int money, int manualLottoCount) {
        return new LottoTicketCount(money, manualLottoCount);
    }

    private int calculateAutoLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getAutoLottoTicketCount() {
        return autoLottoTicketCount;
    }

    public int getManualLottoTicketCount() {
        return manualLottoTicketCount;
    }

    private void validateCount(int manualLottoCount) {
        if (manualLottoCount < MIN_COUNT) {
            throw new IllegalArgumentException("0 이상의 숫자를 입력해주세요.");
        }
    }
}
