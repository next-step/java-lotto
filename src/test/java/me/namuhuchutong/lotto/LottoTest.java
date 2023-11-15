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

    private static final String[] EMPTY_MANUAL_LOTTO= {};

    @DisplayName("일치하는 번호 수에 맞게 총 상금을 반환한다.")
    @Test
    void get_total_price_from_matching_number() {
        //given
        TestGenerator alwaysSixMatch = new TestGenerator();
        Lotto lotto = Lotto.create(1, alwaysSixMatch, EMPTY_MANUAL_LOTTO);
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
        Number bonus = new Number(7);

        // when
        LottoResult matchNumbers = lotto.getMatchNumbers(numbers1, bonus);
        long result = matchNumbers.getWinnings(minimumCount);

        //then
        assertThat(result).isEqualTo(LottoWinnings.SIX.getWinnings());
    }

    @DisplayName("자동, 수동 로또의 수는 총 로또의 수와 같다.")
    @Test
    void total_lotto_counts_is_same_as_auto_and_manual_lotto_counts() {
        //given
        TestGenerator alwaysSixMatch = new TestGenerator();
        String[] manualLotto = {"7, 8, 9, 10, 11, 12"};
        int times = 2;
        List<Number> given = List.of(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)
        );
        Numbers lastWinningNumber = new Numbers(given);
        Number bonus = new Number(7);
        Lotto lotto = Lotto.create(times, alwaysSixMatch, manualLotto);

        //when
        LottoResult matchNumbers = lotto.getMatchNumbers(lastWinningNumber, bonus);

        //then
        assertThat(matchNumbers.size()).isEqualTo(2);
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
