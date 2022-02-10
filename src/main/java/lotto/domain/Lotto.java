package lotto.domain;

import static lotto.util.Constant.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.view.ResultView;

public class Lotto {

    private final List<LottoTicket> lottoTickets;

    public Lotto(int userMoney) {
        int ticketNumber = buyLottoTickets(userMoney);
        this.lottoTickets = generateLottoTickets(ticketNumber);
        ResultView.printLottoTicketsInfo(lottoTickets);
    }

    private int buyLottoTickets(int money) {
        return money / PRICE;
    }

    public List<LottoTicket> generateLottoTickets(int number) {
        List<LottoTicket> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottoNumbers.add(new LottoTicket(generateRandoms()));
        }
        return lottoNumbers;
    }

    public List<LottoNumber> generateRandoms() {
        List<Integer> numberCards = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numberCards.add(i);
        }
        Collections.shuffle(numberCards);

        List<Integer> picked = numberCards.subList(0, LOTTO_SIZE);
        Collections.sort(picked);
        return picked.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    public int getNumOfTickets() {
        return lottoTickets.size();
    }

    public LottoStatistic getWinningResult(WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> lottoRankResults = new EnumMap<>(LottoRank.class);

        this.lottoTickets.forEach(ticket -> {
            LottoRank rank = winningNumbers.getRankForLottoTicket(ticket);
            if (rank != null) {
                lottoRankResults.put(rank, lottoRankResults.getOrDefault(rank, 0) + 1);
            }
        });
        return new LottoStatistic(lottoRankResults);
    }
}
