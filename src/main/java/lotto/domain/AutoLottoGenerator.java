package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.MAX_SIZE;
import static lotto.domain.LottoNumber.MAX_NUMBER;
import static lotto.domain.LottoNumber.MIN_NUMBER;

public class AutoLottoGenerator {

    private static final List<LottoNumber> LOTTO_NUMBER_RANGE = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private AutoLottoGenerator() {
        throw new AssertionError("LottoGenerator는 생성자를 호출할 수 없습니다.");
    }

    public static List<Lotto> generate(PlayLottoCount playLottoCount) {
        List<LottoNumber> copiedLottoNumbers = new ArrayList<>(LOTTO_NUMBER_RANGE);

        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < playLottoCount.getValue(); i++) {
            Collections.shuffle(copiedLottoNumbers);
            Set<LottoNumber> lottoNumbers = new HashSet<>(copiedLottoNumbers.subList(0, MAX_SIZE));
            result.add(new Lotto(lottoNumbers));
        }
        return result;
    }
}
