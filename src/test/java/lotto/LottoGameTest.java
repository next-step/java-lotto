package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {
    @Test
    void moneyValidate() {
        int money = 900;
        assertThatThrownBy(() -> {
            LottoGame lottoGame = new LottoGame(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addAll() {
        String[] lottoStrings = {"1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6"};
        int money = 5000;
        int expectedSize = money / 1000;

        LottoGame lottoGame = new LottoGame(money, Arrays.asList(lottoStrings));

        assertThat(lottoGame.lottoSize()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("금액을 넣었을때 금액 / 1000 만큼 로또가 생성되는지 확인한다.")
    void lottoSize() {
        int money = 3000;
        int expectedSize = money / 1000;

        LottoGame lottoGame = new LottoGame(money);

        assertThat(lottoGame.lottoSize()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("LottoRank당 하나씩 결과가 나오는지 확인한다.")
    void result() {
        List<Lotto> testLottos = getTestLottos();
        String testWinningNumbers = "1, 2, 3, 4, 5, 6";
        int bonus = 7;

        LottoGame lottoGame = new LottoGame(testLottos);
        WinningLotto winningLotto = new WinningLotto(testWinningNumbers,  bonus);

        LottoResult lottoResult = lottoGame.result(winningLotto);
        for (LottoRank lottoRank : LottoRank.values()) {
            assertThat(lottoResult.rankCount(lottoRank)).isEqualTo(1);
        }
    }

    private List<Lotto> getTestLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(getTestLotto(new int[]{1, 2, 3, 4, 5, 6}));
        lottos.add(getTestLotto(new int[]{2, 3, 4, 5, 6, 7}));
        lottos.add(getTestLotto(new int[]{2, 3, 4, 5, 6, 8}));
        lottos.add(getTestLotto(new int[]{3, 4, 5, 6, 7, 8}));
        lottos.add(getTestLotto(new int[]{4, 5, 6, 7, 8, 9}));
        lottos.add(getTestLotto(new int[]{10, 11, 12, 13, 14, 15}));

        return lottos;
    }

    private Lotto getTestLotto(int[] numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return new Lotto(lottoNumbers);
    }
}
