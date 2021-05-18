import java.util.ArrayList;
import java.util.List;

public class LottoAutoMain {
    public static void main(String[] args) {

        List<LottoModel> lottos = new ArrayList<>();
        LottoAutoController controller = new LottoAutoController();

        controller.start(lottos);
    }
}