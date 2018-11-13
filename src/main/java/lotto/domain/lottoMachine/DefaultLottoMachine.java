package lotto.domain.lottoMachine;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLottoMachine implements LottoMachine {
    private List<LottoBall> balls;

    public DefaultLottoMachine() {
        this.balls = makeLottoBals();
    }

    @Override
    public List<Lotto> createAutoLotto(LottoRequest lottoRequest) {

        int gameTimes = lottoRequest.getTotalGameTimes(LottoStore.LOTTO_GAME_FEE);
        gameTimes -= lottoRequest.getManualGameTimes();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < gameTimes; i++) {
            Collections.shuffle(this.balls);
            lottos.add(Lotto.of(pickLottoBalls()));
        }

        return lottos;
    }

    @Override
    public List<Lotto> createManualLotto(LottoRequest lottoRequest) {
        if (lottoRequest.getManualGameTimes() == 0) return null;
        return lottoRequest.getManualLottoNumbers().stream()
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
