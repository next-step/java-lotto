package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.MAX_SIZE;
import static lotto.domain.LottoNumber.MAX_NUMBER;
import static lotto.domain.LottoNumber.MIN_NUMBER;

public class LottoGenerator {

    private static final List<LottoNumber> LOTTO_NUMBER_RANGE = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private LottoGenerator() {
        throw new AssertionError("LottoGenerator는 생성자를 호출할 수 없습니다.");
    }

    public static List<Lotto> generate(int size) {
        validateSize(size);
        List<LottoNumber> copiedLottoNumbers = new ArrayList<>(LOTTO_NUMBER_RANGE);

        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Collections.shuffle(copiedLottoNumbers);
            Set<LottoNumber> lottoNumbers = new HashSet<>(copiedLottoNumbers.subList(0, MAX_SIZE));
            result.add(new Lotto(lottoNumbers));
        }
        return result;
    }

    private static void validateSize(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("1이상의 size가 필요합니다.");
        }
    }
}
