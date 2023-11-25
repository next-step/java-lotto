package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("6개 숫자의 자동 로또 번호가 생성된다.")
    void auto_lotto_numbers_size() {
        LottoNumberGenerator lottoNumberGenerator = new AutoLottoNumberGenerator();

        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    @DisplayName("로또가 다른 숫자로 생성된 게 맞는지 확인한다.")
    void auto_lotto_numbers_randomly() {
        LottoNumberGenerator lottoNumberGenerator = new AutoLottoNumberGenerator();

        List<Integer> numbers1 = lottoNumberGenerator.generate();
        List<Integer> numbers2 = lottoNumberGenerator.generate();

        assertThat(numbers1).isNotEqualTo(numbers2);
    }

    @Test
    @DisplayName("문자열을 입력하면 로또 번호로 변환한다.")
    void manual_lotto_numbers() {
        LottoNumberGenerator lottoNumberGenerator = new ManualLottoNumberGenerator("1, 22, 33, 12, 34, 6");

        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        assertThat(lottoNumbers).containsExactly(1, 6, 12, 22, 33, 34);
    }

    @Test
    @DisplayName("수동 로또 번호 생성 시 입력 형식에 맞지 않으면 예외를 던진다.")
    void manual_pattern_exception() {
        assertThatThrownBy(() -> new ManualLottoNumberGenerator("1, 2, 3, 4,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 형식에 맞지 않습니다.");
    }
}
