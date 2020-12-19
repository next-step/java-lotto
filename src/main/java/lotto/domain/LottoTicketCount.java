package lotto.domain;

import java.util.Objects;

public class LottoTicketCount {
    private static final String INVALID_INPUT_ERROR = "0 이상의 숫자를 입력해주세요.";
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_COUNT = 0;
    private final int autoLottoTicketCount;
    private final int manualLottoTicketCount;

    private LottoTicketCount(LottoMoney lottoMoney, int manualLottoCount) {
        validateCount(manualLottoCount);
        this.autoLottoTicketCount = calculateAutoLottoTicketCount(lottoMoney.getMoney()) - manualLottoCount;
        this.manualLottoTicketCount = manualLottoCount;
    }

    private int calculateAutoLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

    private void validateCount(int manualLottoCount) {
        if (manualLottoCount < MIN_COUNT) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public int getAutoLottoTicketCount() {
        return autoLottoTicketCount;
    }

    public int getManualLottoTicketCount() {
        return manualLottoTicketCount;
    }

    public static class Builder {
        LottoMoney lottoMoney;
        int manualLottoCount;

        public Builder lottoMoney(LottoMoney lottoMoney) {
            this.lottoMoney = lottoMoney;
            return this;
        }

        public Builder manualLottoCount(int manualLottoCount) {
            this.manualLottoCount = manualLottoCount;
            return this;
        }

        public LottoTicketCount build() {
            return new LottoTicketCount(lottoMoney, manualLottoCount);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicketCount that = (LottoTicketCount) o;
        return autoLottoTicketCount == that.autoLottoTicketCount && manualLottoTicketCount == that.manualLottoTicketCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoLottoTicketCount, manualLottoTicketCount);
    }
}
