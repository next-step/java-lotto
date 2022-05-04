package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_생성_간_범위를_벗어난_경우() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(1)
                    , new LottoNumber(0)
                    , new LottoNumber(3)
                    , new LottoNumber(7)
                    , new LottoNumber(8)
                    , new LottoNumber(9)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_6개_미만으로_생성_시도할_경우() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(1)
                    , new LottoNumber(2)
                    , new LottoNumber(3)
                    , new LottoNumber(7)
                    , new LottoNumber(9)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨번호_비교() {
        assertThat(new Lotto(Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6)))
                .compareSameNumberList(new Lotto(Arrays.asList(new LottoNumber(1)
                        , new LottoNumber(2)
                        , new LottoNumber(3)
                        , new LottoNumber(4)
                        , new LottoNumber(5)
                        , new LottoNumber(6))))).hasSize(6);
    }

}