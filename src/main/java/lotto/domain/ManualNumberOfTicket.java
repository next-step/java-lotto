package lotto.domain;

import java.util.Objects;

import static lotto.utils.ConvertUtil.toInt;

public class ManualNumberOfTicket {
    private static final String CHECK_MANUAL_NUMBER_OF_TICKET = "입력하신 구매 티켓 수 %s가 숫자인지 확인해주세요.";
    private static final String CHECK_BOUND = "입력하신 구매 티켓 수가 구매 가능한 티켓 수보다 많습니다.";
    private static final String CHECK_POSITIVE = "입력하신 구매 티켓 수가 음수입니다.";
    private static final int MIN = 0;
    private final int manualNumberOfTicket;

    public ManualNumberOfTicket(String manualNumberOfTicket, TotalNumberOfTicket totalNumberOfTicket) {
        this(toInt(CHECK_MANUAL_NUMBER_OF_TICKET, manualNumberOfTicket), totalNumberOfTicket);
    }

    public ManualNumberOfTicket(int manualNumberOfTicket, TotalNumberOfTicket totalNumberOfTicket) {
        validateBound(manualNumberOfTicket, totalNumberOfTicket.count());
        validatePositive(manualNumberOfTicket);
        this.manualNumberOfTicket = manualNumberOfTicket;
    }

    private void validatePositive(int manualNumberOfTicket) {
        if (manualNumberOfTicket < MIN) {
            throw new IllegalArgumentException(CHECK_POSITIVE);
        }
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
        return manualNumberOfTicket == that.manualNumberOfTicket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualNumberOfTicket);
    }
}
