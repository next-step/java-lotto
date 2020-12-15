package step3.domain.factory;

import step3.domain.Lotto;
import step3.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static Lotto produceLotto(String numbers) {
        String[] numbersArray = numbers.split(",");
        List<LottoNumber> lotto = new ArrayList<>();

        for (String number : numbersArray) {
            lotto.add(new LottoNumber(Integer.parseInt(number)));
        }
        return new Lotto(lotto);
    }

}
