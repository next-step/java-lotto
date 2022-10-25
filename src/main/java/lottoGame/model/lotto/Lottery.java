package lottoGame.model.lotto;

import lottoGame.Rank;
import lottoGame.RankResult;
import lottoGame.model.lotto.lottoNumber.DefaultLottoNumber;
import lottoGame.model.lotto.lottoNumber.LottoNumber;
import lottoGame.model.strategy.ShuffleStrategy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottery {

    private final List<Lotto> lottery = new ArrayList<>();


    public List<Lotto> create(double lotteryNum, ShuffleStrategy shuffleStrategy) {
        for (int i = 0; i < lotteryNum; i++) {
            lottery.add(createLotto(shuffleStrategy));
        }
        return lottery;
    }

    public RankResult createRankResult(WinningLotto winningNumber, RankResult rankResult) {
        rankResult.putResult(findRanks(winningNumber));
        return rankResult;
    }

    public List<Lotto> getLottery() {
        return lottery;
    }

    public int countAllLotto() {
        return lottery.size();
    }

    private List<Rank> findRanks(WinningLotto winningNumber) {
        return lottery.stream()
                .map(lotto -> Rank.findRank(lotto.countMatch(winningNumber),lotto.isBonus(winningNumber)))
                .collect(Collectors.toList());
    }

    private Lotto createLotto(ShuffleStrategy shuffleStrategy) {
        return new Lotto(sortLottoNum(shuffleStrategy));
    }

    private List<LottoNumber> sortLottoNum(ShuffleStrategy shuffleStrategy) {
        return shuffleLottoNum(shuffleStrategy)
                .stream()
                .sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .collect(Collectors.toList());
    }

    private List<LottoNumber> shuffleLottoNum(ShuffleStrategy shuffleStrategy) {
        return shuffleStrategy.shuffleLottoNum(createLottoNum());
    }

    private List<LottoNumber> createLottoNum() {
        return DefaultLottoNumber.getLottoNumbers();
    }


}
