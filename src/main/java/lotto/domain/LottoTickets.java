package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private static final Integer LOTTO_DEFAULT_START_NUMBER = 1;
    private static final Integer LOTTO_DEFAULT_END_NUMBER = 45;

    private final PurchaseInfo purchaseInfo;
    private List<Lotto> lottoList = new ArrayList<>();

    public LottoTickets(PurchaseInfo purchaseInfo, List<Lotto> lottoList) {
        this(purchaseInfo);
        this.lottoList = lottoList;
    }

    public LottoTickets(PurchaseInfo purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public LottoTickets pickNumbers(List<List<Integer>> manualLottoList) {
        makeAutoLotto();
        makeManualLotto(manualLottoList);
        return this;
    }

    public List<Rank> getRanks(LottoResult winnerLottoResult) {
        List<Rank> rankList = new ArrayList<>();
        this.lottoList.forEach(l -> rankList.add(l.getRank(winnerLottoResult)));
        return rankList;
    }

    public BigDecimal getYield(List<Rank> rankList) {
        int totalWinningMoney = rankList.stream()
                .mapToInt(Rank::getWinningMoney)
                .sum();
        return BigDecimal.valueOf(totalWinningMoney)
                .divide(BigDecimal.valueOf(this.purchaseInfo.getPurchasePrice()), 2, RoundingMode.HALF_UP);
    }

    private void makeManualLotto(List<List<Integer>> manualLottoList) {
        for (int i = 0; i < this.purchaseInfo.getManualAmount(); i++) {
            lottoList.add(new Lotto(manualLottoList.get(i)));
        }
    }

    private void makeAutoLotto() {
        List<Integer> defaultNumberList = defaultNumberList();

        for (int i = 0; i < this.purchaseInfo.getAutoAmount(); i++) {
            lottoList.add(new Lotto().pickAuto(defaultNumberList));
        }
    }

    private List<Integer> defaultNumberList() {
        List<Integer> defaultNumberList = new ArrayList<>();
        for (int i = LOTTO_DEFAULT_START_NUMBER; i <= LOTTO_DEFAULT_END_NUMBER; i++) {
            defaultNumberList.add(i);
        }
        return defaultNumberList;
    }

}
