package lottoauto;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class LottoTest {
    private Lotto lotto;
    LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    @DisplayName("로또의 선택 숫자 vaild 테스트")
    void new_lotto_test(){
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(4);
        lottoNumbers.add(11);
        lottoNumbers.add(12);
        lottoNumbers.add(40);
        lottoNumbers.add(45);
        assertThatThrownBy(() -> lotto = new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 숫자는 6개 입니다.");
    }

    /**
     * 1~45까지 숫자만 허용
     */
    @Test
    @DisplayName("로또 숫자 범위 테스트")
    void lotto_number_valid_test(){
        lotto = new Lotto(lottoGenerator.makeLotto());
        AssertionsForClassTypes.assertThat(lotto.getNumbers().get(0)).isLessThanOrEqualTo(45);
        AssertionsForClassTypes.assertThat(lotto.getNumbers().get(0)).isGreaterThanOrEqualTo(1);
    }

    /**
     * 숫자 정렬 확인
     */
    @Test
    @DisplayName("로또 숫자 정렬 테스트")
    void lotto_number_sort_test(){
        lotto = new Lotto(lottoGenerator.makeLotto());
        AssertionsForClassTypes.assertThat(lotto.getNumbers().get(0) <= lotto.getNumbers().get(1)).isTrue();
    }

}