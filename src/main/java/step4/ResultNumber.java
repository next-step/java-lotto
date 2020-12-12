package step4;

import step4.VO.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class ResultNumber {
    private List<LottoNumber> resultNumberList = new ArrayList<>();
    private LottoNumber bonusNumber;

    public ResultNumber(String resultString, String inputBonusNumber) {
        settingLottoResultNumber(resultString);
        settingLottoBonusNumber(inputBonusNumber);
    }

    private void settingLottoResultNumber(String resultString) {
        resultNumberList = new ArrayList<>();
        for (String number : resultString.split(", ")) {
            resultNumberList.add(new LottoNumber(Integer.parseInt(number)));
        }
    }

    private void settingLottoBonusNumber(String inputBonusNumber) {
        bonusNumber = new LottoNumber(Integer.parseInt(inputBonusNumber));
    }

    public int checkLottoResult(List<LottoNumber> lottoNumberList) {
        int winningNumber = 0;

        for (LottoNumber i : resultNumberList) {
            winningNumber += checkNumberContain(lottoNumberList, i);
        }
        return winningNumber;
    }

    private int checkNumberContain(List<LottoNumber> lottoNumberList, LottoNumber lottoNumber) {
        if (lottoNumberList.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public boolean checkBonusResult(List<LottoNumber> lottoNumberList) {
        return lottoNumberList.contains(bonusNumber);
    }
}
