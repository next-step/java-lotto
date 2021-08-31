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
        winningNums = new ArrayList<>(Arrays.asList(5, 11, 9, 43, 41, 2, 38));
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
        assertThat(lottoMachine.calculateBuyableLottos()).isEqualTo(lottoCount);
    }

    public static Stream provideRandomNumLotto() {
        int totalLottosNum = 5;
        GenerateNumStrategy generateNumStrategy = new AutoGenerateNumsStrategy();

        Lottos lottos = generateNumStrategy.generate(totalLottosNum, LottoMachine.NUMS_PER_LOTTO);

        return Stream.of(Arguments.of(lottos));
    }

    @ParameterizedTest
    @MethodSource("provideRandomNumLotto")
    void generateNums_생성_Strategy에_따라_번호_생성(Lottos lottos) {
        LottoMachine lottoMachine = new LottoMachine(new GenerateNumStrategy() {
            @Override
            public Lottos generate(int totalLottoNum, int numsPerLotto) {
                return lottos;
            }
        });

        assertThat(lottoMachine.generateLottos()).isEqualTo(lottos);
    }

    @Test
    void countLottoGrades_로또_당첨_개수_출력() {
        WinningResult winningResult = lottoMachine.countLottoPrize(winningNums, 44);
        assertThat(winningResult).isEqualTo(new WinningResult(Arrays.asList(0, 1, 0, 0, 1)));

        winningResult = lottoMachine.countLottoPrize(winningNums, 1);
        assertThat(winningResult).isEqualTo(new WinningResult(Arrays.asList(0, 0, 1, 0, 1)));
    }

    @Test
    void getTotalPrizeMoney_총_상금_계산() {
        assertThat(lottoMachine.getTotalPrizeMoney(winningNums, 1)).isEqualTo(1505000);
        assertThat(lottoMachine.getTotalPrizeMoney(winningNums, 44)).isEqualTo(30005000);
    }

    @Test
    void getYield_수익률_계산() {
        assertThat(lottoMachine.getYield(winningNums, 1)).isEqualTo(1505000.0/14500.0);
        assertThat(lottoMachine.getYield(winningNums, 44)).isEqualTo(30005000.0/14500.0);
    }

}
