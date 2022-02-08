package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStatistics {

    private static final int MATCH_FIVE = 5;
    private static final int MIN_WIN_COUNT = 3;
    private final WinningNumbers winningNumbers;
    private final List<List<LottoNumber>> lottoList;
    private final List<Rank> resultStatistics;
    private final int lottoPrice;

    public LottoStatistics(WinningNumbers winningNumbers, List<List<LottoNumber>> lottoList, int lottoPrice) {
        this.winningNumbers = winningNumbers;
        this.lottoList = lottoList;
        this.lottoPrice = lottoPrice;
        this.resultStatistics = new ArrayList<>();
        compareNumber();
    }

    private void compareNumber() {
        for (int i = 0; i < lottoList.size(); i++) {
            int count = matchWinningNumbers(lottoList.get(i));
            getRank(count, lottoList.get(i));
        }
    }

    private void getRank(final int count, final List<LottoNumber> lottoNumberList) {
        if (count < MIN_WIN_COUNT) {
            return;
        }

        if (matchBonusNumber(count, lottoNumberList)) {
            resultStatistics.add(Rank.SECOND);
        } else {
            resultStatistics.add(Rank.getRank(count));
        }
    }

    public String getLottoEarningRate() {
        double totalPrice = 0;
        for (Rank statistics : resultStatistics) {
            totalPrice += statistics.getMoney();
        }
        return String.format("%.2f",totalPrice / lottoPrice);
    }

    private boolean matchBonusNumber(final int count, final List<LottoNumber> lottoNumberList) {
        return count == MATCH_FIVE && lottoNumberList.contains(winningNumbers.getBonusNumber());
    }

    private boolean isWinningNumber(final LottoNumber lottoNumber) {
        return winningNumbers.getWinningNumber().contains(lottoNumber);
    }

    private int matchWinningNumbers(final List<LottoNumber> lottoNumberList) {
        return lottoNumberList.stream().filter(x -> isWinningNumber(x))
            .collect(Collectors.toList()).size();
    }

    public List<Rank> getResultStatistics() {
        return Collections.unmodifiableList(resultStatistics);
    }
}
