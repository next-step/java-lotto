package me.namuhuchutong.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import me.namuhuchutong.lotto.domain.Lotto;
import me.namuhuchutong.lotto.domain.LottoWinnings;
import me.namuhuchutong.lotto.domain.Number;
import me.namuhuchutong.lotto.domain.Numbers;
import me.namuhuchutong.lotto.domain.generator.NumberGenerator;
import me.namuhuchutong.lotto.dto.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("일치하는 번호 수에 맞게 총 상금을 반환한다.")
    @Test
    void get_total_price_from_matching_number() {
        //given
        TestGenerator alwaysSixMatch = new TestGenerator();
        Lotto lotto = Lotto.create(1, alwaysSixMatch);
        long minimumCount = 3;
        List<Number> given1 = List.of(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)
        );
        Numbers numbers1 = new Numbers(given1);
        
        // when
        LottoResult matchNumbers = lotto.getMatchNumbers(numbers1);
        long result = matchNumbers.getWinnings(minimumCount);

        //then
        assertThat(result).isEqualTo(LottoWinnings.SIX.getWinnings());
    }
    
    static class TestGenerator implements NumberGenerator {

        @Override
        public List<Number> createNumbers() {
           return List.of(
                   new Number(1),
                   new Number(2),
                   new Number(3),
                   new Number(4),
                   new Number(5),
                   new Number(6));
        }
    }
}
