package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoesTest {

    @Test
    void createOne() {
        NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
        assertThat(Lottoes.of(1, shuffleStrategy)).usingRecursiveComparison().isEqualTo(
            Lottoes.from(Collections.singletonList(Lotto.of(shuffleStrategy))));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 14})
    void createMultiple(int numberOfCreated) {
        NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < numberOfCreated; i++) {
            lottoes.add(Lotto.of(new NoShuffleStrategy()));
        }

        assertThat(Lottoes.of(numberOfCreated, shuffleStrategy)).usingRecursiveComparison().isEqualTo(
            Lottoes.from(lottoes));
    }

    @Test
    @DisplayName("자동로또 수동로또 함께 생성")
    void createWithManual() {
        NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lottoes.add(Lotto.of(new NoShuffleStrategy()));
        }

        assertThat(Lottoes.of(10, shuffleStrategy,
            Arrays.asList(LottoNumbers.of("1,2,3,4,5,6"), LottoNumbers.of("1,2,3,4,5,6"))))
            .usingRecursiveComparison().isEqualTo(Lottoes.from(lottoes));
    }

    @Test
    @DisplayName("자동로또 수동로또 생성 개수 조회")
    void countLottoType() {
        NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();

        Lottoes lottoes = Lottoes.of(10, shuffleStrategy,
                Arrays.asList(LottoNumbers.of("1,2,3,4,5,6"), LottoNumbers.of("1,2,3,4,5,6")));

        assertThat(lottoes.autoLottoSize()).isEqualTo(8);
        assertThat(lottoes.manualLottoSize()).isEqualTo(2);
    }


    @Test
    @DisplayName("당첨등수를 기준으로 몇 개가 당첨되었는지 조회")
    void countMatchedLottoes() {
        Lottoes lottoes = Lottoes.of(2, new NoShuffleStrategy());

        assertThat(
            lottoes.numberOfLottoesMatched(Winning.FIFTH,
                    WinningNumbers.of(Arrays.asList(1, 2, 3, 7, 8, 9), 10)))
            .isEqualTo(2);
        assertThat(
            lottoes.numberOfLottoesMatched(Winning.FOURTH,
                    WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 8, 9), 10)))
            .isEqualTo(2);
    }

    @Test
    @DisplayName("지출대비 수익률 계산")
    void calculateYield() {
        Lottoes lottoes = Lottoes.of(1, new NoShuffleStrategy());

        assertThat(lottoes.yield(WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7), Price.of(1000)))
            .isEqualTo(2000000);
        assertThat(lottoes.yield(WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7), 6), Price.of(1000)))
            .isEqualTo(30000);
        assertThat(lottoes.yield(WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7), 8), Price.of(1000)))
            .isEqualTo(1500);
        assertThat(lottoes.yield(WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 7, 8), 6), Price.of(1000)))
            .isEqualTo(50);
        assertThat(lottoes.yield(WinningNumbers.of(Arrays.asList(1, 2, 3, 7, 8, 9), 6), Price.of(1000))).isEqualTo(5);
    }
}
