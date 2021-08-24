package edu.nextstep.lottobonusnumber.domain.ticketmaker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoNumbersMakerTest {

    @Test
    @DisplayName("숫자 List 생성 Test")
    void create() {
        // given
        NumbersMaker numbersMaker = new AutoNumbersMaker(){
            @Override
            protected void shuffleNumbers() {
            }
        };

        // when
        List<Integer> numbers = numbersMaker.create();

        // then
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
