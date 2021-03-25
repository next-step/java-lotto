package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {
    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
    }

    @Test
    public void create() {
        assertThat(new LottoNumbers(lottoNumbers)).isEqualTo(new LottoNumbers(lottoNumbers));
    }

    @Test
    public void createLessThan6LottoNumbers() {
        lottoNumbers = lottoNumbers.stream().limit(5).collect(Collectors.toList());

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }

    @Test
    public void createMoreThan6LottoNumbers() {
        lottoNumbers = new ArrayList<>(lottoNumbers);
        lottoNumbers.add(LottoNumber.of(7));

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }

    @Test
    public void createDuplicateLottoNumbers() {
        lottoNumbers = lottoNumbers.stream().limit(5).collect(Collectors.toList());
        lottoNumbers.add(LottoNumber.of(5));

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }

    @Test
    public void matchingCount() {
        final LottoNumbers source = new LottoNumbers(lottoNumbers);

        final LottoNumbers target = new LottoNumbers(
                Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(23),
                        LottoNumber.of(3),
                        LottoNumber.of(42),
                        LottoNumber.of(5),
                        LottoNumber.of(19)
                )
        );

        assertThat(source.matchingCount(target)).isEqualTo(3);
    }
}
