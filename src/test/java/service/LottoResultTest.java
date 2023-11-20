package service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.LottoGameResultRepository;
import repository.UserLottoRepository;

public class LottoResultTest {
    UserLottoRepository userLottoRepository;
    LottoGameResultRepository lottoGameResultRepository;
    LottoResultService lottoResultService;

    @BeforeEach
    public void beforeEach() {
        userLottoRepository = new UserLottoRepository();
        lottoResultService = new LottoResultService(userLottoRepository);
        lottoGameResultRepository = new LottoGameResultRepository();
    }

    @AfterEach
    public void afterEach(){
        userLottoRepository.clearStore();
        lottoGameResultRepository.clearStore();
    }
}
