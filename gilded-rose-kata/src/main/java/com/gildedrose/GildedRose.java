package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	//mbada
        	//added last comparator for conjured
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") && !items[i].name.startsWith("Conjured") ) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }
            else 
             {
                if (items[i].quality < 50) {            
                	//mbada
                    // "Conjured" items degrade in Quality twice as fast as normal items
                	if (items[i].name.startsWith("Conjured")){
                   	        items[i].quality = items[i].quality - 2;                   	       
                    }
	                else //rest of items
	                    items[i].quality = items[i].quality + 1;
	                //end mbada
                    
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {                        	
                        	//added conjured exception
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")&&!items[i].name.startsWith("Conjured")) {
                                items[i].quality = items[i].quality - 1;
                            }
                            //mbada
                            //Once the sell by date has passed, Quality degrades twice as fast
                            if (items[i].name.startsWith("Conjured")){
                            	items[i].quality = items[i].quality - 2; //we have already degraded 2 point some lines before
                            }
                            
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
            //mbada
            //Quality can never be below 0
            if (items[i].quality<0)
   	        	items[i].quality=0;            
            
        }
    }
}