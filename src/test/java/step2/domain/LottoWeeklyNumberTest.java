package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWeeklyNumberTest {

    @Test
    void matchCount() {
        LottoWeeklyNumber lottoWeeklyNumber =
                new LottoWeeklyNumber("1,2,3,4,5,6", "7");
        List<LottoNumber> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            list.add(new LottoNumber(i));
        }

        assertThat(lottoWeeklyNumber.matchCount(list)).isEqualTo(6);


    }

    @Test
    void matchBonusTrue() {
        LottoWeeklyNumber lottoWeeklyNumber =
                new LottoWeeklyNumber("1,2,3,4,5,6", "7");
        assertThat(lottoWeeklyNumber.matchBonus()).isFalse();
    }

    @Test
    void matchBonusFalse() {
        LottoWeeklyNumber lottoWeeklyNumber =
                new LottoWeeklyNumber("1,2,3,4,5,6", "6");
        assertThat(lottoWeeklyNumber.matchBonus()).isTrue();
    }
}