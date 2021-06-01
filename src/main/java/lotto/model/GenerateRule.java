package lotto.model;

public interface GenerateRule {
    public LottoTicket LottoTicket = null;
    public LottoNumber generate();
    public void init();
}