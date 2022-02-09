package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("유저를 잘 생성하는지 테스트")
    @Test
    void createUserTest() {
        List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10))
        );

        User user = new User(lottos);

        assertThat(user.getLottos()).hasSize(2);
    }
}