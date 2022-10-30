import dto.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    private Result result;

    @BeforeEach
    public void init() {
        result = new Result(0);
    }

    @Test
    public void 덧셈연산() {
        result.add(3);
        assertThat(result.getResult()).isEqualTo(3);
    }
}
