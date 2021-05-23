package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.common.ErrorCode;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    private final List<LottoNumber> defaultLottoNumbers = Arrays.asList(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
    );


    @Test
    @DisplayName("로또 티켓 길이 테스트")
    void lottoTicket_shouldBeSix() {
        // success
        assertThat(new LottoTicket(defaultLottoNumbers)).isInstanceOf(LottoTicket.class);

        // failed
        List<LottoNumber> failLottoNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
        );

        assertThatThrownBy(()->new LottoTicket(failLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_LOTTO_NUMBER_LENGTH.getErrorMessage());
    }

    @Test
    @DisplayName("로또 티켓 정렬 테스트")
    void lottoTicket_shouldBeInOrder() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(2), new LottoNumber(1), new LottoNumber(4),
                new LottoNumber(3), new LottoNumber(6), new LottoNumber(5)
        ));

        LottoNumber[] lottoNumbers = lottoTicket.toArray();

        for(int i=0; i<lottoNumbers.length-1; i++) {
            assertThat(lottoNumbers[i].compareTo(lottoNumbers[i+1]) < 0).isTrue();
        }
    }

    @Test
    @DisplayName("로또 티켓 중복 테스트")
    void lottoTicket_throwDuplicatedLottoNumber() {
        assertThatThrownBy(()->new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5)
        ))).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorCode.DUPLICATED_LOTTO_NUMBER.getErrorMessage());


    }
}
