package com.seok2.common.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayUtilsTest {

    @Test
    void isEmpty() {
        assertThat(ArrayUtils.isEmpty(new int [] {})).isTrue();
        assertThat(ArrayUtils.isEmpty(null)).isTrue();
        assertThat(ArrayUtils.isEmpty(new int [] {1})).isFalse();
    }
}