package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @ParameterizedTest
    @CsvSource(value = {"7,8,9,10,11,12:0", "1,8,9,10,11,12:0", "1,2,9,10,11,12:0",
            "1,2,3,10,11,12:3",
            "1,2,3,4,11,12:4",
            "1,2,3,4,5,12:5",
            "1,2,3,4,5,6:6"}
            , delimiter = ':')
    @DisplayName("로또 등수계산")
    void lotto_inquiryRank(String winNumbers, int matchCount) {
        // given
        int[] lottoNumbers = {1, 2, 3, 4, 5, 6};
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        LottoRank lottoRank = lotto.inquiryRank(Arrays.stream(winNumbers.split(",")).mapToInt(Integer::valueOf).toArray(), 20);

        // then
        assertThat(LottoRank.inquiryRank(matchCount, false)).isEqualTo(lottoRank);
    }

    @Test
    @DisplayName("로또번호 null 입력")
    void lotto_nullInput() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(null))
                .withMessageMatching("당첨 숫자를 입력해 주세요.");
    }

    @Test
    @DisplayName("로또번호 개수 오류")
    void lotto_numberCount() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(new int[]{1, 2, 3, 4, 5, 6, 7}))
                .withMessageMatching("당첨 숫자는 6개의 수 여야 합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(new int[]{1, 2, 3, 4, 5}))
                .withMessageMatching("당첨 숫자는 6개의 수 여야 합니다.");
    }

    @Test
    @DisplayName("로또번호 중복입력")
    void lotto_dupInput() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(new int[]{1, 2, 2, 4, 5, 6}))
                .withMessageMatching("중복된 숫자가 존재합니다. 입력값을 확인해주세요.");
    }

    @Test
    @DisplayName("로또 숫자 범위 불일치")
    void lotto_numberRange() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(new int[]{1, 48, 2, 3, 5, 6}))
                .withMessageMatching("로또 숫자는 1과 45사이의 정수 이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("로또당첨 - 유효하지 않은 보너스번호")
    void lotto_isBonusNumberInvalid(int bonusNumber) {
        // given
        int[] lottoNumbers = {1, 2, 3, 4, 5, 6};
        Lotto lotto = new Lotto(lottoNumbers);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotto.inquiryRank(new int[] {1, 2, 3, 4, 5, 6}, bonusNumber))
                .withMessageMatching("로또 숫자는 1과 45사이의 정수 이어야 합니다.");
    }

    @Test
    @DisplayName("로또당첨 - 당첨번호와 보너스번호가 중복될 때")
    void lotto_inquiryRank_dupBonusNumber() {
        // given
        int[] lottoNumbers = {1, 2, 3, 4, 5, 6};
        Lotto lotto = new Lotto(lottoNumbers);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotto.inquiryRank(new int[] {1, 2, 3, 4, 5, 6}, 1))
                .withMessageMatching("보너스 번호와 당첨번호가 중복됩니다. 보너스 번호를 다시 확인해 주세요.");
    }

    @Test
    @DisplayName("로또당첨 - 당첨번호와 보너스번호")
    void lotto_inquiryRank_bonusNumber() {
        // given
        int[] lottoNumbers = {1, 2, 3, 4, 5, 6};
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        LottoRank lottoRank = lotto.inquiryRank(new int[]{1, 2, 3, 4, 5, 7}, 6);

        // then
        assertThat(LottoRank.SECOND).isEqualTo(lottoRank);
    }

}