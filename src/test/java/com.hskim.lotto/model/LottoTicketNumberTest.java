package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketNumberTest {

    @DisplayName("LottoTicketNumber 생성 성공 테스트")
    @Test
    void create_성공() {

        // given
        LottoTicketNumber lottoTicketNumber = new LottoTicketNumber(Arrays.asList("23", "9", "17", "8", "1", "39"));

        // when & then
        assertThat(lottoTicketNumber).isEqualTo(new LottoTicketNumber(Arrays.asList("23", "9", "17", "8", "1", "39")));
    }

    @DisplayName("LottoTicketNumber 생성 실패 (지정된 갯수와 다름) 테스트")
    @Test
    void create_갯수다름_실패() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoTicketNumber(Arrays.asList("23", "17"));
        }).withMessage(LottoExceptionMessage.INVALID_NUMBER_SIZE.getMessage());
    }


    @DisplayName("LottoTicketNumber 생설 실패 (중복 숫자) 테스트")
    @Test
    void create_중복_실패() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoTicketNumber(Arrays.asList("23", "23", "17", "8", "1", "39"));
        }).withMessage(LottoExceptionMessage.DUPLICATED_NUMBER.getMessage());
    }
}
