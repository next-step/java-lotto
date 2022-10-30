package step2.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsFactoryTest {

    @Test
    void 로또_티켓들을_생성할_수_있다() {
        int price = 1000;
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));

        LottoTicketsFactory lottoTicketsFactory = new LottoTicketsFactory(price, numbersGenerator);

        List<LottoTicket> lottoTickets = List.of(LottoTicket.from(numbersGenerator));
        assertThat(lottoTicketsFactory.lottoTickets()).isEqualTo(new LottoTickets(lottoTickets, price));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            999,
            1001
    })
    void 천원_단위가_아니거나_천원_미만인_금액일_경우_예외가_발생한다(int price) {
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new LottoTicketsFactory(price, numbersGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액이 천원 단위가 아니거나 천원 미민일 수 없습니다.");
    }
}
