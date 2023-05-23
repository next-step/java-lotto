package step2.domain.Lotto;

import step2.domain.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private List<LottoNum> winningLottoNums;

    public WinningLotto(String winningNums) {
        addAllWinningNums(splitNums(winningNums));
    }

    private String[] splitNums(String winningNum) {
        String[] winningNumList = winningNum.split(",");
        validateWinningNums(winningNumList);
        return winningNumList;
    }

    private void validateWinningNums(String[] winningNumList) {
        if (winningNumList.length > Constant.LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException("로또 번호를 6자까지 입력해주세요.");
        }
    }

    private void addAllWinningNums(String[] winningNumList) {
        this.winningLottoNums = Arrays.stream(winningNumList)
                .map(num -> new LottoNum(num.trim()))
                .collect(Collectors.toList());
    }

    public List<LottoNum> getWinningLottoNums() {
        return winningLottoNums;
    }
}
