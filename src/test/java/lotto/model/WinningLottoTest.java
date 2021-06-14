package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinningLottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void generateWinningLotto(String names) {
        List<String> StringNames = Arrays.asList(names.split(","));
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (String name : StringNames) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(name)));
        }

        assertDoesNotThrow(() -> new WinningLotto(lottoNumbers, new LottoNumber(7)));
    }
}

