package edu.nextstep.lottoauto.strategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class AutoNumberMakerTest {

    @BeforeEach
    void initTotalNumbers(){
        AutoNumberMaker.sortTotalNumbers();
    }

    @Test
    void makeNumbers() {
        // given
        AutoNumberMaker autoNumberMaker = new AutoNumberMaker(){
            @Override
            protected void flushingTotalNumbers() {
            }
        };

        // when
        List<Integer> numbers = autoNumberMaker.makeNumbers();

        // then
        Assertions.assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);

    }

}