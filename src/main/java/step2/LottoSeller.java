package step2;

import java.util.List;

public class LottoSeller {
    static final int PRICE_OF_A_LOTTO_TICKET = 1000;
    static final String ALERT_MISSING_MONEY = "돈을 넣어주세요. 로또복권은 한 장당 1000원 입니다.";

    public int countLottoTickets(int inputMoney) {
        validationInputMoney(inputMoney);
        return inputMoney / PRICE_OF_A_LOTTO_TICKET;
    }

    public List<LottoTicket> issueLottoTicket(int numberOfTicketsToBuy) {
        //LottoTickets 생성
        //LottoTickets에 발행된 티켓 추가
            //LottoTicketGenerator.issue();
        //LottoTickets 반환

    }

    private void validationInputMoney(int inputMoney) {
        if (inputMoney < PRICE_OF_A_LOTTO_TICKET) {
            throw new IllegalArgumentException(ALERT_MISSING_MONEY);
        }
    }
}
