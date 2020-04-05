package step2.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningInformations {
    private LottoGameInfo lottoGameInfo;
    private LottoWinningNumber lottoWinningNumber;
    private List<Integer> matchingInformations;
    private Map<LottoWinningInfomation, Integer> matchingInformation;
    private int matchCount;
    private int totalPrize;
    private double earningRate;

    public LottoWinningInformations(LottoGameInfo lottoGameInfo, LottoWinningNumber lottoWinningNumber) {
        this.lottoGameInfo = lottoGameInfo;
        this.lottoWinningNumber = lottoWinningNumber;
        this.matchingInformations = winningInfoMation();
        this.totalPrize = calculateTotalPrize();
        this.earningRate = calculateEarningRate();
        this.matchingInformation = initMatchingInformation();
    }

    public List<Integer> winningInfoMation() {
        return lottoInfo(lottoGameInfo.getLottoTickets());
    }

    public List<Integer> lottoInfo(List<Lotto> lottoTickets) {
        List<Integer> matchings = new ArrayList<>();

        for (Lotto lotto : lottoTickets) {
            this.matchCount = 0;
            winningNumberInfo(lotto);
            matchings.add(this.matchCount);
        }

        return matchings;
    }

    public void winningNumberInfo(Lotto lotto) {
        for (Integer number : lottoWinningNumber.getWinningNumber()) {
            checkMatch(lotto, number);
        }
    }

    public void checkMatch(Lotto lotto, int number) {
        if (lotto.getNumbers().contains(number)) {
            this.matchCount++;
        }
    }

    public int calculateTotalPrize() {
        totalPrize = 0;
        for (int matchCount : matchingInformations) {
            totalPrize += matcingPrice(matchCount);
        }
        return totalPrize;
    }

    public double calculateEarningRate() {
        if (totalPrize == 0) {
            return 0;
        }
        return (double) (totalPrize / (lottoGameInfo.getCountOfTicket() * LottoConstant.LOTTO_PRICE));
    }

    public int matcingPrice(int matchCount) {
        if (LottoWinningInfomation.matchCountInformation(matchCount) == null) {
            return 0;
        }
        return LottoWinningInfomation.matchCountInformation(matchCount).getPrice();
    }

    public Map<LottoWinningInfomation, Integer> initMatchingInformation() {
        Map<LottoWinningInfomation, Integer> initMatchingInformation = new HashMap<>();
        for (LottoWinningInfomation winningInformation : LottoWinningInfomation.values()) {
            initMatchingInformation.put(winningInformation, 0);
        }
        return addMatchCount(initMatchingInformation);
    }

    public Map<LottoWinningInfomation, Integer> addMatchCount(Map<LottoWinningInfomation, Integer> initMatchingInformation) {
        for (Integer matchCount : matchingInformations) {
            putInitMatchingInformation(initMatchingInformation, matchCount);
        }
        return initMatchingInformation;
    }

    public void putInitMatchingInformation(Map<LottoWinningInfomation, Integer> initMatchingInformation, int matchCount) {
        if (LottoWinningInfomation.matchCountInformation(matchCount) != null) {
            initMatchingInformation.put(LottoWinningInfomation.matchCountInformation(matchCount), initMatchingInformation.get(LottoWinningInfomation.matchCountInformation(matchCount)) + 1);
        }
    }

    public List<Integer> getMatchingInformations() {
        return matchingInformations;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public Map<LottoWinningInfomation, Integer> getMatchingInformation() {
        return matchingInformation;
    }
}
