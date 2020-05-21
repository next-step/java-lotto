package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @DisplayName("LottoNumber 리스트의 크기가 6이 아니면 IllegalArgumentException Throw")
    @Test
    void lottoTicketThrowsExceptionWhenSizeOver() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumbers))
                .withMessage("로또 번호는 6개만 가능합니다.");
    }

    @DisplayName("LottoNumber 리스트에 중복된 번호가 있으면 IllegalArgumentExceptionThrow")
    @Test
    void lottoTicketThrowsExceptionWhenDuplicateNumber() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 3, 4, 5)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumbers))
                .withMessage("로또 번호는 중복 될 수 없습니다.");
    }
}