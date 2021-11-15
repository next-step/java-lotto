package com.kakao.stringadder.domain;

import com.kakao.stringadder.domain.calculator.Operand;
import com.kakao.stringadder.domain.calculator.OperandCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class OperandCollectionTest {

    @Test
    @DisplayName("Operand의 합을 계산한다")
    void plusAll() {
        OperandCollection operandCollection = new OperandCollection(Arrays.asList(new Operand(1), new Operand(2), new Operand(3)));
        assertThat(operandCollection.plusAll()).isEqualTo(new Operand(6));
    }

    @Test
    @DisplayName("Operand가 1개일 때도 합 계산이 가능하다.")
    void plusAllOne() {
        OperandCollection operandCollection = new OperandCollection(Collections.singletonList(new Operand(1)));
        assertThat(operandCollection.plusAll()).isEqualTo(new Operand(1));
    }

    @Test
    @DisplayName("Operand가 비었을 때 0을 리턴한다.")
    void plusAllNone() {
        OperandCollection operandCollection = new OperandCollection(new ArrayList<>());
        assertThat(operandCollection.plusAll()).isEqualTo(new Operand(0));
    }
}
