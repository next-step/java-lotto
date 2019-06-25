package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoSeller {
    static final int PRICE_OF_A_LOTTO_TICKET = 1000;
    static final String ALERT_MISSING_MONEY = "돈을 넣어주세요. 로또복권은 한 장당 1000원 입니다.";

    public static int countLottoTickets(int inputMoney) {
        validationInputMoney(inputMoney);
        return inputMoney / PRICE_OF_A_LOTTO_TICKET;
    }

    public static List<LottoTicket> issueLottoTicket(int numberOfTicketsToBuy) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfTicketsToBuy; i++) {
            lottoTickets.add(LottoTicketGenerator.issue());
        }
        return lottoTickets;
    }

    public static LottoTicket getLuckyNumber(List<Integer> inputLuckyNumber) {
        List<LottoNumber> lottoTicket = inputLuckyNumber.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return LottoTicketGenerator.issue(lottoTicket);
    }

    public static Map<LottoRank, List<LottoTicket>> getLottoResult(List<LottoTicket> lottoTickets, LottoTicket luckyNumber) {
        Map<LottoRank, List<LottoTicket>> lottoResultMap = new HashMap<>();

        for (LottoTicket ticket : lottoTickets) {
            LottoRank lottoRank = LottoRank.from(ticket.getNumberOfMatchedToLuckyNumber(luckyNumber));
            List<LottoTicket> ticketsCorrespondingToRank = lottoResultMap.getOrDefault(lottoRank, new ArrayList<>());
            ticketsCorrespondingToRank.add(ticket);
            lottoResultMap.put(lottoRank, ticketsCorrespondingToRank);
        }
        return lottoResultMap;
    }

    private static void validationInputMoney(int inputMoney) {
        if (inputMoney < PRICE_OF_A_LOTTO_TICKET) {
            throw new IllegalArgumentException(ALERT_MISSING_MONEY);
        }
    }
}
