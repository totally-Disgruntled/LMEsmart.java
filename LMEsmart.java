package com.LME.internal;

import com.LME.trading.model.Trade;import java.util.HashMap;
import java.util.Map;public class LMEsmart {    // Simulated order book for matching
    private final Map<String, Double> orderBook = new HashMap<>();    public LMEsmart() {
        // Populate with dummy liquidity
        orderBook.put("XAU", 1923.50);
        orderBook.put("XAG", 24.15);
    }    /**
     * Attempts to match a trade against the internal order book.
     * @param trade The trade to be matched.
     * @return true if matched successfully, false otherwise.
     */
    public boolean matchTrade(Trade trade) {
        System.out.println("[LMEsmart] Attempting to match trade: " + trade);        // Check if the metal is supported
        if (!orderBook.containsKey(trade.getMetal())) {
            System.err.println("[LMEsmart] Unsupported metal: " + trade.getMetal());
            return false;
        }        double marketPrice = orderBook.get(trade.getMetal());        // Simulate price tolerance check (e.g., within 0.5% of market)
        double tolerance = marketPrice * 0.005;
        if (Math.abs(trade.getPrice() - marketPrice) <= tolerance) {
            System.out.println("[LMEsmart] Trade matched at market price: " + marketPrice);
            return true;
        } else {
            System.out.println("[LMEsmart] Trade price out of acceptable range. Market: " + marketPrice + ", Trade: " + trade.getPrice());
            return false;
        }
    }
} 
