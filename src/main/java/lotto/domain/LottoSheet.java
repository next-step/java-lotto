package lotto.domain;

import lotto.data.LottoPurchaseInfo;
import lotto.data.LottoWinInfo;
import lotto.dto.LottoResultDto;

import java.util.*;

import static lotto.util.ConstUtils.*;

public class LottoSheet {

    private final List<Lotto> lottoSheet;
    private final LottoPurchaseInfo lottoPurchaseInfo;

    public LottoSheet(LottoPurchaseInfo lottoPurchaseInfo) {
        this.lottoPurchaseInfo = lottoPurchaseInfo;

        this.lottoSheet = new ArrayList<>();
        this.lottoSheet.addAll(lottoPurchaseInfo.getManualLotto());

        for (int i = lottoPurchaseInfo.countManual(); i < lottoPurchaseInfo.purchasedCount(); i++) {
            this.lottoSheet.add(new Lotto());
        }
    }

    public List<Lotto> getPurchasedLottoList() {
        return List.copyOf(lottoSheet);
    }

    public LottoResultDto matchWin(WinLottoBalls winLottoBalls) {
        Map<LottoWinInfo, Integer> lottoResultMap = initializeLottoResultMap();

        for (Lotto lotto : this.lottoSheet) {
            lottoResultMap.computeIfPresent(
                    winLottoBalls.countMatchWithBonus(lotto),
                    (key, value) -> value + 1
            );
        }

        return LottoResultDto.of(lottoResultMap, earnRate(lottoResultMap));
    }

    public int countManual() {
        return this.lottoPurchaseInfo.countManual();
    }

    public int countAuto() {
        return this.lottoPurchaseInfo.countAuto();
    }

    private Map<LottoWinInfo, Integer> initializeLottoResultMap() {
        HashMap<LottoWinInfo, Integer> lottoResultMap = new HashMap<>();

        Arrays.stream(LottoWinInfo.values())
                .forEach(lottoWinInfo -> lottoResultMap.put(lottoWinInfo, 0));

        return lottoResultMap;
    }

    private double earnRate(Map<LottoWinInfo, Integer> lottoResultMap) {
        double winMoney = lottoResultMap.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getWinningPrice())
                .sum();

        return winMoney / purchasedLottoPrice();
    }

    private int purchasedLottoPrice() {
        return this.lottoSheet.size() * LOTTO_WON_UNIT;
    }
}
