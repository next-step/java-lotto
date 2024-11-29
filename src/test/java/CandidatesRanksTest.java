import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CandidatesRanksTest {
    @Test
    void get_rank_count() {
        int bonusNum = 16;

        Lotto winning = new Lotto("1,2,3,4,5,6");

        Lotto candidate_1 = new Lotto("1,2,3,4,5,6");
        Lotto candidate_2 = new Lotto("1,2,3,4,5,6");
        Lotto candidate_3 = new Lotto("1,2,3,4,5,16");
        Lotto candidate_4 = new Lotto( "1,2,3,4,15,16");

        Lotto candidate_bonus = new Lotto("1,2,3,4,5,16");

        CandidateRanks ranks = new CandidateRanks();
        ranks.add(new CandidateRank(winning, new LottoNumber(10), candidate_1));
        ranks.add(new CandidateRank(winning, new LottoNumber(10),  candidate_2));
        ranks.add(new CandidateRank(winning, new LottoNumber(10),  candidate_3));
        ranks.add(new CandidateRank(winning, new LottoNumber(10),  candidate_4));
        ranks.add(new CandidateRank(winning, new LottoNumber(bonusNum),  candidate_bonus));

        assertThat(ranks.countFirst()).isEqualTo(2);
        assertThat(ranks.countSecond()).isEqualTo(1);
        assertThat(ranks.countThird()).isEqualTo(1);
        assertThat(ranks.countFourth()).isEqualTo(1);
        assertThat(ranks.countFifth()).isEqualTo(0);
    }

    @Test
    void calculate_benefit_percent(){
        CandidateRanks ranks = new CandidateRanks();

        ranks.add(false, new MatchCount(4));
        ranks.add(false, new MatchCount(0));
        ranks.add(false, new MatchCount(1));

        double benefitPercent = ranks.calcBenefitPercent();

        assertThat(benefitPercent).isEqualTo(16.67);
    }

    @Test
    void calculate_benefit_percent_with_bonus(){
        CandidateRanks ranks = new CandidateRanks();

        ranks.add(false, new MatchCount(4));
        ranks.add(false, new MatchCount(0));
        ranks.add(false, new MatchCount(1));
        ranks.add(true, new MatchCount(5));

        double benefitPercent = ranks.calcBenefitPercent();

        assertThat(benefitPercent).isEqualTo(7512.5);
    }
}
