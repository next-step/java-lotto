package lotto.dto;

import lotto.model.LottoNumber;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ExtractLottoNumbers {
    private static final String DELIMITER = ", ";

    private ExtractLottoNumbers() {
    }

    public static Set<LottoNumber> split(String lottoNumbers) {
        validate(lottoNumbers);
        try {
            Set<LottoNumber> lotto = Arrays
                    .stream(lottoNumbers.split(DELIMITER))
                    .map(LottoNumber::new)
                    .collect(Collectors.toSet());
            return lotto;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 당첨 번호 입력이 올바르지 않습니다. ', '로 구분해서 숫자를 입력해주세요. lottoNumbers:" + lottoNumbers);
        }
    }

    private static String validate(String lottoNumbers) {
        return Objects.requireNonNull(lottoNumbers, "로또 당첨 번호 입력이 올바르지 않습니다. lottoNumbers is null");
    }
}
