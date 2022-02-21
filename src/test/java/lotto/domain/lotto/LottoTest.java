package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또넘버의_개수는_6개를_넘으면_안된다() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6),
            new LottoNumber(7)
        );

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 넘버는 6개여야 합니다.");
    }

    @Test
    void 로또넘버에는_중복이_없어야_한다() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(4),
            new LottoNumber(4)
        );

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 넘버에 중복이 있습니다.");
    }
}
