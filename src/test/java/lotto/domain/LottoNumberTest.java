package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @Test
    @DisplayName("LottoNumber 생성, 동일 값 비교 테스트")
    void equals() {
        LottoNumber number = new LottoNumber(1);
        assertThat(number).isEqualTo(new LottoNumber(1));
    }

    @Test
    @DisplayName("작은 수 사용 시 예외 발생")
    void small() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LottoNumber(0);
                });
    }

    @Test
    @DisplayName("큰 수 사용 시 예외 발생")
    void big() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LottoNumber(46);
                });
    }

    @Test
    @DisplayName("buildAllLottoNumbers 검증")
    void buildAllLottoNumbers() {
        assertThat(LottoNumber.buildAllLottoNumbers())
                .isEqualTo((IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toList()))
                );
    }

    @Test
    @DisplayName("biggerThan")
    void biggerThan() {
        assertThat(new LottoNumber(10).biggerThan(9)).isTrue();
    }

    @Test
    @DisplayName("biggerThan")
    void biggerThan_lottoNumber() {
        assertThat(new LottoNumber(10).biggerThan(new LottoNumber(9))).isTrue();
    }

    @Test
    @DisplayName("smallerThan")
    void smallerThan() {
        assertThat(new LottoNumber(5).smallerThan(6)).isTrue();
    }

    @Test
    @DisplayName("smallerThan")
    void smallerThan_lottoNumber() {
        assertThat(new LottoNumber(5).smallerThan(new LottoNumber(6))).isTrue();
    }
}
