package lotto.model;

import lotto.fixture.BuyerFixtureNumberCreator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoesTest {

    @Test
    void 수동_로또목록을_출력한다() {
        int[] lotto1 = new int[]{8, 21, 23, 41, 42, 43};
        int[] lotto2 = new int[]{1, 8, 11, 31, 41, 42};

        Lottoes lottoes = new Lottoes(Arrays.asList(new Lotto(lotto1), new Lotto(lotto2)));

        List<Lotto> actual = lottoes.value();
        List<Lotto> expected = Arrays.asList(new Lotto(lotto1), new Lotto(lotto2));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동_로또목록을_출력한다() {
        int[] lotto1 = new int[]{8, 21, 23, 41, 42, 43};
        int[] lotto2 = new int[]{1, 8, 11, 31, 41, 42};

        Lottoes lottoes = new Lottoes(2, new BuyerFixtureNumberCreator(Arrays.asList(lotto1, lotto2)));

        List<Lotto> actual = lottoes.value();
        List<Lotto> expected = Arrays.asList(new Lotto(lotto1), new Lotto(lotto2));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 수동_자동_로또목록을_출력한다() {
        int[] manualLotto1 = new int[]{8, 21, 23, 41, 42, 43};
        int[] manualLotto2 = new int[]{1, 8, 11, 31, 41, 42};
        int[] autoLotto1 = new int[]{8, 21, 23, 41, 42, 43};
        int[] autoLotto2 = new int[]{1, 8, 11, 31, 41, 42};

        Lottoes manualLottoes = new Lottoes(Arrays.asList(new Lotto(manualLotto1), new Lotto(manualLotto2)));
        Lottoes autoLottoes = new Lottoes(2, new BuyerFixtureNumberCreator(Arrays.asList(autoLotto1, autoLotto2)));

        Lottoes lottoes = new Lottoes(manualLottoes, autoLottoes);

        List<Lotto> actual = lottoes.value();
        List<Lotto> expected = Arrays.asList(
                new Lotto(manualLotto1), new Lotto(manualLotto2),
                new Lotto(autoLotto1), new Lotto(autoLotto2)
                );

        assertThat(actual).isEqualTo(expected);
    }
}