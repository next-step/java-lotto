package step2.lotto.automatic.domain;

import step2.lotto.automatic.util.CommonLottoCheck;
import step2.lotto.automatic.util.LottoStep2ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 당첨번호 관리
 */
public class LottoWinningNumber {
    private List<Integer> winningNumbers = new ArrayList<>();
    private CommonLottoCheck commonLottoCheck = new CommonLottoCheck();
    private static final Integer DEFAULTLOTTORANK = 7; // 로또 등수구할때 기본으로 세팅되어있는 값

    public LottoWinningNumber(String WinningNumbers) {
        isNullOrEmptyCheck(WinningNumbers);

        String[] arr = WinningNumbers.replaceAll(" ", "").split(",");
        ChecklottoOverlapNumbers(arr);
        Arrays.sort(arr);
        commonLottoCheck.CheckNumber(Arrays.asList(arr));

        this.winningNumbers = Arrays.asList(arr).stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public Integer getRank(List<Integer> paramValue) {
        Integer returnValue = DEFAULTLOTTORANK;

        for (Integer number : paramValue) {
            returnValue = checkSameValue(number, returnValue);
        }

        //당첨되지 않았을 시
        if (returnValue >= 5) {
            return 0;
        }

        return returnValue;
    }

    private Integer checkSameValue(Integer paramValue, int lottoRank) {
        Integer returnValue = lottoRank;

        if (winningNumbers.contains(paramValue)) {
            returnValue--;
        }

        return returnValue;
    }

    private void isNullOrEmptyCheck(String inputValue) {
        if (inputValue == null || inputValue.isEmpty()) {
            throw new RuntimeException(LottoStep2ErrorMessage.getLottoStep2Runtimeexception());
        }
    }

    private void ChecklottoOverlapNumbers(String[] paramValue) {
        for (int i = 0; i < paramValue.length - 1; i++) {
            isSameValueCheck(paramValue[i], paramValue[i + 1]);
        }
    }

    private void isSameValueCheck(String paramFirst, String paramSecond) {
        if (paramFirst.equals(paramSecond)) {
            throw new RuntimeException(LottoStep2ErrorMessage.getLottoStep2OverlapCheck());
        }
    }

}

