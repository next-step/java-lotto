package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeInformationTest {


    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6})
    public void prizeInformationTest(int count){
        //Given & When
        PrizeInformation information = PrizeInformation.findByPrizePrice(count);

        //Then
        assertThat(information).isNotNull();
    }
}
