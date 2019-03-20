
import java.util.List;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;
    private LottoGenerator lottoGenerator;
    private int tryNo;

    public LottoMachine(int price) {
        this.tryNo = price / LOTTO_PRICE;
        this.lottoGenerator = new LottoGenerator();
    }

    public List<Integer> machineStart() {
        tryNo--;
        return lottoGenerator.createNumbers();
    }

    public int getTryNo() {
        return tryNo;
    }

    public boolean isEnd() {
        return tryNo == 0;
    }
}
