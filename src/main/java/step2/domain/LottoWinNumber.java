package step2.domain;

import step2.util.UserInputParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinNumber {
    private final List<LottoNumber> winLottoNumber;

    public LottoWinNumber(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("로또 당첨번호가 비어있습니다");

        winLottoNumber = Arrays.stream(UserInputParser.impl(input))
                .map(LottoNumber::create)
                .collect(Collectors.toList());

        if (winLottoNumber.size() != 6)
            throw new IllegalArgumentException("로또 당첨번호는 6개이다");

        if (winLottoNumber.size() != winLottoNumber.stream().distinct().count())
            throw new IllegalArgumentException("로또 당첨번호는 유니크 합니다");
    }

    public List<LottoNumber> pickLottoNumberOfWeek() {
        return winLottoNumber;
    }
}
