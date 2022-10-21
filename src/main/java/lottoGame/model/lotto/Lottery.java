package lottoGame.model.lotto;

import lottoGame.Rank;
import lottoGame.RankResult;
import lottoGame.model.lotto.lottoNumber.DefaultLottoNumber;
import lottoGame.model.lotto.lottoNumber.LottoNumber;
import lottoGame.model.strategy.ShuffleStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {

    private final RankResult rankResult = new RankResult();
    private final List<Lotto> lottery = new ArrayList<>();


    public List<Lotto> create(int lotteryNum, ShuffleStrategy shuffleStrategy) {
        for (int i = 0; i < lotteryNum; i++) {
            lottery.add(createLotto(shuffleStrategy));
        }
        return lottery;
    }
    public RankResult createRankResult(WinningLotto winningNumber) {
         rankResult.putResult(findMatchNumber(winningNumber));
         return rankResult;
    }

    public List<Lotto> getLottery() {
        return lottery;
    }

    public int countAllLotto() {
        return lottery.size();
    }
    private List<Integer> findMatchNumber(WinningLotto winningNumber) {
        return lottery.stream()
                .map(lotto -> lotto.countMatch(winningNumber))
                .filter(matchNum -> matchNum >= Rank.FOURTH.getMatchNum())
                .collect(Collectors.toList());
    }

    private Lotto createLotto(ShuffleStrategy shuffleStrategy) {
        return new Lotto(sortAndLimitLottoNum(shuffleStrategy));
    }

    private List<LottoNumber> sortAndLimitLottoNum(ShuffleStrategy shuffleStrategy) {
        return shuffleLottoNum(shuffleStrategy)
                .stream()
                .limit(Lotto.LOTTO_NUMBER_SIZE)
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
