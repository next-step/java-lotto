package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("로또 구매수량은 최소 1매 이상이어야 한다.")
    void lottoTicket_minCount(int param) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(param))
                .withMessageMatching("최소 1개 이상의 구매수량을 입력해 주세요");
    }

    @Test
    @DisplayName("로또 구매수량만큼의 티켓수가 존재해야 한다.")
    void lottoTicket_count() {
        // given
        int purchaseCount = 5;
        LottoTicket lottoTicket = new LottoTicket(purchaseCount);

        // when then
        assertThat(purchaseCount).isEqualTo(lottoTicket.getCount());
    }

    @Test
    @DisplayName("로또 구매 시 각 로또의 번호는 모두 서로 달라야 한다")
    void lottoNumber_distinct() {
        // given
        LottoTicket lottoTicket = new LottoTicket(14);

        // when then
        for (Lotto lotto : lottoTicket.getLottoList()) {
            assertThat(6).isEqualTo(Arrays.stream(lotto.getLottoNumbers()).distinct().toArray().length);
        }
    }

    @Test
    @DisplayName("LottoTicket - 문자열기반 초기화 테스트")
    void lottoTicket_String() {
        // given
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 3, 13, 28, 32, 34");
        lottoNumberInputList.add("3, 6, 17, 31, 34, 36");

        List<String> lottoNumberTargetList = new ArrayList<>();

        // when
        LottoTicket lottoTicket = new LottoTicket(lottoNumberInputList);
        for (Lotto lotto : lottoTicket.getLottoList()) {
            String lottoNumbers = Arrays.toString(lotto.getLottoNumbers());
            lottoNumbers = lottoNumbers.replace("[", "");
            lottoNumbers = lottoNumbers.replace("]", "");
            lottoNumberTargetList.add(lottoNumbers);
        }

        // then
        for (int i = 0; i < lottoNumberInputList.size(); i++) {
            assertThat(lottoNumberInputList.get(i).equals(lottoNumberTargetList.get(i))).isTrue();
        }
    }

    @Test
    @DisplayName("LottoTicket - 등수조회")
    void lottoTicket_inquiryRank() {
        // given
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 2, 3, 4, 5, 6");
        LottoTicket lottoTicket = new LottoTicket(lottoNumberInputList);

        // when
        LottoRanks lottoRanks = lottoTicket.inquiryRankList(new int[]{1, 2, 3, 4, 5, 6});

        // then
        assertThat(1).isEqualTo(lottoRanks.matchLottoCount(LottoRank.ONE));
    }

    @Test
    @DisplayName("LottoTicket - 등수조회 null 값입력")
    void lottoTicket_inquiryRank_null() {
        // given
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 2, 3, 4, 5, 6");
        LottoTicket lottoTicket = new LottoTicket(lottoNumberInputList);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoTicket.inquiryRankList(null))
                .withMessageMatching("당첨 숫자를 입력해 주세요.");
    }

    @Test
    @DisplayName("LottoTicket - 등수조회 당첨번호 수 불일치")
    void lottoTicket_inquiryRank_winNumberLength() {
        // given
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 2, 3, 4, 5, 6");
        LottoTicket lottoTicket = new LottoTicket(lottoNumberInputList);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoTicket.inquiryRankList(new int[]{1, 2, 3, 4, 5, 6, 7}))
                .withMessageMatching("당첨 숫자는 6개의 수 여야 합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoTicket.inquiryRankList(new int[]{1, 2, 3, 4, 5}))
                .withMessageMatching("당첨 숫자는 6개의 수 여야 합니다.");
    }

    @Test
    @DisplayName("LottoTicket - 등수조회 당첨번호 수 중복입력")
    void lottoTicket_inquiryRank_winNumberDup() {
        // given
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 2, 3, 4, 5, 6");
        LottoTicket lottoTicket = new LottoTicket(lottoNumberInputList);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoTicket.inquiryRankList(new int[]{1, 2, 2, 4, 5, 6}))
                .withMessageMatching("중복된 숫자가 존재합니다. 입력값을 확인해주세요.");
    }

    @Test
    @DisplayName("LottoTicket - 등수조회 당첨번호 수 범위 불일치")
    void lottoTicket_inquiryRank_winNumberIsIllegal() {
        // given
        List<String> lottoNumberInputList = new ArrayList<>();
        lottoNumberInputList.add("1, 2, 3, 4, 5, 6");
        LottoTicket lottoTicket = new LottoTicket(lottoNumberInputList);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoTicket.inquiryRankList(new int[]{1, 48, 2, 3, 5, 6}))
                .withMessageMatching("로또 숫자는 1과 45사이의 정수 이어야 합니다.");
    }
}