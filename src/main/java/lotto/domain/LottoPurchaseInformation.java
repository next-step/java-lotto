package lotto.domain;

import lotto.exception.LottoException;

public class LottoPurchaseInformation {
    private final static int LOTTO_TICKET_PRICE = 1000;

    private final int numberOfManuallyPickedLottoTicket;
    private final int numberOfAutomaticallyPickedLottoTicket;
    private final int lottoTicketsPrice;

    private LottoPurchaseInformation(int numberOfManuallyPickedLottoTicket, int numberOfAutomaticallyPickedLottoTicket, int lottoTicketsPrice) {
        this.numberOfManuallyPickedLottoTicket = numberOfManuallyPickedLottoTicket;
        this.numberOfAutomaticallyPickedLottoTicket = numberOfAutomaticallyPickedLottoTicket;
        this.lottoTicketsPrice = lottoTicketsPrice;
    }

    public static LottoPurchaseInformation of(int money, int numberOfManuallyPickedLottoTicket) {
        int numberOfLottoTicket = money / LOTTO_TICKET_PRICE;
        if (numberOfLottoTicket < numberOfManuallyPickedLottoTicket) {
            throw new LottoException("로또 수동 입력 개수가 구입 금액을 초과했습니다");
        }
        int numberOfAutomaticallyPickedLottoTicket = numberOfLottoTicket - numberOfManuallyPickedLottoTicket;
        int lottoTicketsPrice = numberOfLottoTicket * LOTTO_TICKET_PRICE;
        return new LottoPurchaseInformation(numberOfManuallyPickedLottoTicket, numberOfAutomaticallyPickedLottoTicket, lottoTicketsPrice);
    }

    public int numberOfManuallyPickedLottoTicket() {
        return numberOfManuallyPickedLottoTicket;
    }

    public int numberOfAutomaticallyPickedLottoTicket() {
        return numberOfAutomaticallyPickedLottoTicket;
    }

    public int lottoTicketsPrice() {
        return lottoTicketsPrice;
    }
}
