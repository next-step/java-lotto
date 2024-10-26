package lotto;

import lotto.entity.LottoNumber;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMethod {

    public static List<LottoNumber> toList(List<Integer> numbers) {
        return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
    }

    public static Set<LottoNumber> toList(Set<Integer> numbers) {
        return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toSet());
    }

    public static Set<LottoNumber> toSet(Set<Integer> numbers) {
        return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toSet());
    }
}
