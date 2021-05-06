package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    Lotto lotto;

    @BeforeEach
    void setUp(){
        lotto = new Lotto();
    }

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.")
    @Test
    void buyLottoTest(){
        assertThat(lotto.buyLotto(14000)).isEqualTo(14);
    }

    @DisplayName("로또 공은 1~45까지 무작위 숫자를 가져온다.")
    @Test
    void createLottoBallTest(){
        assertThat(lotto.shuffleLottoBall().get(0)).isBetween(1,45);
    }

    @DisplayName("로또번호는 숫자 6개이다.")
    @Test
    void createLottoNumberTest(){
        assertThat(lotto.createLottoNumber().size()).isEqualTo(6);
    }

    @DisplayName("로또번호는 숫자 6개가 오름차순으로 정렬된다.")
    @Test
    void sortLottoNumberTest(){
        List<Integer> unSortedLottoNumbers = Arrays.asList(35, 26, 42, 5, 7, 13);
        List<Integer> SortedLottoNumbers = Arrays.asList(35, 26, 42, 5, 7, 13);
        Collections.sort(SortedLottoNumbers);
        assertThat(lotto.sortLottoNumber(unSortedLottoNumbers)).isEqualTo(SortedLottoNumbers);
    }

    @DisplayName()
}
