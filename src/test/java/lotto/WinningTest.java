package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {

    private static final int WINNING_SIZE = 6;

    private Winning winning;
    private List<Integer> winningNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= WINNING_SIZE; i++) {
            winningNumbers.add(i);
        }
        winning = new Winning(winningNumbers);
    }

    @Test
    void createTest() throws NoSuchFieldException, IllegalAccessException {
        //then - 동일 생성으로 비교
        assertThat(winning).isEqualTo(new Winning(winningNumbers));

        //when, then - field 접근
        Field[] allField = winning.getClass().getDeclaredFields();
        Arrays.stream(allField).forEach(field -> field.setAccessible(true));

        assertThat(allField[0].get(winning)).isEqualTo(winningNumbers);
        for (int i = 1; i < allField.length; i++) {
            assertThat(allField[i].getInt(winning)).isEqualTo(0);
        }
    }


}
