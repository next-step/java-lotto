package step3.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.domain.LottoNum.MAX_LOTTO_NUM;
import static step3.domain.LottoNum.MIN_LOTTO_NUM;
import static step3.domain.LottoNums.LOTTO_NUM_COUNT;

public class LottoNumSetGenerator {
    private static final List<LottoNum> ALL_LOTTO_NUM =
            IntStream.rangeClosed(MIN_LOTTO_NUM, MAX_LOTTO_NUM)
                    .mapToObj(LottoNum::new)
                    .collect(Collectors.toList());

    public static LottoNums generateRandomSet() {
        Collections.shuffle(ALL_LOTTO_NUM);
        return new LottoNums(ALL_LOTTO_NUM.subList(0, LOTTO_NUM_COUNT));
    }

    public static LottoNums generateSet(String lottoNumsInput) {
        List<LottoNum> lottoNums = Arrays.stream(lottoNumsInput.split(", "))
                .map(numStr -> {
                    try {
                        return Integer.parseInt(numStr);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("로또 번호는 숫자만 입력 가능합니다: " + numStr);
                    }
                })
                .map(LottoNum::new)
                .collect(Collectors.toList());
        return new LottoNums(lottoNums);
    }
}
