package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.fixture.LottoFixture.createOneToSixLottoNumberSequence;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.*;

class ManaualLottosTest {

    @DisplayName("LottoNumber 6개 이면 ManaualLottos 객체를 만든다")
    @Test
    public void should_make_object_with_count_6_lotto_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = createOneToSixLottoNumberSequence();

        Lotto lotto = Lotto.of(LottoNumbers.of(lottoNumbers));

        //act
        ManaualLottos lottos = ManaualLottos.of(Arrays.asList(lotto));

        //assert
        assertThat(lottos.size()).isEqualTo(1);
    }

    @DisplayName("LottoNumber 6개 보다작으면 IllegalStateException을 리턴한다")
    @Test
    public void should_throw_exception_under_count_6_lotto_number() throws Exception {
        //arrange, act, assert
        assertThatIllegalStateException().isThrownBy(() -> ManaualLottos.of(null));
    }

    @DisplayName("LottoNumber 6개 보다작으면 IllegalStateException을 리턴한다")
    @Test
    public void should_throw_exception_under_count_6_lotto_number_2() throws Exception {
        //arrange, act, assert
        assertDoesNotThrow(() -> ManaualLottos.of(new ArrayList<>()));
    }

}