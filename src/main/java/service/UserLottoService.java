package service;

import domain.Lotto;
import repository.UserLottoRepository;
import util.LottoNumberGenerator;

import java.util.List;

public class UserLottoService {

    private final UserLottoRepository userLottoRepository;

    public UserLottoService(UserLottoRepository userLottoRepository) {
        this.userLottoRepository = userLottoRepository;
    }

    public List<Lotto> getAllLottoTickets() {
        return userLottoRepository.getUserLottoTickets();
    }

    public void buyRandomLottoTickets(int autoTicketCount) {
        for (int i = 0; i < autoTicketCount; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumber();

            Lotto lotto = new Lotto (lottoNumbers);
            userLottoRepository.saveUserLottoTickets(lotto);
        }
    }

    public void buyManualLottoTickets(List<Integer> selectedNumbers) {
        Lotto manualLotto = new Lotto(selectedNumbers);
        userLottoRepository.saveUserLottoTickets(manualLotto);
    }
}
