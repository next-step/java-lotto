package lottoauto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    void 자동생성_1개() {
        Lotto auto = Lotto.createAuto();
        System.out.println(auto);
        assertThat(auto).isNotNull();
    }

    @Test
    void 생성_정상() {
        Lotto lottoArray = Lotto.from(new String[]{"1", "2", "3", "4", "5", "6"});
        System.out.println(lottoArray);
        System.out.println(lottoArray.hashCode());
        Lotto lottoString = Lotto.from("1, 2, 3, 4, 5, 6");
        System.out.println(lottoString);
        System.out.println(lottoString.hashCode());

        System.out.println(lottoArray.equals(lottoString));
        assertThat(lottoArray.equals(lottoString)).isTrue();
    }

    @Test
    void 생성_1개_사이즈_에러() {
        String[] numbers = new String[]{"1", "2", "3", "4", "5"};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.from(numbers);
        }).withMessageContaining("로또 번호를 입력해야 합니다.");
    }

    @Test
    void 생성_1개_중복포함_에러() {
        String[] numbers = new String[]{"1", "2", "3", "5", "5", "5"};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.from(numbers);
        }).withMessageContaining("로또 번호를 입력해야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void 매칭되는_개수_확인(String[] winningLotto, String[] lotto, int ratingResult) {
        assertThat(Lotto.from(winningLotto).findMatchingCount(Lotto.from(lotto))).isEqualTo(ratingResult);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "4", "5", "6"}, 6),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "4", "5", "7"}, 5),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "4", "7", "8"}, 4),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "7", "8", "9"}, 3),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"7", "8", "9", "10", "11", "12"}, 0)
        );
    }
}