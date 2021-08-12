package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    @DisplayName("로또 자동 1개(번호 6개)생성 성공 테스트")
    void 로또_자동_생성_테스트() {
        Lotto lotto = new Lotto(new LottoRandomNumbers());
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }
}
