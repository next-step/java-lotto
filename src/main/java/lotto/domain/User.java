package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.stream.Collectors;

import static validator.LottoValidator.validateTicketForm;

public class User {

    private final UserInput userInput;
    private List<NavigableSet<Integer>> lottoTickets = null;

    public User(final UserInput userInput) {
        if (userInput != null) {
            this.userInput = userInput;
            return;
        }
        throw new IllegalArgumentException("유저의 입력 정보가 올바르지 않습니다.");
    }

    public void receiveTickets(final List<NavigableSet<Integer>> lottoTickets) {
        if (validateTicketForm(lottoTickets)) {
            this.lottoTickets = lottoTickets;
            return;
        }
        throw new IllegalArgumentException("로또 티켓을 전달 받지 못하였습니다.");
    }

    public List<NavigableSet<Integer>> lottoTickets() {
        if (lottoTickets == null) {
            lottoTickets = new ArrayList<>();
        }
        return lottoTickets;
    }

    public UserInput userInput() {
        return userInput;
    }

    public List<Integer> matchingCountsByTickets(final NavigableSet<Integer> raffleNumbers) {
        if (validateTicketForm(raffleNumbers)) {
            return lottoTickets.stream()
                    .map(ticket -> compareNumber(ticket, raffleNumbers))
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("당첨 번호를 알 수 없습니다.");
    }

    private int compareNumber(final Set<Integer> ticket, final Set<Integer> raffleNumbers) {
        return ticket.stream()
                .mapToInt(number -> raffleNumbers.contains(number) ? 1 : 0)
                .sum();
    }
}
