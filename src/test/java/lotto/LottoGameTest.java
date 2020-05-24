package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoGameTest {

    @Test
    @DisplayName("로또 게임을 생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_게임_생성_테스트(){
        assertThatCode(() -> new LottoGame()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 게임을 추가하고, 결과 값을 검증한다.")
    void 로또_게임_추가_테스트(){
        int[] winningNumber = new int[]{1,2,3,4,5,6};
        LottoGame lottoGame = new LottoGame();

        Lotto lotto = lottoGame.add(1, winningNumber);

        assertThat(lotto.getLottoNumbers()).hasSize(winningNumber.length);
    }
}
