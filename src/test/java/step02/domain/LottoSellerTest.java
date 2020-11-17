package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoSellerTest {

    @DisplayName("로또판매기 생성자")
    @Test
    public void test_LottoSeller_Construct() {
        assertThat(LottoSeller.of(1000)).isEqualTo(LottoSeller.of(1000));
    }

    @DisplayName("지불받은 만큼 로또를 생성할 때 에러가 없는지 검사")
    @Test
    public void test_generateLottos() {
        LottoSeller lottoSeller = LottoSeller.of(1000);
        LottoNumbers lottoNumbers  = LottoNumbers.of(1, 46);
        assertThatCode(() -> lottoSeller.generateLottos(10100, lottoNumbers))
                .doesNotThrowAnyException();
    }

}
