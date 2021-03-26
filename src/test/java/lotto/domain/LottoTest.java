package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("로또 번호는 1과 45사이의 숫자여야 한다.")
    void lottoNumber(int param) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(param))
                .withMessageMatching("로또 숫자는 1과 45사이의 정수 이어야 합니다.");
    }

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

    @ParameterizedTest
    @CsvSource(value = {"0:0", "6:2000000000", "5:1500000", "4:50000", "3:5000"}, delimiter = ':')
    @DisplayName("숫자 matchCount 별 LottoRank Enum 조회")
    void lottoRank_getEnum(int matchCount, long winAmount) {
        // given
        LottoRank lottoRank = LottoRank.getEnum(matchCount);

        // when then
        assertThat(matchCount).isEqualTo(lottoRank.getMatchCount());
        assertThat(winAmount).isEqualTo(lottoRank.getWinAmount());
    }

    @Test
    @DisplayName("로또 등수 매치카운트에 해당하지 않는 등수정보는 조회불가")
    void lottoRank_getEnum_IllegalParam() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.getEnum(9));
    }

    @ParameterizedTest
    @CsvSource(value = {"7,8,9,10,11,12:0", "1,8,9,10,11,12:0", "1,2,9,10,11,12:0",
                        "1,2,3,10,11,12:3",
                        "1,2,3,4,11,12:4",
                        "1,2,3,4,5,12:5",
                        "1,2,3,4,5,6:6"}
                        , delimiter = ':')
    @DisplayName("로또 등수계산")
    void lotto_inquiryRank(String winNumbers, int matchCount) {
        // given
        int[] lottoNumbers = {1, 2, 3, 4, 5, 6};
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        LottoRank lottoRank = lotto.inquiryRank(Arrays.stream(winNumbers.split(",")).mapToInt(Integer::valueOf).toArray());

        // then
        assertThat(LottoRank.getEnum(matchCount)).isEqualTo(lottoRank);
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

}