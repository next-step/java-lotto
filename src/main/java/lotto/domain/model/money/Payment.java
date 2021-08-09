package lotto.domain.model.money;

import lotto.exception.InvalidManualTicketCountException;

public class Payment {

    private final LottoMoney lottoMoney;
    private final int countOfManual;

    private Payment(LottoMoney lottoMoney, int countOfManual) {
        if (lottoMoney.numberOfTickets() < countOfManual) {
            throw new InvalidManualTicketCountException();
        }
        if (countOfManual < 0) {
            throw new RuntimeException("수동 구매 로또 수는 음수일 수 없습니다.");
        }
        this.lottoMoney = lottoMoney;
        this.countOfManual = countOfManual;
    }

    public static Payment of(LottoMoney lottoMoney, int countOfManual) {
        return new Payment(lottoMoney, countOfManual);
    }

    public int countOfAutomatic() {
        return lottoMoney.numberOfTickets() - countOfManual;
    }
}
