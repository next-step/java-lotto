package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoBunchTest {

    @DisplayName("LottoNUmber 6개 이면 Lotto 객체를 만든다")
    @Test
    public void should_make_object_with_count_6_lotto_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        Lotto lotto = Lotto.of(lottoNumbers);

        //act
        LottoBunch lottoBunch = LottoBunch.of(Arrays.asList(lotto));

        //assert
        assertAll(
                () -> assertThat(lottoBunch.getAllLottoCount()).isEqualTo(1),
                () -> assertThat(lottoBunch.getLottos()).contains(lotto)
        );
    }

    @DisplayName("LottoNUmber 6개 보다작으면 IllegalArgumentException을 리턴한다")
    @Test
    public void should_throw_exception_empty_lotto_list() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LottoBunch.of(new ArrayList<>()));
    }

    @DisplayName("LottoNUmber 6개 보다작으면 IllegalArgumentException을 리턴한다")
    @Test
    public void should_throw_exception_null_lotto_list() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LottoBunch.of(null));
    }

}