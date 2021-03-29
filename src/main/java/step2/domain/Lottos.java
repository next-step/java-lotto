package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
  private final List<Lotto> lottos;

  public Lottos(){
    lottos = new ArrayList<>();
  }

  public void addLotto(Lotto lotto){
    lottos.add(lotto);
  }

  public int quantity(){
    return lottos.size();
  }

  public LottoResult matchLottos(Lotto prizeLotto){
    LottoResult result = new LottoResult();
    for(Lotto targetLotto : lottos){
      result.add(targetLotto.matchLotto(prizeLotto));
    }

    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(Lotto lotto : lottos){
      sb.append(lotto.toString()).append('\n');
    }
    return sb.toString();
  }
}
