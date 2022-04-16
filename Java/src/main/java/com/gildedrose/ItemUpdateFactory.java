package com.gildedrose;

class ItemUpdateFactory {
    private final Item item;

    public ItemUpdateFactory(final Item item) {
        this.item = item;
    }

    public ItemUpdateStrategy chooseItemUpdateStrategy() {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieUpdateStrategy();
            default:
                return new StandardProductUpdateStrategy();
        }
    }
}
