package lotto.domain;

import lotto.domain.exceptions.InvalidLottoTicketException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTests {
    private List<LottoNumber> normalLottoNumbers;

    @BeforeEach
    void setup() {
        normalLottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @DisplayName("LottoNumber 컬렉션을 인자로 받아 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(new LottoTicket(normalLottoNumbers)).isEqualTo(new LottoTicket(normalLottoNumbers));
    }

    @DisplayName("LottoNumber 컬렉션의 크기가 중복 없이 6이어야만 한다.")
    @ParameterizedTest
    @MethodSource("createFailTestResource")
    void createFailTest(List<LottoNumber> invalidLottoNumbers) {
        assertThatThrownBy(() -> new LottoTicket(invalidLottoNumbers))
                .isInstanceOf(InvalidLottoTicketException.class);
    }
    public static Stream<Arguments> createFailTestResource() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(1)
                )),
                Arguments.of(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4), new LottoNumber(5)
                )),
                Arguments.of(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6),
                        new LottoNumber(7)
                ))
        );
    }
}
