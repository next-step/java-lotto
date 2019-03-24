package lotto.rule;

public class LottoSetUp {
    public static int lottoNumberCount;
    public static int lottoNumberBounds;
    public static int lottoTicketPrice;

    public static void setUpLottoRule(int numberCount, int numberBound, int ticketPrice) {
        if (numberBound < 6)
            throw new IndexOutOfBoundsException();

        lottoNumberCount = numberCount;
        lottoNumberBounds = numberBound;
        lottoTicketPrice = ticketPrice;
    }
}
