package com.seok2.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class PapersTest {

    Papers papers = Papers.of(new LinkedList<>(Arrays.asList(Paper.of("1,2,3,4,5,6"))));

    @Test
    void size() {
        assertThat(papers.size()).isEqualTo(1);
    }

    @Test
    void next() {
        assertThat(papers.next()).isEqualTo("1,2,3,4,5,6");
    }

    @Test
    void isNotEmpty() {
        assertThat(papers.isNotEmpty()).isEqualTo(true);
    }
}