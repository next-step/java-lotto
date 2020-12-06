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

        String[] manualList = new String[2];
        manualList[0] = "1,2,3,4,5,6";
        manualList[1] = "10,20,30,40,42,45";
        Lotto lotto = new Lotto(3000,manualList);

        assertThat(lotto.getLottoTickets().getTicketCount()).isEqualTo(3);

    }

    @Test
    @DisplayName("수익금 테스트")
    public void benefitTest(){

        EnumMap<Rank, Integer> benefits = new EnumMap<>(Rank.getInitWinningStatics());
        benefits.put(Rank.FIRST,Rank.FIRST.getMoney());
        String[] manualList = new String[2];
        manualList[0] = "1,2,3,4,5,6";
        manualList[1] = "10,20,30,40,42,45";

        Lotto lotto = new Lotto(3000,manualList);
        lotto.resultBenefit(benefits);

    }




}
