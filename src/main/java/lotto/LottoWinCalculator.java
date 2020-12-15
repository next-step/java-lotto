package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoWinPrize;

import java.util.*;
import java.util.stream.Collectors;

public class LottoWinCalculator {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> pickedLottoNumbers = new ArrayList<>();
    private LottoNumbers winLottoNumbers;

    /**
     * 발급 된 로또번호를 추가합니다
     * @param lotto
     */
    public void addPickedLottoNumbers(Lotto lotto) {
        this.pickedLottoNumbers.add(lotto);
    }

    /**
     * 당첨번호를 세팅합니다.
     * @param winLottoNumbers
     */
    public void setWinLottoNumbers(LottoNumbers winLottoNumbers) {
        this.winLottoNumbers = winLottoNumbers;
    }

    /**
     * 당첨상금 별 갯수를 리턴합니다.
     * @return
     */
    public List<LottoWinPrize> findLottoWinPrize() {
        List<Integer> matchedCounts = this.calculateMatchedCounts();
        for (int matchedCount : matchedCounts) {
            LottoWinPrize.addCount(matchedCount);
        }
        return Arrays.stream(LottoWinPrize.values()).collect(Collectors.toList());
    }

    /**
     * 세팅 된 당첨번호와 발급 된 로또번호를 비교하여 각 일치하는 개수를 반환합니다.
     * @return
     */
    List<Integer> calculateMatchedCounts() {
        return this.pickedLottoNumbers.stream()
                .map(lotto -> lotto.getLottoNumbers().matchedLottoNumbersCount(this.winLottoNumbers))
                .collect(Collectors.toList());
    }

    /**
     * 수익률을 계산합니다.
     * 총 상금 / (로또 발급 수 * 로또 가격)
     * @param lottoWinPrizes
     * @return
     */
    public double calculatePriceEarningRatio(List<LottoWinPrize> lottoWinPrizes, int lottoAmount) {
        return calculateTotalPrize(lottoWinPrizes) / lottoAmount / LottoWinCalculator.LOTTO_PRICE;
    }

    /**
     * 총 상금을 계산합니다.
     * @param lottoWinPrizes
     * @return
     */
    private int calculateTotalPrize(List<LottoWinPrize> lottoWinPrizes) {
        return lottoWinPrizes.stream()
                .mapToInt(lottoWinPrize -> (int) (lottoWinPrize.getPrize() * lottoWinPrize.getCount()))
                .sum();
    }

}
