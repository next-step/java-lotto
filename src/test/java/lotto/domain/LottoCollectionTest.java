package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCollectionTest {

    private LottoCollection lottoCollection;

    @BeforeEach
    void setUp() {
        lottoCollection = new LottoCollection(14000, new FixedLottoNumbersGenerator());
    }

    @Test
    @DisplayName("출력을 위한 로또 번호 조회가 제대로 들어가는지 테스트")
    void lottoCollectionTest() {
        List<Lotto> lottoList = lottoCollection.getLottos();
        assertThat(lottoList.get(0).getNumbers()).isEqualTo(FixedLottoNumbersGenerator.convertNumberSet(8, 21, 23, 41, 42, 43));
        assertThat(lottoList.get(1).getNumbers()).isEqualTo(FixedLottoNumbersGenerator.convertNumberSet(3, 5, 11, 16, 32, 38));
        assertThat(lottoList.get(2).getNumbers()).isEqualTo(FixedLottoNumbersGenerator.convertNumberSet(7, 11, 16, 35, 36, 44));
        assertThat(lottoList.get(8).getNumbers()).isEqualTo(FixedLottoNumbersGenerator.convertNumberSet(1, 3, 5, 14, 22, 45));
        assertThat(lottoList.get(13).getNumbers()).isEqualTo(FixedLottoNumbersGenerator.convertNumberSet(3, 8, 27, 30, 35, 43));
    }

    @Test
    @DisplayName("전체 로또 뽑은 갯수가 맞는지 확인하는 테스트")
    void getLottoCountTest() {
        List<Lotto> lottoList = lottoCollection.getLottos();
        assertThat(lottoList.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("당첨 번호와 비교하는 테스트")
    void getSameNumberCountTest() {
        Lotto winnerLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(7);
        LottoResult lottoResult = lottoCollection.getLottoResult(winnerLotto, bonusNumber);
        assertThat(lottoResult.getSameLottoCount(3)).isEqualTo(1);

        winnerLotto = new Lotto(1, 2, 3, 4, 5, 14);
        lottoResult = lottoCollection.getLottoResult(winnerLotto, bonusNumber);
        assertThat(lottoResult.getSameLottoCount(4)).isEqualTo(1);
    }
}