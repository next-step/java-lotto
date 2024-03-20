package lotto;

import static lotto.Lotto.LOTTO_NUMBERS_LIMIT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final List<LottoNumber> winningLotto;

    public List<LottoNumber> getWinningLotto() {
        return winningLotto;
    }

    public WinningLotto(List<LottoNumber> winningLotto) {
        validLottoSize(winningLotto);
        validDuplicatedLottoNumber(winningLotto);
        this.winningLotto = winningLotto;
    }

    public WinningLotto(String[] input){
        List<LottoNumber> winningLotto = convertInputToLottoNumber(input);
        validLottoSize(winningLotto);
        validDuplicatedLottoNumber(winningLotto);
        this.winningLotto = winningLotto;
    }

    private static List<LottoNumber> convertInputToLottoNumber(String[] input) {
        return Arrays.stream(input)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    private void validLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LIMIT) {
            throw new IllegalArgumentException("로또 하나 당 6개의 숫자를 가져야합니다.");
        }
    }

    private void validDuplicatedLottoNumber(List<LottoNumber> numbers) {
        if ((int) numbers.stream().distinct().count() != LOTTO_NUMBERS_LIMIT) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
