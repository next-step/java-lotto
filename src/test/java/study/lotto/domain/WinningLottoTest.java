package study.lotto.domain;

import org.junit.jupiter.api.Test;
import study.lotto.domain.type.LottoMatch;
import study.lotto.exception.LottoException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningLottoTest {

    @Test
    void testCase() {

        List<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        WinningLotto winningLotto = new WinningLotto(lottoNumbers, new LottoNumber(15));

        assertThat(winningLotto).isEqualTo(new WinningLotto(lottoNumbers, new LottoNumber(15)));
    }

    @Test
    void testCase2() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> new WinningLotto(lottoNumbers, new LottoNumber(6)));
    }

    @Test
    void match_지난주_당첨번호_매칭() {

        List<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        WinningLotto winningLotto = new WinningLotto(lottoNumbers, new LottoNumber(7));

        LottoMatch match = winningLotto.match(new Lotto(lottoNumbers));

        assertThat(match).isEqualTo(LottoMatch.RANK_FIRST);
    }

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
