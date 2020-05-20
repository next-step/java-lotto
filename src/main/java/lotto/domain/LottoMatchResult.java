package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatchResult {

    private static final int LOTTO_SALE_AMOUNT = 1000;
    private static final double BASE_RATE = 1.0;

    private final Map<LottoMatch, Integer> matchResult;
    private final LottoNumbers winLotto;
    private final List<LottoNumbers> lottoNumbers;

    private LottoMatchResult(LottoNumbers winLotto, List<LottoNumbers> lottoNumbers) {
        validateLottoMatchResult(winLotto, lottoNumbers);

        this.winLotto = winLotto;
        this.lottoNumbers = lottoNumbers;
        this.matchResult = new HashMap<>();
    }

    public static LottoMatchResult newInstance(LottoNumbers winLotto, List<LottoNumbers> lottoNumbers) {
        return new LottoMatchResult(winLotto, lottoNumbers);
    }

    private void validateLottoMatchResult(LottoNumbers winLotto, List<LottoNumbers> lottoNumbers) {
        if (winLotto == null || lottoNumbers == null) {
            throw new IllegalArgumentException("당첨 로또 번호와 구매 로또 번호가 필요합니다.");
        }

        if (lottoNumbers.size() == 0) {
            throw new IllegalArgumentException("구매 로또 번호 장수가 존재하지 않습니다.");
        }
    }

    public void run() {
        this.lottoNumbers.stream()
                .map(lottoNumbers -> lottoNumbers.getMatchCount(this.winLotto))
                .filter(matchCount -> matchCount >= 3)
                .forEach(this::increaseMatchCount);
    }

    public int getMatchCount(LottoMatch lottoMatch) {
        return this.matchResult.getOrDefault(lottoMatch, 0);
    }

    public long getWinAmount(LottoMatch lottoMatch) {
        return lottoMatch.getWinAmount(getMatchCount(lottoMatch));
    }

    public double getProfitRate() {
        return getTotalWinAmount() * 1.0 / getPurchaseAmount();
    }

    public String getProfitOrLoss(double profitRate) {
        return profitRate >= BASE_RATE ? "이익" : "손해";
    }

    private long getTotalWinAmount() {
        return this.matchResult.keySet().stream()
                .mapToLong(this::getWinAmount)
                .sum();
    }

    private void increaseMatchCount(int matchCount) {
        LottoMatch lottoMatch = LottoMatch.findByCount(matchCount);
        this.matchResult.put(lottoMatch, getMatchCount(lottoMatch) + 1);
    }

    private int getPurchaseAmount() {
        return this.lottoNumbers.size() * LOTTO_SALE_AMOUNT;
    }
}
