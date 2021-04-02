package step2.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.InvalidNumberInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGenerateCountTest {

    @DisplayName("LottoGenerateCount 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int testMoney = 1000;

        // when
        LottoGenerateCount lottoGenerateCount = LottoGenerateCount.of(testMoney);

        // then
        assertThat(lottoGenerateCount).isNotNull();
    }

    @DisplayName("LottoGenerateCount 인스턴스에 음수 입력시 예외처리 테스트")
    @Test
    void 검증_음수() {
        // given
        int testMoney = -1;

        // when and then
        assertThatThrownBy(() -> LottoGenerateCount.of(testMoney))
                .isInstanceOf(InvalidNumberInputException.class)
                .hasMessageContaining("범위를 벗어난 값이 입력되었습니다.");

    }

    @DisplayName("LottoGenerateCount 인스턴스가 다음 시점으로 넘어갈 수 있는지 테스트")
    @Test
    void 다음() {
        // given
        int testMoney = 1000;

        // when
        LottoGenerateCount lottoGenerateCount = LottoGenerateCount.of(testMoney);
        boolean actual = lottoGenerateCount.hasNext();

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("LottoGenerateCount 인스턴스가 다음 시점으로 넘어가는지 테스트")
    @Test
    void 다음으로_이동() {
        // given
        int testMoney = 1000;

        // when
        LottoGenerateCount lottoGenerateCount = LottoGenerateCount.of(testMoney);
        lottoGenerateCount.next();
        boolean actual = lottoGenerateCount.hasNext();

        // then
        assertThat(actual).isFalse();
    }


}