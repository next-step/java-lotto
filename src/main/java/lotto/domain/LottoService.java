package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.utils.InputValidator.checkDuplicateNumberValidation;

public class LottoService {
    private final List<LottoTicket> lottoTickets;
    private LotteryNumber lotteryNumber;
    private Map<Rank, Integer> lottoRankingStatus;
    private int profit;

    public LottoService() {
        lottoTickets = new ArrayList<>();
    }

    public LottoService(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void buyAutomaticLottoTickets(int numberOfAutomaticTickets) {
        for (int i = 0; i < numberOfAutomaticTickets; ++i) {
            lottoTickets.add(new LottoTicket());
        }
    }

    public void buyManualLottoTickets(int numberOfManualLottoTickets) {
        for (int i = 0; i < numberOfManualLottoTickets; ++i) {
            List<Integer> pickedNumbers = InputView.inputManualLottoTicketPickedNumber();
            checkDuplicateNumberValidation(pickedNumbers);
            lottoTickets.add(new LottoTicket(pickedNumbers));
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    private void initLottoResults() {
        lottoRankingStatus = new HashMap<>();
        for (Rank rank : Rank.values()) {
            lottoRankingStatus.put(rank, 0);
        }
        profit = 0;
    }

    public void recordLotteryNumber(LotteryNumber lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }

    public void calculatePrize() {
        initLottoResults();
        for (LottoTicket lottoTicket : lottoTickets) {
            Rank currentRank = lottoTicket.calculateRank(lotteryNumber);
            lottoRankingStatus.put(currentRank, lottoRankingStatus.get(currentRank) + 1);
            profit += currentRank.getReward();
        }
    }

    public Map<Rank, Integer> getLottoRankingStatus() {
        return lottoRankingStatus;
    }

    public double getInterestRate() {
        int totalLottoPrice = LottoTicket.PRICE * lottoTickets.size();
        double interestRate = (double) profit / totalLottoPrice;
        return interestRate;
    }
}