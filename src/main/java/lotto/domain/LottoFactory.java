package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoFactory {

    public static List<LottoNumber> createListOfLottoNumber (int [] numbers) {
        List <LottoNumber> lottoNumbers = new ArrayList<>();
        Arrays.stream(numbers).forEach(number -> {
            lottoNumbers.add(LottoNumber.of(number));
        });
        return lottoNumbers;
    }

    public static PlayersLotto createPlayersLotto (int [] numbers) {
        return PlayersLotto.of(createListOfLottoNumber(numbers));
    }
}
