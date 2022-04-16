package com.gildedrose;

class ItemQualityUpdater {
    private final Item item;

    public ItemQualityUpdater(final Item item) {
        this.item = item;
    }

    public void updateQuality() {

        ItemUpdateFactory itemUpdateFactory = new ItemUpdateFactory(item);
        final ItemUpdateStrategy itemUpdateStrategy = itemUpdateFactory.chooseItemUpdateStrategy();

        item.sellIn = item.sellIn - itemUpdateStrategy.getSellInDaysDecrease();
        item.quality = item.quality + itemUpdateStrategy.getQualityChange(item.sellIn, item.quality);
    }
}
