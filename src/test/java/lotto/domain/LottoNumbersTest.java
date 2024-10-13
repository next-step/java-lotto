package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {
    @DisplayName("로또 발행시 로또 번호가 6개가 아닌 경우 에러")
    @Test
    void 로또_발행시_6개_아닐시_에러() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        assertThatThrownBy(() -> {
            new LottoNumbers(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 정렬")
    @Test
    void 로또번호_정렬() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 11, 8, 5, 7, 9));
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        assertThat(lottoNumbers.getLottoNumbers()).isEqualTo(List.of(1, 5, 7, 8, 9, 11));
    }

    @DisplayName("보너스 번호 일치 여부 확인")
    @Test
    void 보너스_번호_일치_확인() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        int bonusNumber = 7;
        assertThat(lottoNumbers.isNumberContain(bonusNumber)).isTrue();
    }

    @DisplayName("로또 번호 몇개 맞췄는지")
    @Test
    void 로또_번호_일치갯수() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        String[] winning = {"1", "2", "3", "4", "5", "6"};
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(new Lotto(winning), bonusNumber);
        assertThat(lottoNumbers.getMatchCount(winningLotto.getWinningLotto())).isEqualTo(5);
    }

    @DisplayName("중복 번호 있을 시 에러")
    @Test
    void 중복_에러() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        assertThatThrownBy(() -> {
            lottoNumbers.validateDuplicate(1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
