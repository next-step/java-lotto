package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoNumbers.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoNumbers.LOTTO_NUMBER_SET;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    @Test
    void generate_로또번호모음을_생성하여_반환한다() {
        LottoNumbers lottoNumbers = LottoNumbers.generate();
        List<Integer> lottoNumbersValue = lottoNumbers.getLottoNumbers();

        assertThat(new HashSet<>(lottoNumbersValue)).hasSize(LOTTO_NUMBER_COUNT);
        lottoNumbersValue.forEach(lottoNumber -> assertThat(lottoNumber).isIn(LOTTO_NUMBER_SET));
    }

    @ParameterizedTest
    @CsvSource(value = {"2_500,2", "3_000,3", "3_500,3"})
    void calculateCount_입력받은_금액만큼에_해당하는_로또_장수를_반환한다(int money, int lottoSheetCount) {
        assertThat(LottoNumbers.calculateSheetCount(money)).isEqualTo(lottoSheetCount);
    }

    @Test
    void create_입력받은_장수만큼_로또를_여러장_생성한다() {
        int count = 4;
        List<LottoNumbers> lottoNumbers = LottoNumbers.generate(count);

        assertThat(lottoNumbers).hasSize(count);
        lottoNumbers.forEach(numbers -> assertThat(numbers).isInstanceOf(LottoNumbers.class));
    }

    @Test
    void getResult_로또_여러_장의_당첨_결과를_생성한다() {
        LottoNumbers winningLottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers1 = new LottoNumbers(1, 2, 3, 7, 8, 9);
        LottoNumbers lottoNumbers2 = new LottoNumbers(1, 2, 7, 8, 9, 10);

        Map<LottoCashPrize, Integer> results = winningLottoNumbers.getResult(
                        Arrays.asList(lottoNumbers1, lottoNumbers2))
                .getValue();

        assertThat(results.get(LottoCashPrize.valueOf("FOURTH"))).isEqualTo(1);
        assertThat(results.get(LottoCashPrize.valueOf("NO_PRIZE"))).isEqualTo(1);
    }
}
