package lottoauto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lottoauto.model.Lotto;
import lottoauto.model.LottoNumber;
import lottoauto.model.Lottos;

public class LottoFixture {

    public static Lotto lottoFixture(Integer... numbers) {
        return new Lotto(new ArrayList<>(Arrays.asList(numbers)).stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList()));
    }

    public static Lottos lottosFixture(Lotto... lottos) {
        return new Lottos(new ArrayList<>(Arrays.asList(lottos)));
    }

    public static Lottos lottosFixture(Integer... numbers) {
        return new Lottos(new ArrayList<>(Arrays.asList(lottoFixture(numbers))));
    }

    public static List<LottoNumber> intsFixture() {
        return Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::from).collect(Collectors.toList());
    }
}
