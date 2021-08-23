package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoMachineTest {
    @Test
    void buyableLottos_살_수_있는_로또_개수_환산() {
        int money = 14500;
        int lottoCount = 14;

        LottoMachine lottoMachine = new LottoMachine(money);
        assertThat(lottoMachine.buyableLottos()).isEqualTo(lottoCount);
    }

    @Test
    void generateNums_생성_Strategy에_따라_번호_생성() {
        LottoMachine lottoMachine = new LottoMachine();
        Random random = new Random();
        List<Integer> numList = new ArrayList<>(LottoMachine.LOTTO_NUM_COUNT);

        for (int i = 0; i < LottoMachine.LOTTO_NUM_COUNT; i++) {
            numList.add(random.nextInt(LottoMachine.LOTTO_MAX_NUM));
        }

        assertThat(lottoMachine.generateNums(new GenerateNumStrategy() {
            @Override
            public List<Integer> generate() {
                return numList;
            }
        })).isEqualToComparingFieldByField(numList);
    }
}
