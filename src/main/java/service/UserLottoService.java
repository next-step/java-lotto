package service;

import domain.Lotto;
import repository.UserLottoRepository;
import util.LottoRandomNumberGenerator;

import java.util.Collections;
import java.util.List;

public class UserLottoService {

    private final UserLottoRepository userLottoRepository;

    public UserLottoService(UserLottoRepository userLottoRepository) {
        this.userLottoRepository = userLottoRepository;
    }

    public List<Lotto> getAllLottoTickets() {
        return userLottoRepository.getUserLottoTickets();
    }

    public void buyRandomLottoTickets(final long money) {
        LottoSalesService lottoSalesService = new LottoSalesService();
        int ticketCount = lottoSalesService.buyTickets(money);

        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoNumbers = LottoRandomNumberGenerator.generateLottoNumber();
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            userLottoRepository.saveUserLottoTickets(lotto);
        }
    }
}
