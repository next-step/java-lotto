import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private int tryNo;

    public LottoMachine(LottoMoney lottoMoney) {
        this.tryNo = lottoMoney.count();
    }

    public List<Lotto> generateLotto() {
        List<Lotto> autoLottos = new ArrayList<>();

        while (tryNo > 0) {
            autoLottos.add(new Lotto(LottoGenerator.createLotto()));
            nextTry();
        }

        return autoLottos;
    }

    private void nextTry() {
        tryNo--;
    }

    public int getTryNo() {
        return tryNo;
    }
}
