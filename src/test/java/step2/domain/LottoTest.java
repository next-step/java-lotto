package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.Lotto.getLottoNos;

public class LottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1:7:6"}, delimiter = ':')
    public void 로또_자동생성(int start, int end, int size) {
        List<Integer> loTToNos = getLottoNos(start, end);
        assertThat(loTToNos.size()).isEqualTo(size);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:7:6"}, delimiter = ':')
    public void 로또_복수_게임_자동생성(int start, int end, int size) {
        List<Integer> loTToNos = getLottoNos(start, end);
        assertThat(loTToNos.size()).isEqualTo(size);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:7:1"}, delimiter = ':')
    public void 당첨_번호_확인(int start, int end, int result) {
        List<Integer> loTToNos = getLottoNos(start, end);
        assertThat(loTToNos.contains(result)).isTrue();
    }
}
