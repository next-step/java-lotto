package lotto.domain.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto {
    private static final String DEFAULT_DELIMITER = ",";
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String inputNumbers, int bonusNumber) {
        List<Integer> winningNumbers = convertStringToInt(inputNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);

        Lotto lotto = Lotto.createManual(winningNumbers);
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);

        return new WinningLotto(lotto, bonusLottoNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    private static List<Integer> convertStringToInt(String input) {
        String[] splitInput = split(input);
        return Stream.of(splitInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] split(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
    }
}
