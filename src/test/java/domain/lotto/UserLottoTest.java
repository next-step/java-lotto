package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserLottoTest {
    UserLotto userLotto;

    @BeforeEach
    void setUp() {

        Lotto firstLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = Lotto.from( List.of(1, 2, 3, 4, 5, 7));
        List<Lotto> listOfIntegerList = List.of(firstLotto, secondLotto);

        userLotto = UserLotto.from(listOfIntegerList);
    }

    @DisplayName("IntegerList의 리스트를 받아서 유저 로또를 생성할 수 있다.")
    @Test
    void from() {
        List<Lotto> expectedLottoList = List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), Lotto.from(List.of(1, 2, 3, 4, 5, 7)));

        assertThat(userLotto).isEqualTo(new UserLotto(expectedLottoList));
    }

    @DisplayName("당첨번호를 이용하여 상금 Map을 만들 수 있다.")
    @Test
    void name() {
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6), 19);
        Map<LottoPrize, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(LottoPrize.FIRST, 1);
        expectedResult.put(LottoPrize.THIRD, 1);

        Assertions.assertThat(userLotto.createLottoStatistics(winningLotto)).isEqualTo(expectedResult);
    }
}
