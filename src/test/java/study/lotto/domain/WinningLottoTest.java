package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.type.LottoMatch;
import study.lotto.exception.LottoException;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningLottoTest {

    @DisplayName("지난 주 당첨 번호 및 보너스 번호 관리 객체 생성 테스트")
    @Test
    void create_지난주_당첨번호_및_보너스_번호() {
        // given
        String winningNumbers = "1,2,3,4,5,6";
        LottoNumber bonusNumber = LottoNumber.of(15);
        // when
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        // then
        assertThat(winningLotto).isEqualTo(WinningLotto.of(winningNumbers, bonusNumber));
    }

    @DisplayName("지난 주 당첨번호 및 보너스 번호 관리 생성시 보너스 번호 포함 예외 처리 테스트")
    @Test
    void create_지난주_당첨번호_및_보너스_번호_예외처리() {
        // given
        String winningNumbers = "1,2,3,4,5,6";
        LottoNumber bonusNumber = LottoNumber.of(1);
        // when

        // then
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> WinningLotto.of(winningNumbers, bonusNumber));
    }

    @DisplayName(value = "당첨번호 매칭 테스트")
    @Test
    void match_지난주_당첨번호_매칭() {
        // given
        String lottoNumbers = "1,2,3,4,5,6";
        LottoNumber bonusNumber = LottoNumber.of(7);
        // when
        Set<LottoNumber> winningLottoNumbers = Arrays.stream(
                lottoNumbers.split(","))
                .map(LottoNumber::of)
                .collect(Collectors.toSet());

        WinningLotto winningLotto = WinningLotto.of(lottoNumbers, bonusNumber);
        LottoMatch match = winningLotto.match(Lotto.of(winningLottoNumbers));
        // then
        assertThat(match).isEqualTo(LottoMatch.RANK_FIRST);
    }

    @DisplayName(value = "당첨번호 당첨금 확인 테스트")
    @Test
    void winningReward_당첨금액_확인() {
        // given
        String lottoNumbers = "1,2,3,4,5,6";
        LottoNumber bonusNumber = LottoNumber.of(7);
        // when
        WinningLotto winningLotto = WinningLotto.of(lottoNumbers, bonusNumber);
        Set<LottoNumber> winningLottoNumbers = Arrays.stream(
                lottoNumbers.split(","))
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
        long winningReward = winningLotto.winningReward(Lotto.of(winningLottoNumbers));
        // then
        assertThat(winningReward).isEqualTo(LottoMatch.RANK_FIRST.getWinningReward());
    }
}
