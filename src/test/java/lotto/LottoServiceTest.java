package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    public void setup() {
        lottoService = new LottoService();
    }

    @Test
    public void testCreateNonDuplicateNumbers() {
        List<Integer> lottoNumbers = lottoService.createNonDuplicateNumbers();
        assertThat(lottoNumbers).hasSize(6);
        assertTrue(checkDuplicate(lottoNumbers));
    }

    private boolean checkDuplicate(List<Integer> lottoNumbers) {
        Set set = new HashSet(lottoNumbers);
        return set.size() == 6 ? true : false;
    }
}
