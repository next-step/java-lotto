package util;

import domain.LottoNumber;
import domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParsingUtil {
    public static List<Integer> parseStringToIntList(String s) {
        String[] split = s.replaceAll("\\s+", "").split(",");

        return Arrays.stream(split)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    public static LottoNumbers parseStringToLottoNumbers(String s) {
        String[] split = s.replaceAll("\\s+", "").split(",");

        List<LottoNumber> numbers = Arrays.stream(split)
            .mapToInt(Integer::parseInt)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

        return new LottoNumbers(numbers);
    }
}
