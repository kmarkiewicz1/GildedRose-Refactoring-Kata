package com.gildedrose;

class BackstagePassesUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public int getQualityChange(final int sellInDays, final int quality) {
        if (quality >= 50 && sellInDays > 0) return 0;
        if (sellInDays > 10) return 1;
        if (sellInDays > 5) return 2;
        if (sellInDays > 0) return 3;
        else return -quality;
    }
}
