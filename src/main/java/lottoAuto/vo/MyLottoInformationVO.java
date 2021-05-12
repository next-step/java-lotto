package lottoAuto.vo;

import java.util.List;

public class MyLottoInformationVO {
    private int price;
    private int amount;
    private List<List> lottoNumber;

    public MyLottoInformationVO(int price, int amount, List<List> lottoNumber){
       this.price = price;
       this.amount = amount;
       this.lottoNumber = lottoNumber;
   }

   public int getAmount(){
        return amount;
   }

   public List<List> getLottoNumber(){
        return lottoNumber;
   }
}
