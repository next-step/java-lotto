package lotto.domain.lottoMachine;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoMachine implements LottoMachine {
    private List<LottoBall> balls;

    public AutoLottoMachine() {
        this.balls = makeLottoBals();
    }

    @Override
    public List<Lotto> createLotto(LottoRequest lottoRequestCard) {

        int gameTimes = lottoRequestCard.getTotalGameTimes(LottoStore.LOTTO_GAME_FEE);
        gameTimes -= lottoRequestCard.getManualGameTimes();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < gameTimes; i++) {
            Collections.shuffle(this.balls);
            lottos.add(new Lotto(pickLottoBalls()));
        }

        return lottos;
    }

    private List<LottoBall> pickLottoBalls() {
        return this.balls.subList(0, Lotto.LOTTO_NUMERS);
    }

    private List<LottoBall> makeLottoBals() {
        return IntStream.range(LottoBall.LOTTO_MIN_NUMBER, LottoBall.LOTTO_MAX_NUMBER)
                .mapToObj(number -> new LottoBall(number))
                .collect(Collectors.toList());
    }
}
