package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.generate.Generate;
import step2.lottery.Lottery;
import step2.lottery.LotteryNumber;
import step2.lottery.Lotterys;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LotterysTest {
    @Test
    @DisplayName("count 만큼 로또 생성하는지 체크한다.")
    void createLottoTest() {
        Lotterys lotterys = new Lotterys(1, new Generate() {
            @Override
            public Set<LotteryNumber> makeNumbers(int size) {
                return Set.of(
                        LotteryNumber.of(1),
                        LotteryNumber.of(2),
                        LotteryNumber.of(3),
                        LotteryNumber.of(4),
                        LotteryNumber.of(5),
                        LotteryNumber.of(6)
                );
            }
        });
        assertThat(lotterys.length()).isEqualTo(1);
    }
    @Test
    @DisplayName("generate 을 통해 로또 번호를 생성한다.")
    void randomNumbersTest() {
        Lotterys lotterys = new Lotterys(1, new Generate() {
            @Override
            public Set<LotteryNumber> makeNumbers(int size) {
                return Set.of(
                        LotteryNumber.of(1),
                        LotteryNumber.of(2),
                        LotteryNumber.of(3),
                        LotteryNumber.of(4),
                        LotteryNumber.of(5),
                        LotteryNumber.of(6)
                );
            }
        });
        assertThat(lotterys.getLottery(0)).isEqualTo(new Lottery(Set.of(
                LotteryNumber.of(1),
                LotteryNumber.of(2),
                LotteryNumber.of(3),
                LotteryNumber.of(4),
                LotteryNumber.of(5),
                LotteryNumber.of(6)
        )));
    }
}
