package com.gildedrose;

class StandardProductUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public int getQualityChange(final int sellInDays, final int quality) {
        if (sellInDays > 0 && quality >= 1) return -1;
        if (sellInDays <= 0 && quality >= 2) return -2;
        else return -quality;
    }
}
