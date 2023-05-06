package lotto.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    GameResult gameResult;

    @BeforeEach
    public void setUp() {
        gameResult = new GameResult();
    }

    @Test
    @DisplayName("count 3개 미만 입력 시 미입력 확인")
    public void gameResult_dont_add_when_input_under_3() {
        int inputCount = 2;
        boolean inputIsBonus = false;
        HashMap<Integer, Integer> expected = new HashMap<>() {{
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(15, 0);
            put(6, 0);
        }};

        gameResult.addCount(inputCount, inputIsBonus);
        HashMap<Integer, Integer> actual = gameResult.table();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("count 3개 입력 시 정상 입력 확인")
    public void gameResult_add_3() {
        int inputCount = 3;
        boolean inputIsBonus = false;
        HashMap<Integer, Integer> expected = new HashMap<>() {{
            put(3, 1);
            put(4, 0);
            put(5, 0);
            put(15, 0);
            put(6, 0);
        }};

        gameResult.addCount(inputCount, inputIsBonus);
        HashMap<Integer, Integer> actual = gameResult.table();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("count 4개 입력 시 정상 입력 확인")
    public void gameResult_add_4() {
        int inputCount = 4;
        boolean inputIsBonus = false;
        HashMap<Integer, Integer> expected = new HashMap<>() {{
            put(3, 0);
            put(4, 1);
            put(5, 0);
            put(15, 0);
            put(6, 0);
        }};

        gameResult.addCount(inputCount, inputIsBonus);
        HashMap<Integer, Integer> actual = gameResult.table();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("count 5개 입력 시 정상 입력 확인")
    public void gameResult_add_5() {
        int inputCount = 5;
        boolean inputIsBonus = false;
        HashMap<Integer, Integer> expected = new HashMap<>() {{
            put(3, 0);
            put(4, 0);
            put(5, 1);
            put(15, 0);
            put(6, 0);
        }};

        gameResult.addCount(inputCount, inputIsBonus);
        HashMap<Integer, Integer> actual = gameResult.table();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("count 6개 입력 시 정상 입력 확인")
    public void gameResult_add_6() {
        int inputCount = 6;
        boolean inputIsBonus = false;
        HashMap<Integer, Integer> expected = new HashMap<>() {{
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(15, 0);
            put(6, 1);
        }};

        gameResult.addCount(inputCount, inputIsBonus);
        HashMap<Integer, Integer> actual = gameResult.table();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("count 5개가 아닌 숫자일 때 bonus 입력 시 bonus 계산 제외 확인")
    public void gameResult_dont_add_bonus_not_5() {
        int inputCount = 4;
        boolean inputIsBonus = true;
        HashMap<Integer, Integer> expected = new HashMap<>() {{
            put(3, 0);
            put(4, 1);
            put(5, 0);
            put(15, 0);
            put(6, 0);
        }};

        gameResult.addCount(inputCount, inputIsBonus);
        HashMap<Integer, Integer> actual = gameResult.table();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("count 5개일 때 bonus 입력 시 bonus 계산 확인")
    public void gameResult_add_bonus_with_5() {
        int inputCount = 5;
        boolean inputIsBonus = true;
        HashMap<Integer, Integer> expected = new HashMap<>() {{
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(15, 1);
            put(6, 0);
        }};

        gameResult.addCount(inputCount, inputIsBonus);
        HashMap<Integer, Integer> actual = gameResult.table();

        assertThat(actual).isEqualTo(expected);
    }

}