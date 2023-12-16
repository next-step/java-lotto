package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLottos {

    private List<Lotto> myLottos = new ArrayList<>();

    public MyLottos(int lottoCount){
        for(int i = 0; i < lottoCount; i++){
            myLottos.add(new Lotto());
        }
    }

    public MyLottos(List<Lotto> lottos){
        this.myLottos = lottos;
    }

    public List<Lotto> myLottos(){
        return myLottos;
    }

    public MatchResult matchMyLotto(WinningLotto winningLotto){
        MatchResult matchResult = new MatchResult();
        for(Lotto lotto : myLottos){
            matchResult.addMatchResult(lotto, winningLotto);
        }

        return matchResult;
    }

    @Override
    public String toString() {
        return "MyLottos{" +
                "myLottos=" + myLottos +
                '}';
    }
}
