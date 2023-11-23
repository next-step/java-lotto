package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("로또 뭉치를 생성한다.")
    void create_lottos() {
        // given
        List<List<Integer>> givenLottos = createGivenLottos();

        // when
        Lottos lottos = new Lottos(givenLottos);

        // then
        assertThat(lottos).isEqualTo(createExpectedLottos());
    }

    private List<List<Integer>> createGivenLottos() {
        List<List<Integer>> given = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            given.add(new ArrayList<>());
        }
        for (List<Integer> lotto : given) {
            lotto.addAll(List.of(1, 2, 3, 4, 5, 6));
        }
        return given;
    }

    private Lottos createExpectedLottos() {
        return new Lottos(
                createExpectedLotto(),
                createExpectedLotto(),
                createExpectedLotto(),
                createExpectedLotto(),
                createExpectedLotto(),
                createExpectedLotto()
        );
    }

    private Lotto createExpectedLotto() {
        return new Lotto(1, 2, 3, 4, 5, 6);
    }
}
