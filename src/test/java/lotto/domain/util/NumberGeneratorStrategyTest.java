package lotto.domain.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableSet;
import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorStrategyTest {

    @Test
    @DisplayName("로또번호 6개를 무작위로 생성합니다.")
    void test01() {
        Lotto lotto = new LottoNumberGenerator().generate();
        List<Integer> lottoNumberList = parseToLottoNumberAsList(lotto);
        Set<Integer> lottoAllNumberSet = generateLottoSet();

        assertThat(lottoNumberList).allMatch(lottoAllNumberSet::contains);

    }

    private static List<Integer> parseToLottoNumberAsList(Lotto lotto) {
        String lottoNumbersAsString = lotto.toString();
        lottoNumbersAsString = lottoNumbersAsString.substring(1, lottoNumbersAsString.length() - 1);
        lottoNumbersAsString = lottoNumbersAsString.replace(" ", "");
        return Arrays.stream(lottoNumbersAsString.split(","))
                .map(Integer::valueOf)
                .collect(toUnmodifiableList());
    }

    private static Set<Integer> generateLottoSet() {
        return IntStream.rangeClosed(LottoNumber.LOTTO_NUMBER_MINIMUM, LottoNumber.LOTTO_NUMBER_MAXIMUM)
                .boxed()
                .collect(toUnmodifiableSet());
    }

}