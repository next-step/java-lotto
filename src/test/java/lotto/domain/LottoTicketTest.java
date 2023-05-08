package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @Test
    void constructor_정상() throws Exception {
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when

        //then
        assertDoesNotThrow(() -> {
            new LottoTicket(lottoNumbers);
        });
    }

    @Test
    void constructor_예외() throws Exception {
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5);
        //when

        //then
        assertThatThrownBy(() -> {
            new LottoTicket(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6자리 입니다.");
    }

    @Test
    void calculateSameNumberCount() throws Exception {
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTicket otherLottoTicket =
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 8, 9));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);


        //when
        int count = lottoTicket.calculateSameNumberCount(otherLottoTicket);

        //then
        assertThat(count).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void hasNumber(int number, boolean expected) throws Exception {
        //given
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.of(number);

        //when
        boolean result = lottoTicket.hasNumber(lottoNumber);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
