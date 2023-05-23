package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumbersTest {

    @Test
    @DisplayName("로또번호 그룹 생성 테스트")
    void generateLottoNumbers() {

        LottoNumbers lottoNumbers = LottoNumbers.of("1, 2, 3, 4, 5, 6");
        assertThat(lottoNumbers).isNotNull();

    }

    @Test
    @DisplayName("로또번호가 없으면 예외를 던진다")
    void throwExceptionLottoNumbers() {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(null))
                        .withMessage("로또번호가 입력되지 않았어요 :("),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(List.of()))
                        .withMessage("로또번호가 입력되지 않았어요 :(")
        );
    }

    @Test
    @DisplayName("로또넘버간 매칭된 숫자 찾는 테스트")
    void countMatchingLottoNumber() {

        LottoNumbers lottoNumbers = LottoNumbers.of("1, 7, 8, 9, 10, 11");
        LottoNumbers targetLottoNumbers = LottoNumbers.of("1, 2, 3, 4, 5, 6");

        assertThat(lottoNumbers.countMatchingLottoNumber(targetLottoNumbers)).isEqualTo(1);
    }
}