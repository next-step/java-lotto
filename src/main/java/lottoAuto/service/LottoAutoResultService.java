package lottoAuto.service;

import java.util.List;

public class LottoAutoResultService extends LottoAutoInputService {

    public int showAmount() {
        return myLottoInformationVO.getAmount();
    }

    public List<List> showLottoNumber() {
        return myLottoInformationVO.getLottoNumber();
    }
}
