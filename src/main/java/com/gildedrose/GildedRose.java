package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int MAX_QUALITY = 50;
    public static final int ELEVEN_DAYS = 11;
    public static final int SIX_DAYS = 6;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals(SULFURAS))
                continue;

            else if (items[i].name.equals(AGED_BRIE)) {
                items[i].sellIn = items[i].sellIn - 1;

                if (items[i].quality < MAX_QUALITY) {
                    if (items[i].sellIn < 0) {
                        changeQuality(items[i], 2);
                    } else {
                        changeQuality(items[i], 1);
                    }
                }

                continue;
            } else if (items[i].name.equals(BACKSTAGE_PASSES)) {

                if (items[i].quality < MAX_QUALITY) {

                    changeQuality(items[i], 1);


                        if (items[i].sellIn < ELEVEN_DAYS) {
                            if (items[i].quality < MAX_QUALITY) {
                                changeQuality(items[i], 1);
                            }
                        }

                        if (items[i].sellIn < SIX_DAYS) {
                            if (items[i].quality < MAX_QUALITY) {
                                changeQuality(items[i], 1);
                            }
                        }

                        if (items[i].sellIn <= 0) {
                            items[i].quality = 0;
                        }
                    }
               continue;
            }
            else {
                items[i].sellIn = items[i].sellIn - 1;
                if (items[i].quality > 0) {
                    if(items[i].sellIn < 0) {
                        changeQuality(items[i], -2);
                    }
                    else {
                        changeQuality(items[i], -1);
                    }
                }

            }




            // all items other than SULFRAS decrease





        }

    }

    private void changeQuality(Item item, int value) {
        item.quality = item.quality + value;
    }

}
