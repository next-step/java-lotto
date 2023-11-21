package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyLottos {

    private List<Lotto> myLottos;
    private MatchResult matchResult;

    MyLottos(int lottoCount){
        this.myLottos = new ArrayList<>();
        this.matchResult = new MatchResult();
        for(int i = 0; i < lottoCount; i++){
            myLottos.add(new Lotto());
        }
    }

    MyLottos(List<Lotto> lottos){
        this.myLottos = lottos;
        this.matchResult = new MatchResult();
    }

    public List<Lotto> myLottos(){
        return myLottos;
    }

    public Object[] lottoNumbersToArray(int index){
        return myLottos.get(index).numbersToObject();
    }

    public void matchingNumbers(List<Integer> winningNumbers){
        matchResult.addMatchResult(myLottos, winningNumbers);
    }

    public int returnMatchCountOf(int count){
        return matchResult.matchCountOf(count);
    }

    @Override
    public String toString() {
        return "MyLottos{" +
                "myLottos=" + myLottos +
                ", matchResult=" + matchResult.toString() +
                '}';
    }
}
