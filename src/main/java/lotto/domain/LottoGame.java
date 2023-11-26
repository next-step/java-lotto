package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    private List<LottoTicket> tickets = new ArrayList<>();
    private WinnerNumbers winnerNumbers;

    public LottoGame(int numOfTickets, List<String []> manualLottoTickets) {
        Random random = new Random();
        LottoFactory lottoFactory = new LottoFactory(numOfTickets, random);
        addManualTickets(manualLottoTickets);

        this.tickets.addAll(lottoFactory.tickets());
        this.winnerNumbers = new WinnerNumbers(lottoFactory.generateTicket(random));
    }

    private void addManualTickets(List<String[]> manualLottoTickets) {
        for (int i = 0; i < manualLottoTickets.size(); i++) {
            List<Integer> inputInList = Arrays.stream(manualLottoTickets.get(i))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            validateTicketNumbers(inputInList);
            LottoTicket manualTicket = new LottoTicket(inputInList);
            this.tickets.add(manualTicket);
        }
    }

    private static void validateTicketNumbers(List<Integer> inputInList) {
        if (inputInList.size() != 6) {
            throw new IllegalArgumentException("로또 갯수가 6개가 아닙니다. ");
        }
        Set<Integer> set = new HashSet<>(inputInList);
        if (set.size() != inputInList.size()) {
            throw new IllegalArgumentException("로또 입력시 중복 숫자 불가합니다. ");
        }
    }

    public LottoGame(LottoTicket lottoTicket, List<Integer> winnerNumbers) {
        LottoFactory lottoFactory = new LottoFactory(lottoTicket);
        this.tickets = lottoFactory.tickets();
        this.winnerNumbers = new WinnerNumbers(winnerNumbers);
    }

    public List<LottoTicket> tickets() {
        return this.tickets;
    }

    public WinnerNumbers winnerNumbers() {
        return this.winnerNumbers;
    }

    public PrizeStatus processResult() {
        PrizeStatus prizeStatus = new PrizeStatus(this);
        return prizeStatus;
    }
}
