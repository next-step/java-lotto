package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

  public List<Lotto> lottos = new ArrayList<>();

  private final int MINIMUM_NUMBER = 1;
  private final int MAXIMUM_NUMBER = 45;
  private final int LOTTOSIZE = 6;

  public Lottos(int amount) {
    this.lottos = putLottos(amount);
  }

  private List<Lotto> putLottos(int amount){
    for (int i=0;i<amount;i++){
      Lotto lotto = new Lotto(generateLottoNum());
      this.lottos.add(lotto);
    }
    return lottos;
  }

  private List<Integer> generateLottoNum(){
    List<Integer> lottoNumsList = new ArrayList<>();
    for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
      lottoNumsList.add(i);
    }
    Collections.shuffle(lottoNumsList);
    lottoNumsList = lottoNumsList.subList(0, LOTTOSIZE);
    System.out.println(lottoNumsList.toString());
    return lottoNumsList;
  }

}
