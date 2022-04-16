package com.gildedrose;

class StandardProductUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public int getQualityChange(final int sellInDays, final int quality) {
        return 0;
    }

    @Override
    public int getSellInDaysDecrease() {
        return 0;
    }
}
