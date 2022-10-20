package lotto.domain;

import lotto.util.NullCannotBeConstructorArgException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoPaperTest {

    private List<String> stringNumbers;
    private List<Lotto> lottos;
    private LottoPaper lottoPaper;

    @BeforeEach
    void setUp() {
        stringNumbers = List.of(
                "1,2,3,4,5,6",
                "11,12,13,14,15,16",
                "21,22,23,24,25,26"
        );
        lottos = stringNumbers.stream()
                .map(Lotto::from)
                .collect(Collectors.toList());
        lottoPaper = new LottoPaper(lottos);
    }

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("로또 숫자가 있는 문자열들로 생성할 수 있다.")
        @Test
        void create_by_string_list() {
            LottoPaper expected = new LottoPaper(lottos);

            LottoPaper actual = LottoPaper.from(stringNumbers);

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("생성할때 인자값이 null이면 예외가 발생한다.")
        @Test
        void validate_null() {
            assertThatThrownBy(() -> new LottoPaper(null))
                    .isExactlyInstanceOf(NullCannotBeConstructorArgException.class)
                    .hasMessage("Null은 생성자의 인자가 될 수 없습니다.");
        }
    }

    @DisplayName("주어진 플레이로또수만큼 로또들을 자동생성할 수 있다.")
    @Test
    void generateLottos() {
        List<String> additional = List.of(
                "31,32,33,34,35,36",
                "37,38,39,40,41,42"
        );
        List<String> merged = Stream.of(stringNumbers, additional)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        LottoPaper expected = LottoPaper.from(merged);
        PlayLottoCount playLottoCount = new PlayLottoCount(2);

        LottoPaper actual = lottoPaper.generateAutoLottos(playLottoCount, new FixedLottoGenerator());

        assertThat(actual).isEqualTo(expected);
    }
}
