package lotto;

import lotto.domain.LottoStore;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class LottoStoreTest {
    @Test
    @DisplayName("입력금액만큼 로또가 생성되는지 테스트(1000원에 로또 1장)")
    void buyLottoTest() {
        int money = 5000;
        Assertions.assertThat(LottoStore.buyLotto(money)).isEqualTo(money / 1000);
    }

    @Test
    @DisplayName("1000원 단위가 아닌 금액 입력 시, 예외처리 테스트")
    void buyLotto_wrongMoney_test() {
        int money = 5500;
        Assertions.assertThatThrownBy(() -> {
                    LottoStore.buyLotto(money);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1000 단위로 입력해 주시기 바랍니다.");
    }

    @Test
    @DisplayName("로또 구매 갯수만큼 로또객체가 생성되는지 테스트")
    void pickUpLottosTest() {
        int numberOfLotto = 5;
        Assertions.assertThat(LottoStore.pickUpLottos(numberOfLotto)).hasSize(numberOfLotto);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:1", "4:1", "5:1", "6:1"}, delimiter = ':')
    @DisplayName("로또 등수별로 몇개씩 나왔는지 통계 확인 테스트")
    void lottoResultTest(int ranking, int match) {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new int[]{1,2,3,4,5,6}));   //6개 일치
        lottoList.add(new Lotto(new int[]{1,2,3,4,5,9}));   //5개 일치
        lottoList.add(new Lotto(new int[]{1,2,3,4,14,15})); //4개 일치
        lottoList.add(new Lotto(new int[]{1,2,3,33,34,35}));//3개 일치

        String winnerNumbers = "1, 2, 3, 4, 5, 6";
        int[] winnersResult = LottoStore.lottoResult(lottoList, winnerNumbers);
        Assertions.assertThat(winnersResult[ranking]).isEqualTo(match);
    }
}
