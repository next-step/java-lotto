package lotto.auto.domain;

import lotto.auto.vo.WinNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    //여기에 static 변수를 넣으면 value update 가 되지 않아 로또를 생성할 때 같은 번호가 리스트에 들어갑니다 ㅠㅠ static 을 쓰면서 어떻게 구현해야 할 지 모르겠습니다.
    private final List<Integer> entireNumber = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private final List<Integer> lottoNumber;

    public Lotto() {
        Collections.shuffle(entireNumber);
        this.lottoNumber = entireNumber.subList(0, 6);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumber;
    }

    public Win checkWin(WinNumber winNumber) {
        int matchNumber = 0;
        for (Integer number : winNumber.getWinNumbers()) {
            matchNumber += isMatch(number);
        }
        boolean isMatchBonusNumber = isMatchBonusBall(winNumber.getBonusNumber());
        return Win.getWin(matchNumber, isMatchBonusNumber);
    };

    private int isMatch(Integer win) {
        if(lottoNumber.contains(win)) {
            return 1;
        };
        return 0;
    }

    private boolean isMatchBonusBall(int bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
