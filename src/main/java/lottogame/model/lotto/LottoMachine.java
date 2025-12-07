package lottogame.model.lotto;

import static java.util.stream.IntStream.range;
import static lottogame.model.util.StringUtils.splitAndParseToInt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.model.lotto.generator.AutoLottoGenerator;
import lottogame.model.lotto.generator.ManualLottosGenerator;

public class LottoMachine {

    public static final int LOTTO_NUM_COUNT = 6;
    public static final int PER_LOTTO_PRICE = 1_000;
    public static final String DELIMITER = ", ";

    public static Lottos createTotallyLottos(int autoLottoCount, List<String> manualLottoNums) {
        Lottos autoLottos = new AutoLottoGenerator(autoLottoCount).generateLottos();
        Lottos manualLottos = new ManualLottosGenerator(manualLottoNums).generateLottos();

        return autoLottos.merge(manualLottos);
    }

    public static Set<LottoNum> createLottoNums(Set<Integer> rawNums) {
        if (rawNums.isEmpty() || rawNums.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("생성할 로또의 로또번호 갯수를 정확히 입력해 주세요.");
        }

        return rawNums.stream()
                .map(LottoNum::of)
                .collect(Collectors.toSet());
    }

    public static Set<LottoNum> createLottoNums(String rawNums) {
        if (rawNums.isEmpty()) {
            throw new IllegalArgumentException("생성할 로또의 로또번호 갯수를 정확히 입력해 주세요.");
        }

        return createLottoNums(splitAndParseToInt(rawNums, DELIMITER));
    }


}
