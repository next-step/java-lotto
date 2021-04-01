package step022Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step022.Lottos;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("입력한 만큼 로또가 생성되는지 확인")
    void lottoCount() {
        Lottos lotto = new Lottos(4);
        assertThat(lotto.getLottoCount().getCount()).isEqualTo(4);
    }
}
