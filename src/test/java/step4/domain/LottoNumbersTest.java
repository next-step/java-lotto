package step4.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @DisplayName("로또 발행 시 6개의 번호가 아닐 시 예외처리")
    @Test
    void lotto_list_size_6() {
        Assertions.assertThatThrownBy(() -> LottoNumbers.from(Stream.of(
                LottoNumber.from(1)).collect(Collectors.toSet())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("MatchCount 계산 시 당첨 번호와 로또 번호 일치 개수를 반환")
    @Test
    void calculateMatchCount() {
        LottoNumbers lottoNumbers = LottoNumbers.from(Stream.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)).collect(Collectors.toSet()));
        int countOfMatch = lottoNumbers.calculateMatchCount(Stream.of(
                        LottoNumber.from(1),
                        LottoNumber.from(2),
                        LottoNumber.from(3),
                        LottoNumber.from(4),
                        LottoNumber.from(5))
                .collect(Collectors.toSet()));
        Assertions.assertThat(countOfMatch).isEqualTo(5);
    }

    @DisplayName("BonusBall 당첨 확인 시 로또 번호 중 일치 확인")
    @Test
    void lottoNumbers_contains_bonusBall_return_true() {
        LottoNumbers lottoNumbers = LottoNumbers.from(Stream.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)).collect(Collectors.toSet()));
        boolean isBonusBallMatch = lottoNumbers.hasNumber(5);
        Assertions.assertThat(isBonusBallMatch).isTrue();
    }
}
