package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.type.LottoMatch;
import study.lotto.exception.LottoException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningLottoTest {

    @DisplayName("지난 주 당첨 번호 및 보너스 번호 관리 객체 생성 테스트")
    @Test
    void create_지난주_당첨번호_및_보너스_번호() {

        List<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        WinningLotto winningLotto = new WinningLotto(lottoNumbers, new LottoNumber(15));

        assertThat(winningLotto).isEqualTo(new WinningLotto(lottoNumbers, new LottoNumber(15)));
    }

    @DisplayName("지난 주 당첨번호 및 보너스 번호 관리 생성시 보너스 번호 포함 예외 처리 테스트")
    @Test
    void create_지난주_당첨번호_및_보너스_번호_예외처리() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> new WinningLotto(lottoNumbers, new LottoNumber(6)));
    }

    @DisplayName(value = "당첨번호 매칭 테스트")
    @Test
    void match_지난주_당첨번호_매칭() {

        List<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        WinningLotto winningLotto = new WinningLotto(lottoNumbers, new LottoNumber(7));

        LottoMatch match = winningLotto.match(new Lotto(lottoNumbers));

        assertThat(match).isEqualTo(LottoMatch.RANK_FIRST);
    }

    @DisplayName(value = "당첨번호 당첨금 확인 테스트")
    @Test
    void winningReward_당첨금액_확인() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        WinningLotto winningLotto = new WinningLotto(lottoNumbers, new LottoNumber(7));

        long winningReward = winningLotto.winningReward(new Lotto(lottoNumbers));

        assertThat(winningReward).isEqualTo(LottoMatch.RANK_FIRST.getWinningReward());
    }
}
