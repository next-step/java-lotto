package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultNumberTest {

    @Test
    public void toStringTest() {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoResultNumber lottoResultNumber = new LottoResultNumber(
                new Ticket(integerList));

        assertEquals(lottoResultNumber.toString(),
                integerList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")));
    }
}
