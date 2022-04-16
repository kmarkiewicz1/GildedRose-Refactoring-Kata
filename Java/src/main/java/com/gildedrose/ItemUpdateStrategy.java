package com.gildedrose;
public interface ItemUpdateStrategy {

    int getQualityChange(int sellInDays, final int quality);

    int getSellInDaysDecrease();
}
