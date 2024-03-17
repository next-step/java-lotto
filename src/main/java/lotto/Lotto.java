package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Integer> lotto = new ArrayList<>();
    private int count = 0;

    public Lotto(){
    }

    public Lotto(List<Integer> lotto){
        this.lotto = lotto;
        if(lotto.size()!=6){
            throw new IllegalArgumentException("로또는 6개 원소 필요");
        }
    }

    public void oneLotto(){
        while(this.lotto.size() != 6){
            addLottoNum(RandomGenerator.genRandomNum());
        }
    }

    private void addLottoNum(int element){
        if(!this.lotto.contains(element)){
            this.lotto.add(element);
        }
    }

    public int numOfLotto(){
        return lotto.size();
    }

    public int numMatch(Lotto picked){
        for(int element: picked.getLotto()){
            checkMatch(element);
        }
        return this.count;
    }

    private void checkMatch(int element) {
        if(this.lotto.contains(element)){
            this.count = this.count + 1;
        }
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
