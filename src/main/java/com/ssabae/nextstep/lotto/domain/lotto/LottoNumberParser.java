package com.ssabae.nextstep.lotto.domain.lotto;

import static com.ssabae.nextstep.lotto.Constant.LOTTO_NUMBER_SEPARATOR;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-24
 */
public class LottoNumberParser {

    public static List<LottoNumber> parse(String numbers) {
        try {
            return Collections.unmodifiableList(
                    Arrays.stream(numbers.split(LOTTO_NUMBER_SEPARATOR))
                            .map(String::trim)
                            .map(Integer::parseInt)
                            .sorted(Comparator.comparingInt(o -> o))
                            .map(LottoNumber::of)
                            .collect(Collectors.toList())
            );        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자 이외의 문자는 들어올 수 없습니다.");
        }
    }
}
