package lotto.automatic;

import java.util.*;

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

        //구매 수량만큼 자동 로또
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(lottoOne(lottoNumberList));
        }

        resultView.resultLottoList(lottoList);

        String winningNumber = inputView.inputWinningNumber();
        List<Integer> winningNumberList = winningNumberList(winningNumber);

        int bonusNumber = inputView.inputBonus();

        rank(lottoList, winningNumberList, bonusNumber);

    }


    //로또 추첨을 위한 1~45까지의 번호 리스트
    public List<Integer> numberList() {
        for (int i = 1; i <= LOTTO_MAX_NUM; i++) {
            lottoNumberList.add(i);
        }
        return lottoNumberList;
    }
    //자동 로또 뽑기
    public List<Integer> lottoOne(List<Integer> lottoNumberList) {
        Collections.shuffle(lottoNumberList);
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_SELECT_NUM; i++) {
            lotto.add(lottoNumberList.get(i));
        }
        Collections.sort(lotto);
        return lotto;
    }
    //지난주 로또 당첨 번호
    public List winningNumberList(String winningNumber){
        List<Integer> winningNumberList =new ArrayList<>();
        for (String element : winningNumber.split(", ")) {
            winningNumberList.add(Integer.valueOf(element));
        }
        return  winningNumberList;
    }

    //당첨 개수 비교
    public void rank(ArrayList<List> lottoList, List<Integer> winningNumberList, int bonusNumber){
        int numberOfWinnings = 0;

        boolean bonus = false;
        //로또 개수만큼
        for(List<Integer> lotto : lottoList){
            //로또 당첨 번호 맞추기
            for (int lottoNum : lotto){
                //맞춘 개수
                if(winningNumberList.contains(lotto.get(lottoNum))){
                    numberOfWinnings++;
                }
            }
            //보너스 번호 당첨 여부
            if(winningNumberList.contains(bonusNumber)){
                bonus =true;
            }


            Rank rank = Rank.getRank(numberOfWinnings, bonus);

            //몇개 당첨 됐는지 저장하는 리스트 ? 해쉬맵 ?? 작성해야함 --------
            System.out.println(rank);

        }
    }



}
