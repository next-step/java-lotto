package lotto.domain;

import lotto.common.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketGeneratorTest {

    @Test
    @DisplayName("로또 티켓 생성 테스트")
    void generateLottoTicket() {
        List<LottoNumber> lottoRandomNumbers = new LottoTicketGenerator().generate();
        List<LottoNumber> lottoManualNumbers = new LottoTicketGenerator().generate("2,5,4,3,6,1");

        //로또 티켓은 NULL 일 수 없다.
        assertThat(lottoRandomNumbers).isNotNull();
        assertThat(lottoManualNumbers).isNotNull();
        
        //정렬 테스트
        lottoNumbers_shouldBeInOrder(lottoRandomNumbers);
        lottoNumbers_shouldBeInOrder(lottoManualNumbers);

        //길이 테스트
        assertThat(lottoRandomNumbers.size()).isEqualTo(6);
        assertThat(lottoManualNumbers.size()).isEqualTo(6);

        //수동 티켓 생성 일치 테스트
        assertThat(lottoManualNumbers)
                .containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }

    void lottoNumbers_shouldBeInOrder(List<LottoNumber> lottoNumbers) {
        //정렬 테스트
        for(int i=0; i<lottoNumbers.size()-1; i++) {
            assertThat(lottoNumbers.get(i).compareTo(lottoNumbers.get(i+1)) < 0).isTrue();
        }
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
