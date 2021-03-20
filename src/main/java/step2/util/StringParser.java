package step2.util;

import step2.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    public static List<LottoNumber> toLottoNumberList(String number) {
        String[] numbers = number.split(",");
        List<LottoNumber> lottoNumbers;
        try {
            lottoNumbers = Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .map(LottoNumber::of)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("로또 당첨번호에 숫자가 아닌 부분이 있습니다.");
        }
        return lottoNumbers;
    }

}
