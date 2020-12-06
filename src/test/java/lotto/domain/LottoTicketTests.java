package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTests {
    private List<LottoNumber> normalLottoNumbers;

    @BeforeEach
    void setup() {
        normalLottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @DisplayName("LottoNumber 컬렉션을 인자로 받아 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(new LottoTicket(normalLottoNumbers)).isEqualTo(new LottoTicket(normalLottoNumbers));
    }
}
