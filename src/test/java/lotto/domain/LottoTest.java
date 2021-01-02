package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private Lotto lotto;

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,2", "2,3", "3,4", "4,5", "5,6"},delimiter = ',')
    @DisplayName("번호 정렬 테스트")
    void sort(int index, int number) {
        lotto = new Lotto(asList(
                LottoNumber.of(6),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(3),
                LottoNumber.of(1),
                LottoNumber.of(2)));

        assertThat(LottoNumber.of(number) == lotto.getIndexNumber(index)).isTrue();
    }
}