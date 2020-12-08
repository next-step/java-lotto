package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private static final int LOTTO_FIX_SIZE = 6;

    @DisplayName("로또 숫자 랜덤 생성 테스트")
    @Test
    public void lottoRandomCreateNumberTest() {
        //Given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 5, 6, 7);
        List<LottoNumber> expectedLottoNumber = lottoNumbers.stream()
                                        .map(LottoNumber::from)
                                        .collect(Collectors.toList());

        LottoMachine machine = (int capacity) -> Lotto.of(new HashSet<>(lottoNumbers));

        //When
        Lotto lotto = machine.createLotto(LOTTO_FIX_SIZE);

        //Then
        assertThat(lotto.getLottoNumbers()).hasSize(LOTTO_FIX_SIZE);
        assertThat(lotto.getLottoNumbers()).containsAll(expectedLottoNumber);
    }
}