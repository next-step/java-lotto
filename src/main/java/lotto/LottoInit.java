package lotto;

public class LottoInit {
        private int cost;
        private int count;

    public LottoInit(int cost){
        this.cost = cost;
        this.count = cost/1000;
    }

    public int getCount(){
        return this.count;
    }
    public int getCost(){
        return this.cost;
    }


}
