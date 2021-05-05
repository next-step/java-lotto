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

        for (int i = 0; i < buyCount; i++) {
            lottoList.add(lottoOne(lottoNumberList));
        }

        resultView.resultLottoList(lottoList);

        String winningNumber = inputView.inputWinningNumber();
        List<Integer> winningNumberList = winningNumberList(winningNumber);



        int bonusNumber = inputView.inputBonus();

        numberOfWinnings(lottoList, winningNumberList, bonusNumber);



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

    public List winningNumberList(String winningNumber){
        List<Integer> winningNumberList =new ArrayList<>();
        for (String element : winningNumber.split(", ")) {
            winningNumberList.add(Integer.valueOf(element));
        }
        return  winningNumberList;
    }

    public void numberOfWinnings(ArrayList<List> lottoList, List<Integer> winningNumberList, int bonusNumber){
        int numberOfWinnings = 0;

        for(List<Integer> lotto : lottoList){
            for (int lottoNum : lotto){
                if(winningNumberList.contains(lotto.get(lottoNum))==true){
                    numberOfWinnings++;
                }
            }
        }
    }



}
