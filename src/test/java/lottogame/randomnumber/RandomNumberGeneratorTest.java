package lottogame.randomnumber;

import java.util.List;
import lottogame.domain.spi.NumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("RandomNumberGenerator 클래스")
class RandomNumberGeneratorTest {

    @Nested
    @DisplayName("generate 메소드는")
    class Describe_Generate {

        @Nested
        @DisplayName("count가 n으로 들어오면,")
        class Context_Count_Six {

            private final int count = 6;
            private final NumberGenerator numberGenerator = new RandomNumberGenerator();

            @Test
            @DisplayName("size가 n인 Integer 리스트를 반환한다")
            void It_Return_N_Size_List() {
                List<Integer> result = numberGenerator.generate(count);

                Assertions.assertThat(result).hasSize(count);
            }

        }

    }
}
