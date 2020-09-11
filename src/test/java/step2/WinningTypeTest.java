package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.WinningType;

import static org.assertj.core.api.Assertions.*;

public class WinningTypeTest {

    @DisplayName("상금에 따라 적절한 enum 찾는지 테스트")
    @Test
    void findSameCountTest(){

        assertThat(WinningType.findSameCount(5000)).isEqualTo(3);

    }

}
