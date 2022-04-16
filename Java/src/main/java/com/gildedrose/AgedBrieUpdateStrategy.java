package com.gildedrose;

class AgedBrieUpdateStrategy implements ItemUpdateStrategy {

    @Override
    public int getQualityChange(final int sellInDays, final int quality) {
        if (quality >= 50) return 0;
        if (sellInDays > 0) return 1;
        else return 2;
    }

    @Override
    public int getSellInDaysDecrease() {
        return 1;
    }
}
