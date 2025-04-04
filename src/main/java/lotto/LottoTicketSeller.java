package lotto;

class LottoTicketSeller {

  private final int price;

  public LottoTicketSeller() {
    this(1000);
  }

  public LottoTicketSeller(int price) {
    this.price = price;
  }

  public int getLottoPrice() {
    return price;
  }

  public LottoTicket sellAutoLottoTicket() {
    return new LottoTicket();
  }

}
