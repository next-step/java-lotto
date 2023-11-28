package step4.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutomaticLottoGeneratorTest {

    @Test
    void 자동_로또_생성_테스트() {
        List<UserLotto> userLottoList = new AutomaticLottoGenerator(3).generate();
        assertThat(userLottoList.size()).isEqualTo(3);
    }
}
