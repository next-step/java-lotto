package lotto.domain.lottoMachine;

import lotto.domain.*;
import lotto.utils.LottoHelper;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLottoMachine implements LottoMachine {
    private List<LottoBall> balls;

    public DefaultLottoMachine() {
        this.balls = makeLottoBals();
    }

    @Override
    public List<Lotto> createAutoLotto(LottoRequest lottoRequest) {
        int gameTimes = getAutoGameTimes(lottoRequest);
        return IntStream.range(0, gameTimes)
                .mapToObj(i -> {
                    Collections.shuffle(this.balls);
                    return Lotto.of(pickLottoBalls());
                })
                .collect(Collectors.toList());
    }

    private int getAutoGameTimes(LottoRequest lottoRequest) {
        int gameTimes = lottoRequest.getTotalGameTimes(LottoStore.LOTTO_GAME_FEE);
        gameTimes -= lottoRequest.getManualGameTimes();
        return gameTimes;
    }

    @Override
    public List<Lotto> createManualLotto(LottoRequest lottoRequest) {
        if (lottoRequest.getManualLottoValues() == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(lottoRequest.getManualLottoValues())
                .map(value -> LottoHelper.toInts(LottoHelper.split(value)))
                .map(numbers -> Lotto.of(toLottoBalls(numbers)))
                .collect(Collectors.toList());
    }

    private List<LottoBall> toLottoBalls(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(number -> LottoBall.of(number))
                .collect(Collectors.toList());
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
