package lotto;

import lotto.model.*;
import lotto.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 객체 생성에 따른 로또 티켓생성 테스트")
    public void initTest(){
        Lotto lotto = new Lotto(3000);

        assertThat(lotto.getLottoTickets().getTicketCount()).isEqualTo(3);

    }

    @Test
    @DisplayName("수익금 테스트")
    public void benefitTest(){
        int money = 2000;

        EnumMap<Rank, Integer> benefits = new EnumMap<Rank, Integer>(Rank.class);
        benefits.put(Rank.FIRST,Rank.FIRST.getMoney());

        Lotto lotto = new Lotto(2000);
        lotto.resultBenefit(benefits);

    }




}
