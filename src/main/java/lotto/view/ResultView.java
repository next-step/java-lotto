package lotto.view;

import lotto.domain.Rank;

import java.util.List;

public class ResultView {
    public void lottoCountPrint(int lottoQuantity){
        System.out.println(lottoQuantity+"개를 구매했습니다.");
    }

    public void printLotto(List<List<Integer>> lotto){

       for (List<Integer> lottoNumber : lotto){
           System.out.print("[");
           printLottoNumber(lottoNumber);
           System.out.println("]");
       }
    }

    public void printLottoNumber(List<Integer> lottoNumber){
        for (int i = 0; i < lottoNumber.size(); i++) {
            System.out.print(addComma(i)+lottoNumber.get(i));
        }
    }

    String addComma(int index){
        if(index != 0){
            return ",";
        }
        return "";
    }

    public void winningResult(Float revenue){
        System.out.println("6개일치"+"("+Rank.FIRST.getMoney()+")- "+Rank.FIRST.getCount());
        System.out.println("5개일치"+"("+Rank.SECOND.getMoney()+")- "+Rank.SECOND.getCount());
        System.out.println("4개일치"+"("+Rank.THIRD.getMoney()+")- "+Rank.THIRD.getCount());
        System.out.println("3개일치"+"("+Rank.FOURTH.getMoney()+")- "+Rank.FOURTH.getCount());
        System.out.println("");
        String result = String.format("%.2f", revenue);

        System.out.println("총 수익률은 "+result+"입니다");

    }
}
