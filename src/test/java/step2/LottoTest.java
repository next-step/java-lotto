package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    public void 로또_생성_테스트() {
        //해당 테스트를 위해 Lotto에 int[]를 파라미터를 받는 생성자 추가
        assertThat(new Lotto(new int[]{1, 2, 3, 4, 5, 6}).getLottoNumbers()).hasSize(6);
    }
}
