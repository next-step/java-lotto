package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class WinResultsTest {

    @Test
    public void 생성_테스트() {
        WinResults winResults = new WinResults(Arrays.asList(
                WinResult.FIRST,
                WinResult.FOURTH
        ));
        assertThat(winResults).isEqualTo(new WinResults(Arrays.asList(
                WinResult.FIRST,
                WinResult.FOURTH
        )));
    }

}
