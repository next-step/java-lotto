package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    Lottos lottos;

    @Test
    @DisplayName("Lottos 생성 테스트")
    void createLottos() {
        lottos = initTestLottos();

        assertThat(lottos.getLottos().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("당첨 통계 계산 기능")
    void lottoStatistic() {
        String winning = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;
        LottoNumbers winningNumbers = new LottoNumbers()
                .createWinningNumbers(winning);

        Lottos lottos = initTestLottos();

        Map<Integer, Integer> result = new HashMap<>();
        result.put(1, 1);
        result.put(2, 1);
        result.put(3, 1);
        result.put(4, 0);
        result.put(5, 2);

        assertThat(lottos.compileLottoStatistics(winningNumbers, bonusNumber)).isEqualTo(result);
    }

    private Lottos initTestLottos() {
        String test1 = "1, 2, 3, 4, 5, 6";
        LottoNumbers testNumber1 = new LottoNumbers()
                .createWinningNumbers(test1);
        Lotto testLotto1 = new Lotto(testNumber1);

        String test2 = "1, 7, 8, 9, 10, 11";
        LottoNumbers testNumber2 = new LottoNumbers()
                .createWinningNumbers(test2);
        Lotto testLotto2 = new Lotto(testNumber2);

        String test3 = "1, 2, 3, 9, 10, 11";
        LottoNumbers testNumber3 = new LottoNumbers()
                .createWinningNumbers(test3);
        Lotto testLotto3 = new Lotto(testNumber3);

        String test4 = "1, 2, 3, 9, 10, 11";
        LottoNumbers testNumber4 = new LottoNumbers()
                .createWinningNumbers(test4);
        Lotto testLotto4 = new Lotto(testNumber4);

        String test5 = "1, 2, 3, 4, 5, 7";
        LottoNumbers testNumber5 = new LottoNumbers()
                .createWinningNumbers(test5);
        Lotto testLotto5 = new Lotto(testNumber5);

        String test6 = "1, 2, 3, 4, 5, 8";
        LottoNumbers testNumber6 = new LottoNumbers()
                .createWinningNumbers(test6);
        Lotto testLotto6 = new Lotto(testNumber6);


        return Lottos.from(Arrays.asList(testLotto1, testLotto2, testLotto3, testLotto4, testLotto5, testLotto6));
    }

}
