package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoMachineTest {
    LottoMachine lottoMachine;
    Lottos lottos;
    List<Integer> winningNums;

    @BeforeEach
    void initializeLottoSimulation() {
        List<Lotto> lottoList = new ArrayList<>(
                Arrays.asList(
                        new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                        new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                        new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                        new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                        new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                        new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                        new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                        new Lotto(Arrays.asList(23, 25, 33, 36, 39, 41)),
                        new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)),
                        new Lotto(Arrays.asList(5, 9, 38, 41, 43, 44)),
                        new Lotto(Arrays.asList(2, 8, 9, 18, 19, 21)),
                        new Lotto(Arrays.asList(13, 14, 18, 21, 23, 35)),
                        new Lotto(Arrays.asList(17, 21, 29, 37, 42, 45)),
                        new Lotto(Arrays.asList(3, 8, 27, 30, 35, 44))
                )
        );

        lottos = new Lottos(lottoList);
        winningNums = new ArrayList<>(Arrays.asList(5, 11, 16, 44, 42, 2, 38));
        lottoMachine = new LottoMachine(14500, new GenerateNumStrategy() {
            @Override
            public Lottos generate(int totalLottoNum, int numsPerLotto) {
                return lottos;
            }
        });
    }

    @Test
    void buyableLottos_살_수_있는_로또_개수_환산() {
        int money = 14500;
        int lottoCount = 14;

        LottoMachine lottoMachine = new LottoMachine(money);
        assertThat(lottoMachine.buyableLottos()).isEqualTo(lottoCount);
    }

    @Test
    void generateNums_생성_Strategy에_따라_번호_생성() {
        int totalLottosNum = 5;
        Random random = new Random();

        Integer[][] nums = new Integer[totalLottosNum][AutoGenerateStrategy.NUMS_PER_LOTTO];
        for (int i = 0; i < totalLottosNum; i++) {
            for (int j = 0; j < LottoMachine.NUMS_PER_LOTTO; j++) {
                nums[i][j] = random.nextInt(LottoMachine.LOTTO_MAX_NUM) + 1;
            }
        }

        List<Lotto> lottoList = new ArrayList<>(totalLottosNum);
        for (int i = 0; i < totalLottosNum; i++) {
            lottoList.add(new Lotto(Arrays.asList(nums[i])));
        }

        Lottos lottos = new Lottos(lottoList);

        List<Lotto> lottoList1 = new ArrayList<>(totalLottosNum);
        for (int i = 0; i < totalLottosNum; i++) {
            lottoList1.add(new Lotto(Arrays.asList(nums[i])));
        }

        LottoMachine lottoMachine = new LottoMachine(new GenerateNumStrategy() {
            @Override
            public Lottos generate(int totalLottoNum, int numsPerLotto) {
                return new Lottos(lottoList1);
            }
        });

        assertThat(lottoMachine.generateLottos()).isEqualTo(lottos);
    }

    @Test
    void countLottoGrades_로또_당첨_개수_출력() {
        WinningResult winningResult = lottoMachine.countLottoPrize(winningNums);
        assertThat(winningResult).isEqualTo(new WinningResult(Arrays.asList(0, 0, 1, 3)));
    }

    @Test
    void getTotalPrizeMoney_총_상금_계산() {
        assertThat(lottoMachine.getTotalPrizeMoney(winningNums)).isEqualTo(65000);
    }

    @Test
    void getYield_수익률_계산() {
        assertThat(lottoMachine.getYield(winningNums)).isEqualTo(65000.0/14500.0);
    }
}
