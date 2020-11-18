package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeStatusTest {

    @DisplayName("PrizeStatus 인스턴스 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7})
    public void createPrizeStatusInstance(int expected) {
        //Given
        PrizeStatus prizeStatus = new PrizeStatus(expected);

        //When
        long result = prizeStatus.getPrizeNumberCount();

        //Then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("equals Test")
    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "3:3:3", "5:5:5"} , delimiter = ':')
    public void equalsTest(int prizeNumber, int prizeNumber2, int prizeNumber3){
        //Given && When
        PrizeStatus prizeStatus = new PrizeStatus(prizeNumber);
        PrizeStatus prizeStatus2 = new PrizeStatus(prizeNumber2);
        PrizeStatus prizeStatus3 = new PrizeStatus(prizeNumber3);

        //Then
        assertThat(prizeStatus).isEqualTo(prizeStatus2).isEqualTo(prizeStatus3);
    }


    @DisplayName("hashCode Test")
    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "3:3:3", "5:5:5"} , delimiter = ':')
    public void hashcodeTest(int prizeNumber, int prizeNumber2, int prizeNumber3) {
        //Given && When
        Map<PrizeStatus, Integer> map = new HashMap<>();
        map.put(new PrizeStatus(prizeNumber), 1);
        map.put(new PrizeStatus(prizeNumber2), 2);
        map.put(new PrizeStatus(prizeNumber3), 3);

        //Then
        assertThat(map.get(new PrizeStatus(prizeNumber))).isEqualTo(3);
    }
}
