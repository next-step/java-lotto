package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static lotto.domain.Lotto.IS_NOT_LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {
    @DisplayName("로또 발행시 로또 번호가 6개가 아닌 경우 에러")
    @Test
    void 로또_발행시_6개_아닐시_에러() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        assertThatThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IS_NOT_LOTTO_SIZE);
    }

    @DisplayName("로또 번호 정렬")
    @Test
    void 로또번호_정렬() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 11, 8, 5, 7, 9));
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> lottoList = lotto.getLottoNumbers();
        assertAll(
                () -> assertThat(lottoList.get(0)).isEqualTo(1),
                () -> assertThat(lottoList.get(1)).isEqualTo(5),
                () -> assertThat(lottoList.get(2)).isEqualTo(7),
                () -> assertThat(lottoList.get(3)).isEqualTo(8),
                () -> assertThat(lottoList.get(4)).isEqualTo(9),
                () -> assertThat(lottoList.get(5)).isEqualTo(11)
        );
    }

    @DisplayName("로또번호 일치 갯수")
    @Test
    void 로또번호_일치갯수() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 8, 9, 11));
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningLottoNumbers = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 10));
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        assertThat(lotto.getLottoResult(winningLotto)).isEqualTo(4);
    }

    @DisplayName("당첨 로또 생성")
    @Test
    void 당첨로또() {
        String winning = "1,2,6,4,5,3";
        Lotto lotto = new Lotto(winning);
        List<Integer> lottoList = lotto.getLottoNumbers();
        assertAll(
                () -> assertThat(lottoList.get(0)).isEqualTo(1),
                () -> assertThat(lottoList.get(1)).isEqualTo(2),
                () -> assertThat(lottoList.get(2)).isEqualTo(3),
                () -> assertThat(lottoList.get(3)).isEqualTo(4),
                () -> assertThat(lottoList.get(4)).isEqualTo(5),
                () -> assertThat(lottoList.get(5)).isEqualTo(6)
        );
    }
}
