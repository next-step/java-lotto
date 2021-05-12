package lottoAuto.service;

import lottoAuto.vo.MyLottoInformationVO;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoInputService {
    protected MyLottoInformationVO myLottoInformationVO = null;
    private LottoRandom lottoRandom = new LottoRandom();

    private List<Integer> winningNumber = new ArrayList<>();
    private static final int lotto_price = 1000;

    public void inputPrice(int price) {
        int amount = price / lotto_price;

        List<List> lottoNumber = lottoRandom.setLotto(amount);

        myLottoInformationVO = new MyLottoInformationVO(price, amount, lottoNumber);

    }

    public List<Integer> inputWinningNumber(String winningNumber_string) {
        String[] splitString = winningNumber_string.split(",");

        for (int i = 0; i < splitString.length; i++) {
            winningNumber.add(Integer.valueOf(splitString[i]));
        }
        return winningNumber;

    }
}
