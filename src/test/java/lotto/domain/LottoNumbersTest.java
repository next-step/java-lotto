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
    private List<LottoNumber> lottoNumberList;

    @BeforeEach
    void setUp() {
        lottoNumberList = Arrays.asList(
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
        assertThat(new LottoNumbers(lottoNumberList)).isEqualTo(new LottoNumbers(lottoNumberList));
    }

    @Test
    public void createLessThan6LottoNumbers() {
        lottoNumberList = lottoNumberList.stream().limit(5).collect(Collectors.toList());

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumberList));
    }

    @Test
    public void createMoreThan6LottoNumbers() {
        lottoNumberList = new ArrayList<>(lottoNumberList);
        lottoNumberList.add(LottoNumber.of(7));

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumberList));
    }

    @Test
    public void createDuplicateLottoNumbers() {
        lottoNumberList = lottoNumberList.stream().limit(5).collect(Collectors.toList());
        lottoNumberList.add(LottoNumber.of(5));

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumberList));
    }

    @Test
    public void matchingCount() {
        final LottoNumbers source = new LottoNumbers(lottoNumberList);

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
