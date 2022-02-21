package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @ValueSource(ints = {2000, 3000, 4000})
    @ParameterizedTest
    void 구입금액에_맞는_로또를_랜덤방식으로_발급한다(final int number) {
        final Lotto lotto = new Lotto(number, new RandomNumberStrategy());
        final List<LottoTicket> generatedTickets = lotto.getLottoTickets();

        long given = generatedTickets.stream().distinct().count();
        assertThat(given).isEqualTo(number / 1000);
    }

    @Test
    void 숫자1부터6까지만_사용하는_방식으로_바꿔_로또티켓을_발급한다() {
        final int price = 1000;
        final LottoTicket compare = new LottoTicket(1, 2, 3, 4, 5, 6);

        final Lotto lotto = new Lotto(price, () -> IntStream.range(1, 7)
            .mapToObj(LottoNumber::from).collect(Collectors.toList()));
        final List<LottoTicket> generatedTickets = lotto.getLottoTickets();

        assertThat(generatedTickets.get(0).toString()).hasToString(compare.toString());
    }

    @Test
    void 구매한_로또티켓은_중복된_수로_구성될_수_없다() {
        final int number = 1000;
        final List<LottoNumber> compare = Arrays.asList(
            LottoNumber.from(1),
            LottoNumber.from(1),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
            new Lotto(number, () -> compare)
        );

    }
}
