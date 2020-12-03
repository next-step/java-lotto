package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void createTest() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = new Lotto(lottoGenerator);
        assertThat(lotto.numberList.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 당첨 여부 테스트")
    void checkRewardTest() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator();
        fixedNumberGenerator.setNumber("1,3,5,7,9,11");

        Lotto lotto = new Lotto(fixedNumberGenerator);
        String resultInput = "1, 3, 5, 6, 8, 10";

        List<Integer> result = new ArrayList<>();

        for (String i : resultInput.split(", ")) {
            result.add(Integer.parseInt(i));
        }
        lotto.checkReward(result);

        assertThat(lotto.getWinningCnt()).isEqualTo(3);
    }
}
