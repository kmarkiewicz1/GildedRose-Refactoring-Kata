package com.gildedrose;

class ItemUpdateFactory {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured";
    private final Item item;

    public ItemUpdateFactory(final Item item) {
        this.item = item;
    }

    public ItemUpdateStrategy chooseItemUpdateStrategy() {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrieUpdateStrategy();

            case SULFURAS_HAND_OF_RAGNAROS:
                return new SulfurasUpdateStrategy();

            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                return new BackstagePassesUpdateStrategy();

            case CONJURED:
                return new ConjuredItemUpdateStrategy();

            default:
                return new StandardProductUpdateStrategy();
        }
    }
}
