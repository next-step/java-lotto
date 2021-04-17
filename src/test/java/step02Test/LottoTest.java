package step02Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.dto.LottoResultDTO;
import step02.model.lotto.LottoNumber;
import step02.model.lotto.LottoNumbers;
import step02.model.lotto.Lottos;
import step02.model.numberRule.InputNumberRule;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lottos lottos = new Lottos(1);
    LottoResultDTO dto = new LottoResultDTO();

    @Test
    @DisplayName("1등 테스트 - 6개 일치")
    void rankFirstMatching() {
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 40, 44"));
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 40, 44"));
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 40, 44"));
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 40, 44"));
        dto.setRanks(lottos.compareMatchNumber(new LottoNumbers(new InputNumberRule("7, 8, 10, 20, 40, 44")), new LottoNumber(30)));

        assertThat(dto.getRankFirstCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("2등 테스트 - 5개 일치 + 보너스 넘버 일치")
    void rankSecondMatching() {
        Lottos lottos = new Lottos(1);
        LottoResultDTO dto = new LottoResultDTO();
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 40, 30"));
        dto.setRanks(lottos.compareMatchNumber(new LottoNumbers(new InputNumberRule("7, 8, 10, 20, 40, 44")), new LottoNumber(30)));


        assertThat(dto.getRankSecondCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("3등 테스트 - 5개 일치")
    void rankThirdMatching() {
        Lottos lottos = new Lottos(1);
        LottoResultDTO dto = new LottoResultDTO();
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 40, 21"));

        dto.setRanks(lottos.compareMatchNumber(new LottoNumbers(new InputNumberRule("7, 8, 10, 20, 40, 44")), new LottoNumber(30)));

        assertThat(dto.getRankThirdCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("4등 테스트 - 4개 일치")
    void rankFourthMatching() {
        Lottos lottos = new Lottos(1);
        LottoResultDTO dto = new LottoResultDTO();
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 20, 11, 21"));
        dto.setRanks(lottos.compareMatchNumber(new LottoNumbers(new InputNumberRule("7, 8, 10, 20, 40, 44")), new LottoNumber(30)));

        assertThat(dto.getRankFourthCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("5등 테스트 - 3개 일치")
    void rankFifthMatching() {
        Lottos lottos = new Lottos(1);
        LottoResultDTO dto = new LottoResultDTO();
        lottos.makeLotto(new InputNumberRule("7, 8, 10, 27, 11, 21"));
        dto.setRanks(lottos.compareMatchNumber(new LottoNumbers(new InputNumberRule("7, 8, 10, 20, 40, 44")), new LottoNumber(30)));

        assertThat(dto.getRankFifthCount()).isEqualTo(1);
    }
}
