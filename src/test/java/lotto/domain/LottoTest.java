package lotto.domain;

import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또등수")
    @Test
    void 로또등수() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 8, 9, 11));
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningLottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 8, 9, 10));
        int bonusNumber = 13;
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);
        assertThat(lotto.getLottoResult(winningLotto)).isEqualTo(THIRD);
    }

    @DisplayName("로또2등")
    @Test
    void 로또2등() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 8, 9, 11));
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningLottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 9, 11, 12));
        int bonusNumber = 8;
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);
        assertThat(lotto.getLottoResult(winningLotto)).isEqualTo(SECOND);
    }

    @DisplayName("로또 발행시 로또 번호가 6개가 아닌 경우 에러")
    @Test
    void 로또_발행시_6개_아닐시_에러() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        assertThatThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 정렬")
    @Test
    void 로또번호_정렬() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 11, 8, 5, 7, 9));
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 5, 7, 8, 9, 11)));
    }

    @DisplayName("보너스 번호 일치 여부 확인")
    @Test
    void 보너스_번호_일치_확인() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto = new Lotto(numbers);
        int bonusNumber = 7;
        assertThat(lotto.isNumberContain(bonusNumber)).isTrue();
    }


    @DisplayName("중복 번호 있을 시 에러")
    @Test
    void 중복_에러() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto = new Lotto(numbers);
        assertThatThrownBy(() -> {
            lotto.validateDuplicate(1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
