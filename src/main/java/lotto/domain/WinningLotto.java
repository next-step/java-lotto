package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Lotto.SIZE;

public class WinningLotto {

    private final List<LottoNumber> winningLotto;

    private WinningLotto(String winningLottoString) {
        List<LottoNumber> winningLotto = parseIntWinningLotto(winningLottoString);
        checkSize(winningLotto);
        this.winningLotto = winningLotto;
    }

    public static WinningLotto ofString(String winningLottoString) {
        return new WinningLotto(winningLottoString);
    }

    public static WinningLotto ofStringAndBonusBall(String winningLottoString, LottoNumber bonusBall) {
        bonusBallDuplicateCheck(bonusBall, parseIntWinningLotto(winningLottoString));
        return new WinningLotto(winningLottoString);
    }


    private static List<LottoNumber> parseIntWinningLotto(String winningLottoString) {
        try {
            List<LottoNumber> winningLotto = Arrays.asList(winningLottoString.split(",")).stream()
                    .map(Integer::parseInt)
                    .map(LottoNumber::ofInt)
                    .collect(Collectors.toList());
            return winningLotto;
        } catch (Exception e) {
            throw new IllegalArgumentException("당첨 번호가 NUMBER로 변환 불가능 합니다.");
        }
    }

    private static void checkSize(List<LottoNumber> winningLotto) {
        if (winningLotto.size() != SIZE) {
            throw new IllegalArgumentException(SIZE + " 와 길이가 다른 winningLotto 는 입력될 수 없습니다.");
        }
    }

    public static void bonusBallDuplicateCheck(LottoNumber bonusBall, List<LottoNumber> winningLotto) {
        if (winningLotto.contains(bonusBall)) {
            throw new IllegalArgumentException("당첨 번호와 보너스볼이 겹칩니다.");
        }
    }

    public boolean checkContainNumber(LottoNumber lottoNumber) {
        return winningLotto.contains(lottoNumber);
    }
}
