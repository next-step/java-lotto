package lotto.domain;

public final class LottoSeller {

    private LottoSeller() {}

    public static int getNumberOfAutoLottoTicket(final int numberOfLottoByMoneyPaid, final int numberOfManual) {
        if (numberOfManual > numberOfLottoByMoneyPaid) {
            throw new IllegalArgumentException();
        }
        return numberOfLottoByMoneyPaid - numberOfManual;
    }

}
