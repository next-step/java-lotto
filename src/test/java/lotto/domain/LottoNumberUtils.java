package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberUtils {

    static public List<LottoNumber> toList(String numbers){
        return Arrays.asList(numbers.split(",")).stream()
                .map(String::trim)
                .map(Integer::valueOf)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    static public ListLottoNumberMatcher listNumberMatcher(String sourceNumbers) {
        List<LottoNumber> inumbers = Arrays.asList(sourceNumbers.split(",")).stream()
                .map(String::trim)
                .map(Integer::valueOf)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new ListLottoNumberMatcher(inumbers);
    }
}
