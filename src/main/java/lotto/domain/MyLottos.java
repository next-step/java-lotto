package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLottos {

    private List<Lotto> myLottos = new ArrayList<>();
    private MatchResult matchResult;

    public MyLottos(int lottoCount){
        this.matchResult = new MatchResult();
        for(int i = 0; i < lottoCount; i++){
            myLottos.add(new Lotto());
        }
    }

    public MyLottos(List<Lotto> lottos){
        this.myLottos = lottos;
        this.matchResult = new MatchResult();
    }

    public List<Lotto> myLottos(){
        return myLottos;
    }

    public MatchResult matchMyLotto(WinningLotto winningLotto){
        matchResult.addMatchResult(myLottos, winningLotto);
        return matchResult;
    }

    @Override
    public String toString() {
        return "MyLottos{" +
                "myLottos=" + myLottos +
                ", matchResult=" + matchResult.toString() +
                '}';
    }
}
