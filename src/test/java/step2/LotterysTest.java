package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.generate.Generate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotterysTest {
    @Test
    @DisplayName("count 만큼 로또 생성하는지 체크한다.")
    void createLottoTest() {
        Lotterys lotterys = new Lotterys(1, new Generate() {
            @Override
            public List<Integer> makeNumbers(int size) {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        });
        assertThat(lotterys.length()).isEqualTo(1);
    }
    @Test
    @DisplayName("shuffle 을 통해 로또 번호를 생성한다.")
    void randomNumbersTest() {
        Lotterys lotterys = new Lotterys(1, new Generate() {
            @Override
            public List<Integer> makeNumbers(int size) {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        });
        assertThat(lotterys.getLottery(0)).isEqualTo(new Lottery(List.of(1, 2, 3, 4, 5, 6)));
    }
}
