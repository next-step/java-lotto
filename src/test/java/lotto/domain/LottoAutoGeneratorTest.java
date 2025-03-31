package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LottoAutoGeneratorTest {
    static final int LOTTO_SIZE = 6;
    static final int LOTTO_MIN_NUMBER = 1;
    static final int LOTTO_MAX_NUMBER = 45;

    @Test
    @DisplayName("로또 번호는 6개 여야 한다.")
    void generateLottoTicket_SizeIsSix() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        List<Integer> lottoTicket = lottoAutoGenerator.generateLottoTicket();
        Assertions.assertEquals(LOTTO_SIZE, lottoTicket.size());
    }

    @Test
    @DisplayName("로또 번호는 1~45 범위 내에 있어야 한다.")
    void generateLottoTicket_NumberInRange() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        List<Integer> lottoTicket = lottoAutoGenerator.generateLottoTicket();

        Assertions.assertTrue(lottoTicket.stream().allMatch(num -> num >= LOTTO_MIN_NUMBER && num <= LOTTO_MAX_NUMBER));
    }

    @Test
    @DisplayName("로또 번호에 중복이 없어야 한다.")
    void generateLottoTicket_NoDuplicateNumber() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        List<Integer> lottoTicket = lottoAutoGenerator.generateLottoTicket();
        Set<Integer> lottoNumberSet = new HashSet<>(lottoTicket);

        Assertions.assertEquals(LOTTO_SIZE, lottoNumberSet.size());
    }

    @Test
    @DisplayName("로또 번호는 오름차순으로 정렬되어 있어야 한다.")
    void generateLottoTicket_SortedNumbers() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        List<Integer> lottoTicket = lottoAutoGenerator.generateLottoTicket();

        for (int i = 0; i < lottoTicket.size() - 1; i++) {
            Assertions.assertTrue(lottoTicket.get(i) < lottoTicket.get(i + 1));
        }
    }

    @RepeatedTest(5)
    @DisplayName("로또 번호가 매번 랜덤하게 생성되어야 한다.")
    void generateLottoTicket_IsRandom() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        List<Integer> firstTicket = lottoAutoGenerator.generateLottoTicket();
        List<Integer> secondTicket = lottoAutoGenerator.generateLottoTicket();
        Assertions.assertNotEquals(firstTicket, secondTicket, "로또 번호가 매번 랜덤하게 생성되어야 합니다.");
    }
}
