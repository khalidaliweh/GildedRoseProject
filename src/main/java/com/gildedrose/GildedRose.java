package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_QUALITY = 50;
    private static final int ELEVEN_DAYS = 11;
    private static final int SIX_DAYS = 6;
    private static final int SULFURAS_PERM_QUALITY = 80;
    private static final String CONJURED = "Conjured";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            //SULFURAS
            items[i].sellIn = items[i].sellIn - 1;

            if (items[i].name.equals(SULFURAS)) {
                items[i].quality = SULFURAS_PERM_QUALITY;
            }
            //CONJURED
            else if (items[i].name.contains(CONJURED)) {
                updateConjuredItem(items[i]);
            }
            //AGED_BRIE
            else if (items[i].name.equals(AGED_BRIE)) {
                updateAgedBrie(i);
            }
            // BACKSTAGE_PASSES
            else if (items[i].name.equals(BACKSTAGE_PASSES)) {
                updateBackstagePasses(items[i]);
            }
            //Anything else
            else {
                updateRegularItem(i);
            }
        }
    }

    private void updateConjuredItem(Item item) {
        if (item.quality <= MAX_QUALITY) {
            if (item.sellIn < 0) {
                changeQuality(item, -4);
            } else {
                changeQuality(item, -2);
            }
        } else {
            item.quality = MAX_QUALITY;
        }
    }

    private void updateRegularItem(int i) {
        if (items[i].quality <= MAX_QUALITY) {
            if (items[i].quality > 0) {
                if (items[i].sellIn < 0) {
                    changeQuality(items[i], -2);
                } else {
                    changeQuality(items[i], -1);
                }
            } else {
                items[i].quality = 0;
            }
        } else {
            items[i].quality = MAX_QUALITY;
        }
    }

    private void updateBackstagePasses(Item item) {
        if (item.quality <= MAX_QUALITY) {
            changeQuality(item, 1);
            if (item.sellIn < ELEVEN_DAYS) {
                if (item.quality < MAX_QUALITY) {
                    changeQuality(item, 1);
                }
            }
            if (item.sellIn < SIX_DAYS) {
                if (item.quality < MAX_QUALITY) {
                    changeQuality(item, 1);
                }
            }
            if (item.sellIn <= 0) {
                item.quality = 0;
            }
        } else {
            item.quality = MAX_QUALITY;
        }
    }

    private void updateAgedBrie(int i) {
        if (items[i].quality < MAX_QUALITY) {
            if (items[i].sellIn < 0) {
                changeQuality(items[i], 2);
            } else {
                changeQuality(items[i], 1);
            }
        } else {
            items[i].quality = MAX_QUALITY;
        }
    }
    private void changeQuality(Item item, int value) {
        item.quality += value;
    }

}
