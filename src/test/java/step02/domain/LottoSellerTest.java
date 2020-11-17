package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoSellerTest {

    @DisplayName("로또판매기 생성자")
    @Test
    public void test_LottoSeller_Construct() {
        assertThat(LottoSeller.of(1000)).isEqualTo(LottoSeller.of(1000));
    }

    @DisplayName("로또 개수만큼 로또를 생성해주는 기능")
    public void test_generateLottos(int lottoCount) {

    }

    @DisplayName("지불한 돈으로 로또를 몇개 살수 있는지 계산해주는 기능")
    public void test_calculateLottoCount(int payment) {

    }

    @DisplayName("6개의 랜덤번호 로또를 생성하는 기능")
    public void test_generateLotto() {

    }

}
