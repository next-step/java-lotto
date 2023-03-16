package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.Lotto.lottoNumberCount;

public class LottoMain {

    public static int lottoPrice = 1000;

    public static void main(String[] args) {

        LottoView lottoView = new LottoView();

        int lottoBuyCount = 0;
        int inputMoney = 0;
        List<Lotto> myLottoList = new ArrayList<>();
        String[] winningLottoNumbersArray;
        LottoNumber bonusNumber;
        Lotto winningLotto;
        List<LottoNumber> winningLottoNumberList = new ArrayList<>();

        inputMoney = (Integer) lottoView.getClientInput(lottoView.step1);
        if (inputMoney % lottoPrice != 0) {
            throw new IllegalArgumentException("로또 구매금액은 " + lottoPrice + "원 단위로 입력해야 합니다.");
        }
        lottoBuyCount = inputMoney / lottoPrice;

        for (int i = 0; i < lottoBuyCount; i++) {
            myLottoList.add(makeRandomLotto());
        }
        lottoView.printLottoList(myLottoList);

        String step2 = (String)lottoView.getClientInput(lottoView.step2);
        winningLottoNumbersArray = step2.split(",");
        for(String number:winningLottoNumbersArray) {
            winningLottoNumberList.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
        winningLotto = new Lotto(winningLottoNumberList);

        bonusNumber = new LottoNumber((Integer) lottoView.getClientInput(lottoView.step3));

        lottoView.printResult(Lotto.getLottoResult(myLottoList, winningLotto, bonusNumber));
    }

    private static Lotto makeRandomLotto() {
        List<LottoNumber> lottoTempList = new ArrayList<>();
        while (lottoTempList.size() < lottoNumberCount) {
            LottoNumber lottoTempNumber = new LottoNumber();
            if (lottoTempList.contains(lottoTempNumber)) {
                continue;
            }
            lottoTempList.add(lottoTempNumber);
        }
        return new Lotto(lottoTempList);
    }


}
