package controller;

import domain.Lotto;
import domain.MyLotto;
import domain.TotalTry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {
    @Test
    @DisplayName("총 로또 갯수")
    void totalLotto() {
        TotalTry totalTry = new TotalTry(10);
        LottoController lottoController = new LottoController();
        assertThat(lottoController.totalLotto(totalTry).getLotto().size()).isEqualTo(10);
    }
}