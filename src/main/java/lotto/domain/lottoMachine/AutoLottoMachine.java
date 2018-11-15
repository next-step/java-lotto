package lotto.domain.lottoMachine;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRequest;
import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;

public class AutoLottoMachine implements LottoMachine {
    private List<LottoBall> balls;
    
    public AutoLottoMachine() {
        super();
        this.balls = makeLottoBals();
    }

    @Override
    public LottoTicket createLotto(LottoRequest lottoRequest) {
        return LottoTicket.of(create(lottoRequest));
    }
    
    private List<Lotto> create(LottoRequest lottoRequest) {
        int gameTimes = getAutoGameTimes(lottoRequest);
        return IntStream.range(0, gameTimes)
                .mapToObj(i -> {
                    Collections.shuffle(this.balls);
                    return Lotto.ofAuto(pickLottoBalls());
                })
                .collect(Collectors.toList());
    }

    private int getAutoGameTimes(LottoRequest lottoRequest) {
        int gameTimes = lottoRequest.getTotalGameTimes(LottoStore.LOTTO_GAME_FEE);
        gameTimes -= lottoRequest.getManualGameTimes();
        return gameTimes;
    }
    
    private List<LottoBall> pickLottoBalls() {
        return this.balls.subList(0, Lotto.LOTTO_NUMERS);
    }

    private List<LottoBall> makeLottoBals() {
        return IntStream.range(LottoBall.LOTTO_MIN_NUMBER, LottoBall.LOTTO_MAX_NUMBER)
                .mapToObj(number -> LottoBall.of(number))
                .collect(Collectors.toList());
    }

}
