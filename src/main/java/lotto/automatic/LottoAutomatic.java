package lotto.automatic;

import java.util.*;
import java.util.stream.Collectors;

public class LottoAutomatic {

    final static int LOTTO_MAX_NUM = 45;
    final static int LOTTO_SELECT_NUM = 6;
    LottoAutomaticInputView inputView = new LottoAutomaticInputView();
    LottoAutomaticResultView resultView = new LottoAutomaticResultView();
    List<Integer> lottoNumberList = new ArrayList<>();

    public void lotto() {
        int buyCount = inputView.inputBuyPrice();
        List<Integer> lottoNumberList = numberList();
        ArrayList<List> lottoList = new ArrayList<>();
        for (int i = 1; i < buyCount; i++) {
            lottoList.add(lottoOne(lottoNumberList));
        }
        resultView.resultLottoList(lottoList);

        String winningNumber = inputView.inputWinningNumber();
        List<Integer> winningNumberList = new ArrayList<>();
        for (String element : winningNumber.split(", ")) {
            winningNumberList.add(Integer.valueOf(element));
        }
        int BonusNumber = inputView.inputBonus();

    }

    public List<Integer> lottoOne(List<Integer> lottoNumberList) {
        Collections.shuffle(lottoNumberList);
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_SELECT_NUM; i++) {
            lotto.add(lottoNumberList.get(i));
        }
        Collections.sort(lotto);
        return lotto;
    }

     public List<Integer> numberList() {
        for (int i = 1; i <= LOTTO_MAX_NUM; i++) {
            lottoNumberList.add(i);
        }
        return lottoNumberList;
    }

    public int proceeds(ArrayList<List> lottoList ,String winNumbers){
        List<Integer> winNumbersTest = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        return 1;
    }


}
