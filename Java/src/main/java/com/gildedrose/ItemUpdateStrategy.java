package com.gildedrose;
public interface ItemUpdateStrategy {

    int getQualityChange(int sellInDays, final int quality);

    default int getSellInDaysDecrease() {
        return 1;
    }
}
