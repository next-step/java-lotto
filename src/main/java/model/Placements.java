package model;

import java.util.List;

public class Placements {
    private final List<Placement> placements;

    public Placements(List<Placement> placements) {
        this.placements = placements;
    }

    public Placement placementAt(int placementIndex) {
        return placements.get(placementIndex);
    }

    public int totalPrize(int[] placementCounts) {
        int totalPrize = 0;
        for (Placement placement : placements) {
            totalPrize += placement.prize() * (placementCounts[placement.matchingCount()]);
        }
        return totalPrize;
    }
}
