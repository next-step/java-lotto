package step2.domain.entity;

import step2.domain.vo.LottoNumber;
import step2.domain.vo.LottoType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {

    private LottoFactory() {
    }

    public static Lotto createAutoLotto(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers, LottoType.AUTO);
    }

    public static Lotto createAutoLotto(int... numbers) {
        return of(LottoType.AUTO, numbers);
    }

    public static Lotto of(LottoType lottoType, int... numbers) {
        return new Lotto(toLottoNumbers(numbers), lottoType);
    }

    public static Lotto of(LottoType lottoType, String number) {
        return new Lotto(toLottoNumbers(split(number)), lottoType);
    }

    public static WinnerLotto createWinnerLotto(LottoNumber bonusNumber, int... numbers) {
        return new WinnerLotto(bonusNumber, toLottoNumbers(numbers));
    }

    public static WinnerLotto createWinnerLotto(LottoNumber bonusNumber, String number) {
        return new WinnerLotto(bonusNumber, toLottoNumbers(split(number)));
    }

    private static List<LottoNumber> toLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static String[] split(String number) {
        return number.split(",");
    }

    private static List<LottoNumber> toLottoNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
