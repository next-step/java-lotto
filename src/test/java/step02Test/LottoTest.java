package step02Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.InputNumberRule;
import step02.LottoNumbers;
import step02.LottoResultDTO;
import step02.Lottos;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("입력한 만큼 로또가 생성되는지 확인")
    void lottoCount() {
        Lottos lotto = new Lottos(4);
        assertThat(lotto.getLottoCount().getCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("3,4,5,6개 매칭되는 개수 테스트")
    void compareMathNumber() throws Exception {
        Lottos lottos = new Lottos(1);
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 27, 39, 43"));
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 39, 43"));
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 40, 43"));
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 40, 44"));
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 40, 44"));
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 40, 44"));
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 40, 44"));
        LottoResultDTO dto = lottos.compareMatchNumber(new LottoNumbers(new InputNumberRule("7, 8, 10, 20, 40, 44")));
        assertThat(dto.getMath3()).isEqualTo(1);
        assertThat(dto.getMath4()).isEqualTo(1);
        assertThat(dto.getMath5()).isEqualTo(1);
        assertThat(dto.getMath6()).isEqualTo(4);
    }
}
