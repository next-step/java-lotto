package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 로또가_갯수만큼_생기는지_확인(int count) {
        assertThat(new Lottos(new LottoGenerator(), count).size()).isEqualTo(count);
    }

    @Test
    void 자동과_수동을_살_경우() {
        int autoCount = 3;
        List<Lotto> manualLotto = new ArrayList<>();
        manualLotto.add(new Lotto(Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6))));

        assertThat(new Lottos(new LottoGenerator(1, 6), manualLotto, autoCount).size()).isEqualTo(4);
    }

    @Test
    void 로또가_3개_맞은_경우() {
        String winningNumbers = "1,2,3,7,8,9";
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers.split(","), 10);
        assertThat(new Lottos(new LottoGenerator(1, 6), 1).calculateNumbers(lottoWinningNumbers, 3));
    }

    @Test
    void 로또가_4개_맞은_경우() {
        String winningNumbers = "1,2,3,4,8,9";
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers.split(","), 10);
        assertThat(new Lottos(new LottoGenerator(1, 6), 1).calculateNumbers(lottoWinningNumbers, 4));
    }

    @Test
    void 로또가_5개_맞은_경우() {
        String winningNumbers = "1,2,3,4,5,9";
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers.split(","), 10);
        assertThat(new Lottos(new LottoGenerator(1, 6), 1).calculateNumbers(lottoWinningNumbers, 5));
    }

    @Test
    void 로또_5개_맞고_보너스번호_맞춤() {
        String winningNumbers = "1,2,3,4,5,9";
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers.split(","), 6);
        assertThat(new Lottos(new LottoGenerator(1, 6), 1).calculateNumbers(lottoWinningNumbers, 6));
    }

    @Test
    void 로또가_6개_맞은_경우() {
        String winningNumbers = "1,2,3,4,5,6";
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers.split(","), 10);
        assertThat(new Lottos(new LottoGenerator(1, 6), 1).calculateNumbers(lottoWinningNumbers, 6));
    }

}