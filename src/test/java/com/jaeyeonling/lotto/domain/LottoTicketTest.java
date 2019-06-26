package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.EmptyLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTicketTest {

    @DisplayName("Lotto Ticket 생성")
    @Test
    void createLottoTicket() {
        final List<String> lottoNumbers = List.of(
                "1,2,3,4,5,6",
                "12,23,34,45,26,37",
                "3 ,4 , 5 ,  6 ,  7 , 8"
        );

        final LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        assertThat(lottoTicket).isNotNull();
    }

    @DisplayName("Lotto Ticket 생성 시 LottoNumbers null 예외처리 ")
    @ParameterizedTest
    @NullSource
    void should_throw_NullPointerException_when_invalid_lottoNumbers(final List<String> invalidLottoNumbers) {
        assertThatExceptionOfType(EmptyLottoNumberException.class)
                .isThrownBy(() -> {
                    new LottoTicket(invalidLottoNumbers);
                });
    }

}
