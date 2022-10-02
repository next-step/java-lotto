package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또에 중복값이 있으면 에러")
    void lotto_number_when_duplicate() {
        //given
        String[] lottoNumber = {"1", "1", "3", "12", "1", "18"};
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lottoNumber));
    }

    @Test
    @DisplayName("로또에 중복값이 없으면 정상")
    void lotto_number_when_normal() {
        //given
        String[] lottoNumber = {"10", "23", "44", "1", "3", "19"};
        //then
        assertThatNoException()
                .isThrownBy(() -> new Lotto(lottoNumber));
    }

    @Test
    @DisplayName("로또 숫자가 6개 이상 입력되면 에러")
    void lotto_number_count_when_over_6() {
        //given
        String[] lottoNumber = {"1", "2", "3", "4", "5", "6", "7"};
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lottoNumber));
    }

    @Test
    @DisplayName("로또 숫자가 6개 미만 입력되면 에러")
    void lotto_number_count_when_less_6() {
        //given
        String[] lottoNumber = {"1", "2", "3", "4", "5"};
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lottoNumber));
    }

    @Test
    @DisplayName("서로 같은 숫자의 개수 구하기")
    void count_distinct_number() {
        //given
        String[] lottoNumbers1 = "1,2,3,4,5,6".split(",");
        String[] lottoNumbers2 = "7,8,1,3,2,9".split(",");

        Lotto lotto1 = new Lotto(lottoNumbers1);
        Lotto lotto2 = new Lotto(lottoNumbers2);
        //then
        assertThat(lotto1.numberOfEquals(lotto2)).isEqualTo(3);
    }

}
