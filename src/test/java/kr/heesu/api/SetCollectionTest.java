package kr.heesu.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {

    private Set<List<Integer>> numberSet;

    @BeforeEach
    void setUp() {
        this.numberSet = new HashSet<>();

        numberSet.add(Stream.of(1, 2, 3, 7, 8, 9).collect(Collectors.toList()));
        numberSet.add(Stream.of(1, 2, 3, 7, 8, 9).collect(Collectors.toList()));
        numberSet.add(Stream.of(32, 31, 45, 10, 11, 15).collect(Collectors.toList()));
    }

    @Test
    void duplication_test() {
        assertThat(this.numberSet.size()).isEqualTo(2);
    }
}
