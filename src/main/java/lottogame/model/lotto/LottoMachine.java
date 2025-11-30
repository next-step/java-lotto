package lottogame.model.lotto;

import static java.util.stream.IntStream.range;
import static lottogame.model.lotto.LottoNum.MAX_NUM;
import static lottogame.model.lotto.LottoNum.MIN_NUM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.model.price.LottoPurchasePrice;

public class LottoMachine {

    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int LOTTO_NUM_COUNT = 6;
    public static final int PER_LOTTO_PRICE = 1_000;

    private static final Random RANDOM = new Random();

    private static final Map<Integer, LottoNum> LOTTO_NUM_POOL = new HashMap<>();

    static {
        range(MIN_NUM, MAX_NUM + 1).forEach(
                num -> LOTTO_NUM_POOL.put(num, new LottoNum(num))
        );
    }

    public Lottos publish(LottoPurchasePrice lottoPurchasePrice) {
        List<Lotto> lottos = range(0, lottoPurchasePrice.calculateLottoCount(PER_LOTTO_PRICE))
                .mapToObj(idx ->
                        new Lotto(
                                createLottoByCount(LOTTO_NUM_COUNT)
                        )
                ).toList();

        return new Lottos(lottos);
    }

    public LottoNum getLottoNum(int num) {
        return LOTTO_NUM_POOL.get(num);
    }

    private Set<LottoNum> createLottoByCount(int numCount) {
        if (numCount <= 0) {
            throw new IllegalArgumentException("생성할 로또의 로또번호 갯수를 입력해 주세요.");
        }

        Set<LottoNum> lottoNums = new HashSet<>();
        while (lottoNums.size() < numCount) {
            LottoNum lottoNum = getLottoNum(RANDOM.nextInt(MIN_NUM, MAX_NUM));
            lottoNums.add(lottoNum);
        }

        return lottoNums;
    }

    public Set<LottoNum> createLottoByNums(Set<Integer> rawNums) {
        if (rawNums.isEmpty() || rawNums.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("생성할 로또의 로또번호 갯수를 정확히 입력해 주세요.");
        }

        return rawNums.stream()
                .map(LOTTO_NUM_POOL::get)
                .collect(Collectors.toSet());
    }
}
