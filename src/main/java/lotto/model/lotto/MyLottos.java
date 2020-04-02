package lotto.model.lotto;

import lotto.model.Rank;
import lotto.model.gameresult.EarningRate;
import lotto.model.gameresult.GameResult;
import lotto.model.gameresult.MatchingResult;
import lotto.model.lotto.Lotto;
import lotto.model.winninglotto.WinningLotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyLottos {
    private static final long PRICE_TO_BUY_ONE_LOTTO = 1000l;

    private List<Lotto> lottoNumbers;

    public MyLottos(List<Lotto> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public GameResult findGameResult(WinningLotto winningLotto) {
        MatchingResult matchingResult = findMatchingResult(winningLotto);
        EarningRate earningRate = calculateEarningRate(winningLotto);
        return new GameResult(matchingResult, earningRate);
    }

    private EarningRate calculateEarningRate(WinningLotto winningLotto) {
        if (findInputMoney() == 0) {
            return new EarningRate(Double.POSITIVE_INFINITY);
        }

        Long money = findMatchingRanks(winningLotto).stream()
                .mapToLong(Rank::getCashPrize)
                .sum();
        return new EarningRate(money / findInputMoney() * 100);
    }

    private MatchingResult findMatchingResult(WinningLotto winningLotto) {
        List<Rank> matchingRanks = findMatchingRanks(winningLotto);
        matchingRanks.stream()
                .forEach(it -> MatchingResult.increaseCount(it));
        return MatchingResult.getInstance();
    }

    private List<Rank> findMatchingRanks(WinningLotto winningLotto) {
        return lottoNumbers.stream()
                .map(it -> it.resolveRank(winningLotto))
                .collect(Collectors.toList());
    }

    private double findInputMoney() {
        return lottoNumbers.size() * PRICE_TO_BUY_ONE_LOTTO;
    }

    public int findLottoCount() {
        return lottoNumbers.size();
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }
}