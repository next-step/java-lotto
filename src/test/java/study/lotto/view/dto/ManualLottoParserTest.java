package study.lotto.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.exception.LottoException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ManualLottoParserTest {

    @DisplayName("ManualLotto 파싱 하는 클래스 테스트")
    @Test
    void manual_생성테스트() {
        // given
        List<Set<Integer>> lotto = Arrays.asList(IntStream.rangeClosed(1, 6)
                .boxed()
                .collect(toSet()));
        // when
        ManualLottoParser manual = ManualLottoParser.of(lotto);
        // then
        assertThat(manual).isEqualTo(ManualLottoParser.of(lotto));
    }

    @DisplayName("ManualLotto 파싱 클래스 로또 갯수 부족으로 예외 테스트")
    @Test
    void manual_예외테스트() {
        // given
        List<Set<Integer>> lotto = Arrays.asList(IntStream.rangeClosed(1, 5)
                .boxed()
                .collect(toSet()));
        // then
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> ManualLottoParser.of(lotto));
    }
}
