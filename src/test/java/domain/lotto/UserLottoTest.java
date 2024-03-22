package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserLottoTest {


    @DisplayName("IntegerList의 리스트를 받아서 유저 로또를 생성할 수 있다.")
    @Test
    void from() {

        List<List<Integer>> listOfIntegerList = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7));
        UserLotto userLotto = UserLotto.from(listOfIntegerList);

        List<Lotto> expectedLottoList = List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), Lotto.from(List.of(1, 2, 3, 4, 5, 7)));

        assertThat(userLotto).isEqualTo(new UserLotto(expectedLottoList));

    }
}
