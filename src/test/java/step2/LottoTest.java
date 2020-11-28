package step2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {

    @Test
    void createTest() {
        Machine numberMachine = new NumberMachine();
        numberMachine.setNumber("");
        Lotto lotto = new Lotto(numberMachine);
        assertThat(lotto.numberList.size()).isEqualTo(6);
    }

    @Test
    void checkRewardTest() {
        Machine fixedMachine = new FixedMachine();
        fixedMachine.setNumber("1,3,5,7,9,11");

        Lotto lotto = new Lotto(fixedMachine);
        String resultInput = "1, 3, 5, 6, 8, 10";

        List<Integer> result = new ArrayList<>();

        for (String i : resultInput.split(", ")) {
            result.add(Integer.parseInt(i));
        }

        assertThat(lotto.checkReward(result)).isEqualTo(3);
    }
}
