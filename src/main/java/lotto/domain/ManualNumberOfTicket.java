package lotto.domain;

import lotto.utils.ConvertUtil;

import java.util.Objects;

public class ManualNumberOfTicket {
    private static final String CHECK_MANUAL_NUMBER_OF_TICKET = "입력하신 구매 티켓 수 %s가 숫자인지 확인해주세요.";
    private static final String CHECK_BOUND = "입력하신 구매 티켓 수가 구매 가능한 티켓 수보다 많습니다.";
    private final TotalNumberOfTicket totalNumberOfTicket;
    private final int manualNumberOfTicket;

    public ManualNumberOfTicket(String manualNumberOfTicket, TotalNumberOfTicket totalNumberOfTicket) {
        this(ConvertUtil.toIntOrThrow(manualNumberOfTicket, () -> new IllegalArgumentException(String.format(CHECK_MANUAL_NUMBER_OF_TICKET, manualNumberOfTicket))), totalNumberOfTicket);
    }

    public ManualNumberOfTicket(int manualNumberOfTicket, TotalNumberOfTicket totalNumberOfTicket) {
        validateBound(manualNumberOfTicket, totalNumberOfTicket.count());
        this.manualNumberOfTicket = manualNumberOfTicket;
        this.totalNumberOfTicket = totalNumberOfTicket;
    }

    private void validateBound(int manualNumberOfTicket, int totalNumberOfTicket) {
        if (manualNumberOfTicket > totalNumberOfTicket) {
            throw new IllegalArgumentException(CHECK_BOUND);
        }
    }

    public int numberOfTicket() {
        return manualNumberOfTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManualNumberOfTicket that = (ManualNumberOfTicket) o;
        return manualNumberOfTicket == that.manualNumberOfTicket &&
                Objects.equals(totalNumberOfTicket, that.totalNumberOfTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalNumberOfTicket, manualNumberOfTicket);
    }
}
