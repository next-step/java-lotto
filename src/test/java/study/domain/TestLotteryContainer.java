package study.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import study.domain.generator.NumberGenerator;
import study.domain.generator.impl.AutoNumberGenerator;

public class TestLotteryContainer {
    
    NumberGenerator generator;
    LotteryContainer mockContainer;

    @BeforeEach
    void setUp() {
        generator = new AutoNumberGenerator();
        mockContainer = new LotteryContainer(2, generator);
    }


    @ParameterizedTest(name = "LotteryContainer 객체 - 로또 생성 개수 테스트")
    @CsvSource({"0", "1", "5", "10", "7"})
    public void test_container_lottery_count(int count) {
        LotteryContainer container = new LotteryContainer(count, generator);

        assertThat(container.getLotteryCount())
            .isEqualTo(count);
    }


    @Test
    @DisplayName("LotteryContainer 객체 - 로또 리스트 정상 생성 테스트")
    public void test_container_lottery_list() {
        LotteryContainer container = new LotteryContainer(1, generator);

        for (Lottery lotto : container.getTotalLottery()) {
            assertThat(lotto.getLottery().size())
                .isEqualTo(6);
        }
    }


    
    static Stream<Arguments> wrongSizeWinNumbers() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest(name = "LotteryContainer 객체 - 당첨번호 6자리 아닌경우 테스트")
    @MethodSource("wrongSizeWinNumbers")
    public void test_container_win_wrong_size(List<Integer> winNumbers) {

        assertThatThrownBy(() -> mockContainer.setWinNumbers(winNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("당첨 번호 6자리를 입력해주세요");
    }



    static Stream<Arguments> mockWinNumbers() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
    }
    
    @ParameterizedTest(name = "LotteryContainer 객체 - 당첨번호 중복 입력 테스트")
    @MethodSource("mockWinNumbers")
    public void test_container_winner_duplicate(List<Integer> winNumbers) {
        mockContainer.setWinNumbers(winNumbers);

        assertThatThrownBy(() -> mockContainer.setWinNumbers(winNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이미 당첨번호가 존재합니다");
    }


    @Test
    @DisplayName("LotteryContainer 객체 - 당첨번호 Null 입력 테스트")
    public void test_container_win_null() {
        assertThatThrownBy(() -> mockContainer.setWinNumbers(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("당첨 번호를 입력해주세요");
    }


    @ParameterizedTest(name = "LotteryContainer 객체 - 게임 정상 진행 테스트")
    @MethodSource("mockWinNumbers")
    public void test_container_lottery_game_run(List<Integer> winNumbers) {
        mockContainer.setWinNumbers(winNumbers);
        mockContainer.runGame();

        assertDoesNotThrow(() -> {
            for (Lottery lotto : mockContainer.getTotalLottery()) {
                lotto.getMatchCount();
            }
        });
        
    }


    @ParameterizedTest(name = "LotteryContainer 객체 - 게임 중복 진행 테스트")
    @MethodSource("mockWinNumbers")
    public void test_container_lottery_game_duplicate_run(List<Integer> winNumbers) {
        mockContainer.setWinNumbers(winNumbers);
        mockContainer.runGame();

        assertThatThrownBy(() -> mockContainer.runGame())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이미 진행된 게임입니다");
    }


    @Test
    @DisplayName("LotteryContainer 객체 - 당첨번호 없이 조회 실패 테스트")
    public void test_container_get_winner_list_fail() {
        assertThatThrownBy(() -> mockContainer.runGame())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("당첨 번호를 입력 해주세요");
    }


    @Test
    @DisplayName("LotteryContainer 객체 - 게임 진행없이 당첨자 조회 테스트")
    public void test_container_get_winner_without_game_run() {
        assertThatThrownBy(() -> mockContainer.getWinnerList())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("게임이 진행되지 않았습니다");
    }


    @ParameterizedTest(name = "LotteryContainer 객체 - 당첨자 조회")
    @MethodSource("mockWinNumbers")
    public void test_container_get_winner_list(List<Integer> winNumbers) {
        mockContainer.setWinNumbers(winNumbers);
        mockContainer.runGame();

        assertDoesNotThrow(() -> mockContainer.getWinnerList());
    }


}
