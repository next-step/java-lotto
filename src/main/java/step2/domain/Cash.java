package step2.domain;

public class Cash {
  private final int money;

  public Cash(int money){
    this.money = money;
  }

  public Lottos buyAllLotto(Cash lottoPrice){
    int quantity = money/lottoPrice.money;
    return new Lottos();
  }

  public boolean isMoreThanProductPrice(Cash lottoPrice) {
    return this.money > lottoPrice.money;
  }

}
