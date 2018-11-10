package lotto.domain;

import lotto.utils.LottoHelper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int LOTTO_NUMERS = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private List<LottoBall> balls = null;

    public LottoMachine() {
        this.balls = makeBalls();
    }

    public Lotto createLotto() {
        return createLotto(selectBalls());
    }

    public Lotto createLotto(List<LottoBall> balls) {
        return new Lotto(balls);
    }

    public WInningLotto createWinningLotto(String winningNumbers, int bonusNumber) {
        return new WInningLotto(LottoHelper.convertToBalls(winningNumbers), LottoHelper.convertToBall(bonusNumber));
    }

    private List<LottoBall> selectBalls() {
        Collections.shuffle(this.balls);
        return this.balls.subList(0, LOTTO_NUMERS);
    }

    public LottoResult check(WInningLotto winningLotto, List<Lotto> buyedLottos) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : buyedLottos) {
            int matchCount = winningLotto.howManyMatchBall(lotto);
            int bonusCount = winningLotto.hasBonusBall(lotto);
            lottoResult.addResult(LottoPrize.findPrize(matchCount, bonusCount));
        }
        
        return lottoResult;
    }

    private List<LottoBall> makeBalls() {
        return IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).mapToObj(number -> new LottoBall(number)).collect(Collectors.toList());
    }
}
