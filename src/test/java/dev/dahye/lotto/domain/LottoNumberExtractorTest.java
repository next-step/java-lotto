package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberExtractorTest {
    @ParameterizedTest(name = "로또 번호 최대 갯수 = {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 45})
    @DisplayName("요청한 size 만큼의 랜덤 값이 생성된다.")
    void create(int size) {
        List<Integer> lottoNumbers = LottoNumberExtractor.createShuffled(size);
        assertThat(lottoNumbers.size()).isEqualTo(size);
    }

    @ParameterizedTest(name = "로또 번호 최대 갯수 = {0}")
    @ValueSource(ints = {45})
    @DisplayName("요청한 size 만큼의 랜덤 값이 생성된다.")
    void create_random(int size) {
        List<Integer> lottoNumbers = LottoNumberExtractor.createShuffled(size);
        Set<Integer> deduplicatedNumbers = new HashSet<>(lottoNumbers);
        assertThat(deduplicatedNumbers.size()).isEqualTo(size);
    }

    @Test
    @DisplayName("로또 값 객체가 가지고 있는 값보다 큰 값을 요청하는 경우 IllegalArgumentException throw")
    void valid_lotto_numbers_max_value() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoNumberExtractor.createShuffled(LottoNumber.MAX_VALUE + 1));
    }
}