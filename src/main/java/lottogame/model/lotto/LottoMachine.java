package lottogame.model.lotto;

import static java.util.stream.IntStream.range;
import static lottogame.model.lotto.LottoNum.MAX_NUM;
import static lottogame.model.lotto.LottoNum.MIN_NUM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import lottogame.model.price.LottoPurchasePrice;

public class LottoMachine {

    public static final int LOTTO_NUM_COUNT = 6;

    private final int perLottoPrice;

    public LottoMachine(int perLottoPrice) {
        this.perLottoPrice = perLottoPrice;
    }

    public Lottos publish(LottoPurchasePrice lottoPurchasePrice) { // 2
        List<Lotto> lottos = range(0, lottoPurchasePrice.calculateLottoCount(perLottoPrice)) // 1
                .mapToObj(idx ->
                        new Lotto( // 1
                                createLottoByCount(LOTTO_NUM_COUNT) // 1
                        )
                ).toList();

        return new Lottos(lottos); // 2
    }

    private LottoNum createLottoNum() {
        return new LottoNum(
                new Random().nextInt(MIN_NUM, MAX_NUM)
        );
    }

    private List<LottoNum> createLottoByCount(int numCount) {
        if (numCount <= 0) {
            throw new IllegalArgumentException("생성할 로또의 로또번호 갯수를 입력해 주세요.");
        }

        Set<LottoNum> lottoNums = new HashSet<>();
        while (lottoNums.size() < numCount) {
            lottoNums.add(createLottoNum());
        }

        return new ArrayList<>(lottoNums);
    }

    public List<LottoNum> createLottoByNums(List<Integer> rawNums) {
        if (rawNums.isEmpty() || rawNums.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("생성할 로또의 로또번호 갯수를 정확히 입력해 주세요.");
        }

        Set<LottoNum> lottoNums = new HashSet<>();
        while (lottoNums.size() < LOTTO_NUM_COUNT) {
            lottoNums.add(createLottoNum());
        }

        return new ArrayList<>(lottoNums);
    }


}
