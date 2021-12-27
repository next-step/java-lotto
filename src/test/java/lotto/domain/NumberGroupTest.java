package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberGroupTest {
    @BeforeEach
    void beforeEach() {
        Mock.beforeEach();
    }

    List<Number> numberList;

    @Test
    @DisplayName("동일한 리스트로 NumberGroup이 생성시 같은 값인지 확인합니다.")
    void equals() {
        //given
        NumberGroup numberGroup = mockNumberGroup();

        //when
        boolean result = numberGroup.equals(new NumberGroup(numberList));

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("동일한 리스트로 NumberGroup이 생성시 같은 값인지 확인합니다.")
    void match() {
        //given
        NumberGroup compareNumberGroup = Mock.numberGroups(1, 2, 3, 4, 5, 6);
        NumberGroup winningNumberGroup = Mock.numberGroups(2, 3, 4, 5, 6, 1);
        //when
        compareNumberGroup.match(winningNumberGroup);
        //then
        assertAll(
                () -> assertTrue(MatchCriteria.THREE.equalsCount(new Count(0))),
                () -> assertTrue(MatchCriteria.FOUR.equalsCount(new Count(0))),
                () -> assertTrue(MatchCriteria.FIVE.equalsCount(new Count(0))),
                () -> assertTrue(MatchCriteria.SIX.equalsCount(new Count(1)))
        );
    }

    @Test
    @DisplayName("주어진 result에 일치하는 MatchCriteria의 count값이 정상적으로 증가하였는지 확인합니다.")
    void matchMatchCriteria() {
        //given
        Criteria result = new Criteria(3);
        //when
        mockNumberGroup().matchMatchCriteria(result);
        //then
        assertThat(MatchCriteria.THREE.equalsCount(new Count(1))).isTrue();
    }

    NumberGroup mockNumberGroup() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        numberList = Arrays.stream(numbers)
                .map(n -> new Number(n))
                .collect(Collectors.toList());

        return new NumberGroup(numberList);
    }
}