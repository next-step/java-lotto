package lotto.domain;

public class PurchaseBudget {

    private static final int LOTTO_TICKET_PRICE = 1000;

    private int countOfAutoLottoTicket;
    private int countOfManualLottoTicket;

    public PurchaseBudget(int countOfAutoLottoTicket, int countOfManualLottoTicket) {
        this.countOfAutoLottoTicket = countOfAutoLottoTicket;
        this.countOfManualLottoTicket = countOfManualLottoTicket;
    }

    public static PurchaseBudget create(Money money, int countOfManualLottoTicket) {
        int userMoney = money.value();
        validationForMoney(userMoney);

        int couldBuyTicketAmount = calculateCouldBuyTicketAmount(userMoney);
        validationTicketCount(countOfManualLottoTicket, couldBuyTicketAmount);

        int countOfAutoLottoTicket = couldBuyTicketAmount - countOfManualLottoTicket;

        return new PurchaseBudget(countOfAutoLottoTicket, countOfManualLottoTicket);
    }

    private static void validationTicketCount(int countOfManualLottoTicket, int couldBuyTicketAmount) {
        if (couldBuyTicketAmount < countOfManualLottoTicket) {
            throw new IllegalArgumentException("수동구입 갯수가 전체 구입가능갯수를 초과할수 없습니다.");
        }
    }

    private static void validationForMoney(int userMoney) {
        if (userMoney < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("최소 구입금액은 1000원입니다.");
        }
    }

    private static int calculateCouldBuyTicketAmount(int money) {
        return money / LOTTO_TICKET_PRICE;
    }


    public int getManualTicketCount() {
        return countOfManualLottoTicket;
    }

    public int getAutoTicketCount() {
        return countOfAutoLottoTicket;
    }
}
