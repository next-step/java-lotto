package step2.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoRuleTest {

    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 45;
    private static final Integer SIZE = 6;

    @DisplayName("로또 번호 생성 조건을 모두 만족해야 함")
    @Test
    void createLottoWithAllConditions() {
        // given
        LottoRule lottoRule = new LottoRule(MIN_NUMBER, MAX_NUMBER, SIZE);

        // when
        List<Integer> generated = lottoRule.generateLotto();

        // then
        Assertions.assertThat(generated)
                .hasSize(SIZE)
                .doesNotHaveDuplicates()
                .allSatisfy(number -> Assertions.assertThat(number).isBetween(MIN_NUMBER, MAX_NUMBER));
    }

    @DisplayName("로또 번호 중복 입력 검증")
    @Test
    void validateDuplicateLottoNumbers() {
        // given
        LottoRule lottoRule = new LottoRule(MIN_NUMBER, MAX_NUMBER, SIZE);
        List<Integer> duplicateLottoNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        Assertions.assertThatThrownBy(() -> new Lotto(duplicateLottoNumbers, lottoRule))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("규칙을 만족하지 않는 숫자 입력입니다");
    }

    @DisplayName("로또 번호와 보너스 번호가 겹치는 상황 검증")
    @Test
    void validateLottoAndBonusNumberOverlap() {
        // given
        LottoRule lottoRule = new LottoRule(MIN_NUMBER, MAX_NUMBER, SIZE);
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        // when & then
        Assertions.assertThatThrownBy(() -> new WinningLotto(new Lotto(lottoNumbers, lottoRule), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
