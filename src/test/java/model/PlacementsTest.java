package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlacementsTest {
    Placements placements;

    @BeforeEach
    void setUp() {
        this.placements = new Placements(List.of(
                new Placement(6, 2_000_000_000),
                new Placement(5, 1_500_000),
                new Placement(4, 50_000),
                new Placement(3, 5_000),
                new Placement(0, 0)
        ));
    }

    @Test
    public void totalPrize() {
        int[] placementCounts = new int[]{0, 0, 0, 2, 1, 0, 0};
        int expected = 60_000;
        assertThat(placements.totalPrize(placementCounts)).isEqualTo(expected);
    }
}
