package lotto.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTests {
    List<LottoNumber> values = new ArrayList<>();

    @BeforeEach
    public void setup() {
        IntStream.rangeClosed(1, 6).forEach(num -> values.add(LottoNumber.create(num)));
    }

    @DisplayName("길이가 6인 LottoNumber 리스트로 객체를 생성할 수 있다.")
    @Test
    void createLottoNumbersTest() {
        LottoTicket lottoTicket = LottoTicket.create(values);
        assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @DisplayName("길이가 6이 아닌 LottoNumber 리스트로는 객체를 생성할 수 없다.")
    @Test
    void createLottoNumbersValidationTest() {
        assertThatThrownBy(() ->
                LottoTicket.create(
                        Collections.singletonList(LottoNumber.create(1))
                ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사이드 이펙트가 없어야 한다")
    @Test
    void isSideEffectFreeTest() {
        LottoTicket lottoTicket = LottoTicket.create(values);
        values.add(LottoNumber.create(45));
        assertThat(lottoTicket.size()).isNotEqualTo(7);
    }

    @DisplayName("동등성 비교가 가능해야 한다.")
    @Test
    void equalTest() {
        // 일급 객체의 동등성 비교가 있기 때문에 일급 콜렉션 비교도 반복문 없이 구현이 가능한 것인지 확인 필요(이펙티브 자바 참고)
        List<LottoNumber> values2 = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(num -> values2.add(LottoNumber.create(num)));

        LottoTicket lottoTicket1 = LottoTicket.create(values);
        LottoTicket lottoTicket2 = LottoTicket.create(values2);
        assertThat(lottoTicket1).isEqualTo(lottoTicket2);
    }

    @DisplayName("리스트 형태를 toString으로 보여줄 수 있어야 한다.")
    @Test
    void toStringTest() {
        LottoTicket lottoTicket = LottoTicket.create(values);
        assertThat(lottoTicket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
