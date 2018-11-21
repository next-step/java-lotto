package domain;

import java.util.*;
import java.util.stream.IntStream;

public class LottoCreate {
    private List<Lotto> lottocreate;

    private LottoCreate(List<Lotto> lottocreate) {
        this.lottocreate = lottocreate;
    }

    public List<Lotto> getLottocreate() {
        return lottocreate;
    }

    public LottoResult match(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();

        for(Lotto lotto : lottocreate) {
            lottoResult.addLotto((winningLotto.matchesNo(lotto)));
        }

        return lottoResult;
    }

    public static LottoCreate from(int num) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            lottos.add(LottoCreate.pickLottoBalls());
        }
        return new LottoCreate(lottos);
    }

    public static Lotto pickLottoBalls() {
        List<Integer> lottoBalls = (createAutoLottoBall().subList(0, 6));
        Collections.sort(lottoBalls);
        return Lotto.from(lottoBalls);
    }

    public static List<Integer> createAutoLottoBall() {
        List<Integer> lottoBall = new ArrayList<>();
        IntStream.range(1, 46).forEach(i -> lottoBall.add(i));
        Collections.shuffle(lottoBall);
        return lottoBall;
    }
}
