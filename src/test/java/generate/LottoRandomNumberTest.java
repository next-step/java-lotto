package generate;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoRandomNumberTest {

    @RepeatedTest(100)
    public void 로또번호자동생성() {
        Integer[] randomNumbers = LottoRandomNumber.numbers();

        assertThat(randomNumbers.length).isEqualTo(6);

        assertThat(randomNumbers)
                .containsOnlyOnce(
                        randomNumbers[0],
                        randomNumbers[1],
                        randomNumbers[2],
                        randomNumbers[3],
                        randomNumbers[4],
                        randomNumbers[5]
                );
    }

}