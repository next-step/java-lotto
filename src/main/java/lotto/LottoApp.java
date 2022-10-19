package lotto;

public class LottoApp {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start(){
        ClientInput clientInput = inputView.getClientInput();
        Lottos lottos = new Lottos(clientInput.getTicketAmt());
        resultView.printLottos(lottos);
    }
}
