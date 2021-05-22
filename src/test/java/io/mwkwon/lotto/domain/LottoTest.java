package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.domain.Lotto;
import io.mwkwon.lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 자동으로_로또_번호_생성_기능_테스트() {
        Lotto lotto = Lotto.createAutoLotto();
        assertThat(lotto.getLottoNumbers()).isNotNull();
        assertThat(lotto.getLottoNumbers()).isNotEmpty();
    }

    @Test
    void 중복된_로또_번호가_포함된_경우_에러_정상_발생_여부_테스트() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(5));

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로다른 로또번호 6개가 아닙니다.");
    }

    @Test
    void 자동으로_생성된_로또_번호들의_사이즈가_6인지_여부_테스트() {
        Lotto lotto = Lotto.createAutoLotto();
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }
}
