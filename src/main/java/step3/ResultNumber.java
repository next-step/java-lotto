package step3;

import step3.VO.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class ResultNumber {
    private List<LottoNumber> resultNumberList = new ArrayList<>();
    private LottoNumber bonusNumber;

    public void settingLottoResultNumber(String resultString) {
        resultNumberList = new ArrayList<>();
        for (String number : resultString.split(", ")) {
            resultNumberList.add(new LottoNumber(Integer.parseInt(number)));
        }
    }

    public void settingLottoBonusNumber(String inputBonusNumber) {
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
