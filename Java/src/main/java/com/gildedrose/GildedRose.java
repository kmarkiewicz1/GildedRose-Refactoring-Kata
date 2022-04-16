package com.gildedrose;

import static java.util.Arrays.stream;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        stream(items)
            .map(ItemQualityUpdater::new)
            .forEach(ItemQualityUpdater::updateQuality);
    }
}
