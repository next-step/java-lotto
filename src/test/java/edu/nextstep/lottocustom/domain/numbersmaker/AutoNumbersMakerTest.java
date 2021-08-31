package edu.nextstep.lottocustom.domain.numbersmaker;

import edu.nextstep.lottocustom.domain.LottoNumber;
import edu.nextstep.lottocustom.domain.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AutoNumbersMakerTest {

    @Test
    @DisplayName("numbers 생성")
    void create() {
        // given
        NumbersMaker numbersMaker = new AutoNumbersMaker();

        // when
        List<LottoNumber> numbers = numbersMaker.create();

        // then
        assertThat(numbers.size()).isEqualTo(Ticket.LENGTH_OF_NUMBERS);
        assertThat(numbers.get(0)).isInstanceOf(LottoNumber.class);
    }
}
