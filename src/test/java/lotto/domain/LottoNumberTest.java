package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    private LottoNumber lottoNumber;

    @BeforeEach
    void init() {
        lottoNumber = new LottoNumber(new RandomNumberCreation());
    }

    @Test
    void constructor_정상() throws Exception {
        //given
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when

        //then
        assertDoesNotThrow(() -> {
            new LottoNumber(lottoNumber);
        });
    }

    @Test
    void constructor_예외() throws Exception {
        //given
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5);
        //when

        //then
        assertThatThrownBy(() -> {
            new LottoNumber(lottoNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6자리입니다.");
    }

    @Test
    void calculateSameNumberCount() throws Exception {
        //given
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoNumber otherLottoNumber =
                new LottoNumber(Arrays.asList(1, 2, 3, 4, 8, 9));
        this.lottoNumber = new LottoNumber(lottoNumber);


        //when
        int count = this.lottoNumber.calculateSameNumberCount(otherLottoNumber);

        //then
        assertThat(count).isEqualTo(4);
    }
}
