import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import util.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomNumberGeneratorTest {
    @Test
    @Order(1)
    public void 랜덤복권번호생성_성공() {
        assertThat(RandomNumberGenerator.generateNumbers()).filteredOn(number -> number >= 1 && number <= 45).hasSize(6);
    }
}
