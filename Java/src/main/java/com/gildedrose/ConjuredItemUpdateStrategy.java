package com.gildedrose;

class ConjuredItemUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public int getQualityChange(final int sellInDays, final int quality) {
        if (sellInDays > 0 && quality >= 2) return -2;
        if (sellInDays > 0) return -quality;

        if (quality >= 4) return -4;
        else return -quality;
    }
}
