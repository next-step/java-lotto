package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.purchase.PurchaseAuto;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void 로또생성숫자범위() {
        List<LottoNumber> next = Lotto.newInstance(PurchaseAuto.instance()).numbers();
        assertAll(() -> {
            for (LottoNumber lottoNumber : next) {
                assertThat(LottoNumber.MIN_NUMBER <= lottoNumber.value()
                    && lottoNumber.value() <= LottoNumber.MAX_NUMBER).isTrue();
            }
        });
    }

    @Test
    void 구매정렬() {
        List<LottoNumber> next = Lotto.newInstance(PurchaseAuto.instance()).numbers();
        Iterator<LottoNumber> iterator = next.iterator();
        assertAll(() -> {
                LottoNumber prev = null;
                while (iterator.hasNext()) {
                    LottoNumber current = iterator.next();
                    if (prev == null) {
                        prev = current;
                        continue;
                    }
                    assertThat(prev.value() < current.value()).isTrue();
                    prev = current;
                }
            }
        );
    }

    @Test
    void 구성숫자크기() {
        assertAll(
            () -> assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(
                    List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5))))
                .withMessageMatching("로또는 6개의 중복되지않은 숫자로만 구성 가능합니다 : 5"),
            () -> assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(
                    List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6), new LottoNumber(7))))
                .withMessageMatching("로또는 6개의 중복되지않은 숫자로만 구성 가능합니다 : 7")
        );
    }

    @Test
    void 중복제거() {
        List<LottoNumber> numbers1 = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 6).stream().map(
                LottoNumber::new)
            .collect(
                Collectors.toList());
        List<LottoNumber> numbers2 = List.of(1, 1, 2, 2, 2, 3, 4, 5, 5, 6).stream().map(
                LottoNumber::new)
            .collect(
                Collectors.toList());
        List<LottoNumber> numbers3 = List.of(1, 2, 3, 3, 3, 3, 4, 4, 5, 6).stream().map(
                LottoNumber::new)
            .collect(
                Collectors.toList());
        assertAll(
            () -> assertThat(new Lotto(numbers1)).isEqualTo(new Lotto(numbers2)),
            () -> assertThat(new Lotto(numbers2)).isEqualTo(new Lotto(numbers3))
        );
    }

    @Test
    void 로또생성() {
        List<LottoNumber> numbers1 = List.of(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new)
            .collect(Collectors.toList());
        List<LottoNumber> numbers2 = List.of(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new)
            .collect(Collectors.toList());
        assertThat(new Lotto(numbers1)).isEqualTo(new Lotto(numbers2));
    }

}
