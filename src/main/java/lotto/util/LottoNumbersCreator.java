package lotto.util;

import lotto.model.dto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersCreator implements NumbersCreator {
    @Override
    public List<LottoNumber> create() {
        List<Integer> integers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(integers);
        return integers.stream()
                .limit(6) // 첫 6개 요소 가져오기
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
