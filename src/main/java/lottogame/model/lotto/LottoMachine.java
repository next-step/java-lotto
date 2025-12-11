package lottogame.model.lotto;

import static lottogame.model.util.StringUtils.splitAndParseToInt;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {

    public static final int LOTTO_NUM_COUNT = 6;
    public static final String DELIMITER = ", ";

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
