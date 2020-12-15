package lotto;

import lotto.domain.FixedNumberListGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCollectionTest {

    private LottoCollection lottoCollection;

    @BeforeEach
    void setUp() {
        lottoCollection = new LottoCollection(14, new FixedNumberListGenerator());
    }

    @Test
    @DisplayName("출력을 위한 로또 번호 조회가 제대로 들어가는지 테스트")
    void lottoCollectionTest() {
        assertThat(lottoCollection.getLottoNumbers(0)).containsExactlyInAnyOrder(8, 21, 23, 41, 42, 43);
        assertThat(lottoCollection.getLottoNumbers(1)).containsExactlyInAnyOrder(3, 5, 11, 16, 32, 38);
        assertThat(lottoCollection.getLottoNumbers(2)).containsExactlyInAnyOrder(7, 11, 16, 35, 36, 44);
        assertThat(lottoCollection.getLottoNumbers(8)).containsExactlyInAnyOrder(1, 3, 5, 14, 22, 45);
        assertThat(lottoCollection.getLottoNumbers(13)).containsExactlyInAnyOrder(3, 8, 27, 30, 35, 43);
    }

    @Test
    @DisplayName("전체 로또 뽑은 갯수가 맞는지 확인하는 테스트")
    void getLottoCountTest() {
        assertThat(lottoCollection.getLottoCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("당첨 번호와 비교하는 테스트")
    void getSameNumberCountTest() {
        Lotto winnerLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoResult lottoResult = lottoCollection.getLottoResult(winnerLotto);
        assertThat(lottoResult.getSameLottoCount(3)).isEqualTo(1);

        winnerLotto = new Lotto(1, 2, 3, 4, 5, 14);
        lottoResult = lottoCollection.getLottoResult(winnerLotto);
        assertThat(lottoResult.getSameLottoCount(4)).isEqualTo(1);
    }
}