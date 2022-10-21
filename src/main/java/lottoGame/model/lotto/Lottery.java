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
                .map(findRank(winningNumber))
                .flatMap(Stream::distinct)
                .collect(Collectors.toList());
    }

    private static Function<Lotto, Stream<Rank>> findRank(WinningLotto winningNumber) {
        return lotto -> Arrays.stream(Rank.values()).map(rank -> rank.findRank(lotto.countMatch(winningNumber), lotto.isBonus(winningNumber)));
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
        return IntStream.range(DefaultLottoNumber.MIN, DefaultLottoNumber.MAX)
                .mapToObj(DefaultLottoNumber::new)
                .collect(Collectors.toList());
    }


}
