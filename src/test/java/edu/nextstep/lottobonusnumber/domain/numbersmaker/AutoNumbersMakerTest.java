package edu.nextstep.lottobonusnumber.domain.numbersmaker;

import edu.nextstep.lottobonusnumber.domain.Ticket;
import edu.nextstep.lottobonusnumber.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


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
