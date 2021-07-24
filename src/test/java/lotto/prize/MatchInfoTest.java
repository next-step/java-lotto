package lotto.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 번호화 로또 번호를 비교한 정보를 담는 클래스 테스트")
class MatchInfoTest {

    @DisplayName("매치 카운트와 보너스 매칭 여부를 가지고 초기화 한다.")
    @Test
    void init() {
        assertThat(MatchInfo.of(5, true)).isNotNull();
    }
}
