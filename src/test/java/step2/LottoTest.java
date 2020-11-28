package step2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {

    @Test
    void createTest() {
        Generator lottoGenerator = new LottoGenerator();
        lottoGenerator.setNumber("");
        Lotto lotto = new Lotto(lottoGenerator);
        assertThat(lotto.numberList.size()).isEqualTo(6);
    }

    @Test
    void checkRewardTest() {
        Generator fixedNumberGenerator = new FixedNumberGenerator();
        fixedNumberGenerator.setNumber("1,3,5,7,9,11");

        Lotto lotto = new Lotto(fixedNumberGenerator);
        String resultInput = "1, 3, 5, 6, 8, 10";

        List<Integer> result = new ArrayList<>();

        for (String i : resultInput.split(", ")) {
            result.add(Integer.parseInt(i));
        }

        assertThat(lotto.checkReward(result)).isEqualTo(3);
    }
}
