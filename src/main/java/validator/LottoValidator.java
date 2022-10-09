package validator;

import java.util.List;
import java.util.NavigableSet;

public class LottoValidator {

    private final static int COUNT_OF_LOTTO_NUMBER = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;

    public static boolean validateTicketForm(NavigableSet<Integer> lottoTicket) {
        if (lottoTicket == null) {
            throw new IllegalArgumentException("로또 티켓을 전달 받지 못하였습니다.");
        }
        return lottoTicket.headSet(MAX_LOTTO_NUMBER, true).size() == COUNT_OF_LOTTO_NUMBER
                && lottoTicket.tailSet(MIN_LOTTO_NUMBER, true).size() == COUNT_OF_LOTTO_NUMBER
                && lottoTicket.subSet(MIN_LOTTO_NUMBER, true, MAX_LOTTO_NUMBER, true).size() == COUNT_OF_LOTTO_NUMBER;
    }

    public static boolean validateTicketForm(List<NavigableSet<Integer>> lottoTickets) {
        if (lottoTickets == null || lottoTickets.size() < 1) {
            throw new IllegalArgumentException("로또 티켓을 전달 받지 못하였습니다.");
        }
        return lottoTickets.stream()
                .allMatch(LottoValidator::validateTicketForm);
    }
}
