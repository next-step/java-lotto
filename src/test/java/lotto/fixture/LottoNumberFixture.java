package lotto.fixture;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberFixture {

    public static List<LottoNumber> 로또_번호_생성(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> 로또_번호_생성(int count) {
        return LottoNumber.LOTTO_NUMBERS.subList(0, count);
    }
}
