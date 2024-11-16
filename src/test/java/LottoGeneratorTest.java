import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void gen_lotto(){
        Lotto newLotto = lottoGenerator.generate();

        assertThat(newLotto.numCount()).isEqualTo(6);
    }

    @Test
    void gen_lotto_with_nums(){
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        Lotto new_lotto = lottoGenerator.generate(nums);

        assertThat(new_lotto.numCount()).isEqualTo(6);
        assertThat(new_lotto.has(1)).isTrue();
        assertThat(new_lotto.has(6)).isTrue();
        assertThat(new_lotto.has(7)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
        "100, 0",
        "1000, 1",
        "5000, 5",
        "14000, 14",
        "15500, 15"
    })
    void gen_lotto_match_to_money(int money, int lottoCount){
        assertThat(lottoGenerator.generate(money)).hasSize(lottoCount);
    }
}
