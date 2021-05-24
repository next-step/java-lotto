package lotto.domain;

import lotto.common.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketGeneratorTest {

    @Test
    @DisplayName("로또 티켓 생성 테스트")
    void generateLottoTicket() {
        LottoTicket lottoTicket = new LottoTicketGenerator().generate();

        //로또 티켓은 NULL 일 수 없다.
        assertThat(new LottoTicketGenerator().generate()).isNotNull();
        
        //정렬 테스트
        LottoNumber[] lottoNumbers = lottoTicket.toArray();
        for(int i=0; i<lottoNumbers.length-1; i++) {
            assertThat(lottoNumbers[i].compareTo(lottoNumbers[i+1]) < 0).isTrue();
        }

        //길이 테스트
        assertThat(lottoNumbers.length).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 중복 테스트")
    void lottoNumbers_shouldThrowDuplicatedException() {
        assertThatThrownBy(()->new LottoTicketGenerator().generate("1,1,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATED_LOTTO_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("로또 번호 길이 테스트")
    void lottoNumbers_shouldThrowInvalidLengthException() {
        assertThatThrownBy(() -> new LottoTicketGenerator().generate("1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_LOTTO_NUMBER_LENGTH.getErrorMessage());
    }
}
