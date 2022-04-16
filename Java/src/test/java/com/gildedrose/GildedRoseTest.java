package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void shouldDecreaseSellIn() {
        //given
        Item[] items = new Item[]{new Item("productX", 3, 0)};
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertThat(app.items[0].sellIn).isEqualTo(2);
    }

    @ParameterizedTest
    @MethodSource(value = "quality")
    void shouldDecreaseQuality(int quality) {
        //given
        Item[] items = new Item[]{new Item("productX", 3, quality)};
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertThat(app.items[0].quality).isEqualTo(quality - 1);
    }

    @ParameterizedTest
    @MethodSource(value = "quality")
    void shouldDecreaseQualityTwiceAsFastWhenSellByDateHasPassed(int quality) {
        //given
        Item[] items = new Item[]{new Item("productX", 0, quality)};
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertThat(app.items[0].quality).isEqualTo(quality - 2);
    }

    public static Stream<Integer> quality() {
        return Stream.of(30, 20, 5);
    }

    @Test
    void qualityShouldNeverBeNegative() {
        //given
        Item[] items = new Item[]{new Item("productX", 0, 0)};
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertThat(app.items[0].quality).isZero();
    }

    @ParameterizedTest
    @MethodSource(value = "agedBrieQuality")
    void agedBrieIncreasesInQualityTheOlderItGets(int sellInDays, int quality, int expectedQuality) {
        //given
        Item[] items = new Item[]{new Item("Aged Brie", sellInDays, quality)};
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertThat(app.items[0].quality).isEqualTo(expectedQuality);
    }

    public static Stream<Arguments> agedBrieQuality() {
        return Stream.of(// sellIn, quality, expectedQuality
            Arguments.of(5, 30, 31),
            Arguments.of(5, 5, 6),
            Arguments.of(5, 50, 50),
            Arguments.of(-1, 30, 32),
            Arguments.of(-1, 5, 7),
            Arguments.of(-1, 50, 50)
        );
    }

    @Test
    void sulfurasItemNeverHasToBeSoldOrDecreasesInQuality() {
        //given
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 40)};
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertThat(app.items[0].quality).isEqualTo(40);
        assertThat(app.items[0].sellIn).isEqualTo(10);
    }

    @ParameterizedTest
    @MethodSource(value = "backstagePassesQuality")
    void backstagePassesIncreasesInQualityTheOlderItGets(int sellInDays, int quality, int expectedQuality) {
        //given
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", sellInDays, quality)};
        GildedRose app = new GildedRose(items);

        //when
        app.updateQuality();

        //then
        assertThat(app.items[0].quality).isEqualTo(expectedQuality);
    }

    public static Stream<Arguments> backstagePassesQuality() {
        return Stream.of(// sellIn, quality, expectedQuality
            Arguments.of(11, 30, 31),
            Arguments.of(11, 5, 6),
            Arguments.of(11, 50, 50),
            Arguments.of(10, 30, 32),
            Arguments.of(10, 5, 7),
            Arguments.of(10, 50, 50),
            Arguments.of(5, 30, 33),
            Arguments.of(5, 5, 8),
            Arguments.of(5, 50, 50),
            Arguments.of(0, 30, 0),
            Arguments.of(0, 5, 0),
            Arguments.of(0, 50, 0)
        );
    }
}
