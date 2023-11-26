package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
            if (inputInList.size() != 6) {
                throw new IllegalArgumentException("로또 갯가 6개가 아닙니다. ");
            }
            LottoTicket manualTicket = new LottoTicket(inputInList);
            this.tickets.add(manualTicket);
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
