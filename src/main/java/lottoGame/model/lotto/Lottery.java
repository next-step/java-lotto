package lottoGame.model.lotto;

import lottoGame.Ranks;
import lottoGame.model.lotto.lottoNumber.DefaultLottoNumber;
import lottoGame.model.lotto.lottoNumber.LottoNumber;
import lottoGame.model.strategy.ShuffleStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    private final List<AutoLotto> lottery = new ArrayList<>();


    public List<AutoLotto> getLottery() {
        return lottery;
    }

    public int countAllLotto() {
        return lottery.size();
    }

    public List<AutoLotto> create(int lotteryNum, ShuffleStrategy shuffleStrategy) {
        for (int i = 0; i < lotteryNum; i++) {
            lottery.add(createLotto(shuffleStrategy));
        }
        return lottery;
    }

    public List<Integer> findMatchNumber(WinningLotto winningNumber) {
        return lottery.stream()
                .map(autoLotto -> autoLotto.countMatch(winningNumber))
                .filter(matchNum -> matchNum >= Ranks.FOURTH.getMatchNum())
                .collect(Collectors.toList());
    }

    private AutoLotto createLotto(ShuffleStrategy shuffleStrategy) {
        return new AutoLotto(sortAndLimitLottoNum(shuffleStrategy));
    }

    private List<LottoNumber> sortAndLimitLottoNum(ShuffleStrategy shuffleStrategy) {
        return shuffleLottoNum(shuffleStrategy)
                .stream()
                .limit(AutoLotto.LOTTO_NUMBER_SIZE)
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
