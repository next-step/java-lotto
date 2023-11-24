import repository.UserLottoRepository;
import service.LottoResultService;
import service.UserLottoService;

public class AppConfig {

    private UserLottoRepository userLottoRepository = new UserLottoRepository();
    public UserLottoService userLottoService() {
        return new UserLottoService(userLottoRepository);
    }

    public LottoResultService lottoResultService() {
        return new LottoResultService(userLottoRepository);
    }
}
