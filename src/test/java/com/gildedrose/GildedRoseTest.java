package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void existingFunctionality() {
        //                            Item{ name, sellIn, Quality}
        Item[] items = new Item[] { new Item("foo", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);

    }

    @Test public void itemQualityNeverNegative() {
        //                            Item{ name, sellIn, Quality}
        Item[] items = new Item[] { new Item("foo", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);

        Item[] negativeItem = new Item[] { new Item("foo", 10, -5) };
        GildedRose app2 = new GildedRose(negativeItem);
        app2.updateQuality();

        assertEquals(0, app2.items[0].quality);


    }

    @Test public void itemQualityDecreasesByTwoWhenSellInIsPassed() {
        //                            Item{ name, sellIn, Quality}
        Item[] items = new Item[] { new Item("foo", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test public void agedBrieQualityIncreasesByTwoWhenSellInIsPassed() {
        //                            Item{ name, sellIn, Quality}
        Item[] items = new Item[] { new Item("Aged Brie", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(12, app.items[0].quality);
    }

    @Test public void itemQualityDecreasesBy1() {
        //                            Item{ name, sellIn, Quality}
        Item[] items = new Item[] { new Item("foo", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, app.items[0].quality);
    }

    @Test public void agedBrieIncreasesInQuality() {
        //                            Item{ name, sellIn, Quality}
        Item[] items = new Item[] { new Item("Aged Brie", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(1, app.items[0].quality);
    }
    @Test public void qualityOfNonSulfurasItemsNeverExceeds50() {
        //                            Item{ name, sellIn, Quality}
        Item[] items = new Item[] { new Item("Aged Brie", 10, 500)  , new Item("Conjured Brie", 10, 100)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
    }
    @Test public void backstagePassesOver10DaysIncreasesQualityBy1() {
        //                            Item{ name, sellIn, Quality}
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(21, app.items[0].quality);
    }

    @Test public void backstagePasses10to6DaysIncreasesQualityBy2() {
        //                            Item{ name, sellIn, Quality}
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(22, app.items[0].quality);
    }

    @Test public void backstagePasses5to1DaysIncreasesQualityBy3() {
        //                            Item{ name, sellIn, Quality}
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(23, app.items[0].quality);
    }


    @Test public void backstagePassesDecreaseQualitytoZero() {

        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test public void sulfurasQuality() {
        //                            Item{ name, sellIn, Quality}
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(80, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test public void ifSulfarasIsNotEighty() {
        //                            Item{ name, sellIn, Quality}
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(80, app.items[0].quality);


    }

    @Test public void ifItemConjuredDegradeDouble() {

        Item[] items = new Item[] { new Item("Conjured Paper", 5, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(38, app.items[0].quality);
    }

    @Test public void regularItemQuantityCannotExceedFifty() {

        Item[] items = new Item[] { new Item("Paper", 5, 500) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }



}
