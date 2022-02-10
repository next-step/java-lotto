package lotto.domain;

import static lotto.util.Constant.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Map;
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

    public List<Integer> generateRandoms() {
        List<Integer> numberCards = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numberCards.add(i);
        }
        Collections.shuffle(numberCards);

        List<Integer> picked = numberCards.subList(0, LOTTO_SIZE);
        Collections.sort(picked);
        return picked;
    }

    public int getNumOfTickets() {
        return lottoTickets.size();
    }


    public double getProfit(int price, Map<LottoRank, Integer> map) {
        double total = 0;
        for (Map.Entry<LottoRank, Integer> entry : map.entrySet()) {
            int amount = entry.getKey().getWinningAmount();
            double profit = amount * entry.getValue();
            total += profit;
        }
        return Math.floor((total / price) * 100) / 100.0;
    }

    public LottoRank compareWithWinning(LottoTicket lottoNumbers, WinningNumbers winningNumbers) {
        int count = winningNumbers.compareLottoNumbers(lottoNumbers);
        boolean hasBonus = winningNumbers.checkBonusBall(lottoNumbers);
        return LottoRank.valueOf(count, hasBonus);
    }

    public Map<LottoRank, Integer> getWinningResult(WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> map = new EnumMap<>(LottoRank.class);
        this.lottoTickets.forEach(ticket -> {
            LottoRank rank = compareWithWinning(ticket, winningNumbers);
            if (rank != null) {
                map.put(rank, map.getOrDefault(rank, 0) + 1);
            }
        });
        return Collections.synchronizedMap(new EnumMap<>(map));
    }
}
