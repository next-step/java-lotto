package lottogame.model.lotto.generator;

import static java.util.stream.IntStream.*;
import static lottogame.model.lotto.LottoMachine.LOTTO_NUM_COUNT;
import static lottogame.model.lotto.LottoNum.of;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import lottogame.model.lotto.Lotto;
import lottogame.model.lotto.LottoNum;
import lottogame.model.lotto.Lottos;

public class AutoLottoGenerator implements LottosGenerator{
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;

    private static final Random RANDOM = new Random();

    private final int autoLottoCount;

    public AutoLottoGenerator(int autoLottoCount) {
        this.autoLottoCount = autoLottoCount;
    }

    @Override
    public Lottos generateLottos() {
        List<Lotto> lottos = range(0, autoLottoCount)
                .mapToObj(idx -> createLottoByCount())
                .map(Lotto::new)
                .toList();

        return new Lottos(lottos);
    }

    private Set<LottoNum> createLottoByCount() {
        Set<LottoNum> lottoNums = new HashSet<>();
        while (lottoNums.size() < LOTTO_NUM_COUNT) {
            LottoNum lottoNum = of(getRandomNum());
            lottoNums.add(lottoNum);
        }

        return lottoNums;
    }

    private int getRandomNum() {
        return RANDOM.nextInt(MIN_NUM, MAX_NUM);
    }
}
