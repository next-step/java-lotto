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
}
