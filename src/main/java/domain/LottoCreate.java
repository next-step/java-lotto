package domain;

import java.util.*;
import java.util.stream.IntStream;

public class LottoCreate implements LottoGenerator{
    private List<Lotto> lottocreate;

    private LottoCreate() {
        lottocreate = new ArrayList<>();
    }

    public List<Lotto> getLottocreate() {
        return lottocreate;
    }

    public List<Lotto> generate(Money money) {
        int num = money.turnOfLotto();
        IntStream.range(0, num).forEach(i -> lottocreate.add(pickLottoBalls()));
        return lottocreate;
    }

    public LottoResult match(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        lottocreate.forEach(l -> {
            lottoResult.addLotto(winningLotto.matchesNo(l));
        });
        return lottoResult;
    }

    public static LottoCreate from() {
        return new LottoCreate();
    }

    public Lotto pickLottoBalls() {
        List<Integer> lottoBalls = (createAutoLottoBall().subList(0, 6));
        Collections.sort(lottoBalls);
        return Lotto.from(lottoBalls);
    }

    public List<Integer> createAutoLottoBall() {
        List<Integer> lottoBall = new ArrayList<>();
        IntStream.range(1, 46).forEach(i -> lottoBall.add(i));
        Collections.shuffle(lottoBall);
        return lottoBall;
    }
}