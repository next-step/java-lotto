package lottogame.model.lotto;

import static java.util.stream.IntStream.range;

import java.util.HashSet;
import java.util.List;
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

    public static Lottos createAutoLotto(int autoLottoCount) {
        List<Lotto> lottos = range(0, autoLottoCount)
                .mapToObj(idx ->
                        new Lotto(
                                createLottoByCount(LOTTO_NUM_COUNT)
                        )
                ).toList();

        return new Lottos(lottos);
    }

    public static Lottos createManualLotto(ManualLottos manualLottos) {
        return manualLottos.convertToLottos();
    }


    public static LottoNum getLottoNum(int num) {
        return LottoNum.getInstance(num);
    }

    private static Set<LottoNum> createLottoByCount(int numCount) {
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

    public static Set<LottoNum> createLottoNums(Set<Integer> rawNums) {
        if (rawNums.isEmpty() || rawNums.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("생성할 로또의 로또번호 갯수를 정확히 입력해 주세요.");
        }

        return rawNums.stream()
                .map(LottoNum::getInstance)
                .collect(Collectors.toSet());
    }
}
