package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtil {
    public static Lotto makeLotto(Integer... numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    public static WinningNumber makeWinningNumber(int bonus, Integer... numbers) {
        String join = String.join(",", Arrays.stream(numbers).map(String::valueOf).collect(Collectors.toList()));
        return new WinningNumber(Lotto.fromCommaString(join), new LottoNumber(bonus));
    }

    public static LottoGames makeLottoGames(Lotto... games) {
        LottoGames lottoGames = new LottoGames();

        Arrays.asList(games).forEach(lottoGames::add);

        return lottoGames;
    }
}
