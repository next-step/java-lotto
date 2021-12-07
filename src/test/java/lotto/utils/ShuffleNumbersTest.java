package lotto.utils;

import lotto.game.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

class ShuffleNumbersTest {
    @Test
    void generate() {
        List<LottoNumber> numbers = ShuffleNumbers.generateLottoNumbers();
        System.out.println(numbers);

        List<LottoNumber> numbers1 = ShuffleNumbers.generateLottoNumbers();
        System.out.println(numbers1);

        List<LottoNumber> numbers2 = ShuffleNumbers.generateLottoNumbers();
        System.out.println(numbers2);
    }
}