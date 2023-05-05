package lotto.domain;

import lotto.domian.Lotto;
import lotto.domian.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoTest {

    @DisplayName("로또 숫자가 중복이 되면 예외가 발생한다.")
    @Test
    public void lotto_DuplicateNumber_ThrowException() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1)   // todo - 테스트 쉽도록 리팩토링 하기
                                                        , new LottoNumber(2)
                                                        , new LottoNumber(3)
                                                        , new LottoNumber(4)
                                                        , new LottoNumber(5)
                                                        , new LottoNumber(5));
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lottoNumbers));
    }

}
