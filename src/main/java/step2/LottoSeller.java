package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoSeller {
    static final int PRICE_OF_A_LOTTO_TICKET = 1000;
    static final String ALERT_MISSING_MONEY = "돈을 넣어주세요. 로또복권은 한 장당 1000원 입니다.";

    public int countLottoTickets(int inputMoney) {
        validationInputMoney(inputMoney);
        return inputMoney / PRICE_OF_A_LOTTO_TICKET;
    }

    public List<LottoTicket> issueLottoTicket(int numberOfTicketsToBuy) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for(int i = 0; i < numberOfTicketsToBuy; i++) {
            lottoTickets.add(LottoTicketGenerator.issue());
        }
        return lottoTickets;

        //TODO: Q. 구입한 로또복권의 목록인 List<LottoTicket> 도 일급컬렉션으로 만들 필요가 있을지 헷갈립니다..
    }

    public void lottoResult(List<LottoTicket> lottoTickets, LuckyNumber luckyNumber) {

    }

    public long getNumberOfMatchedToLuckyNumber(LottoTicket lottoTicket, LuckyNumber luckyNumber) {
        List<Integer> luckNumberLastWeek =
                luckyNumber.getLuckyNumber()
                        .stream()
                        .map(LottoNumber::getNumber)
                        .collect(Collectors.toList());
        return lottoTicket.getLottoTicket().stream()
                .map(LottoNumber::getNumber)
                .filter(i -> luckNumberLastWeek.contains(i))
                .count();

        //TODO: Q. 이 부분을 어떻게 구현하면 좋을지 궁금합니다..
    }


    private void validationInputMoney(int inputMoney) {
        if (inputMoney < PRICE_OF_A_LOTTO_TICKET) {
            throw new IllegalArgumentException(ALERT_MISSING_MONEY);
        }
    }
}
