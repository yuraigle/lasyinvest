INSERT INTO asset_sectors (NAME) VALUES ("Technology");
INSERT INTO asset_sectors (NAME) VALUES ("Communication Services");
INSERT INTO asset_sectors (NAME) VALUES ("Healthcare");
INSERT INTO asset_sectors (NAME) VALUES ("Financial");
INSERT INTO asset_sectors (NAME) VALUES ("Consumer Cyclical");
INSERT INTO asset_sectors (NAME) VALUES ("Consumer Defensive");
INSERT INTO asset_sectors (NAME) VALUES ("Industrials");
INSERT INTO asset_sectors (NAME) VALUES ("Energy");
INSERT INTO asset_sectors (NAME) VALUES ("Utilities");
INSERT INTO asset_sectors (NAME) VALUES ("Real Estate");
INSERT INTO asset_sectors (NAME) VALUES ("Basic Materials");

INSERT INTO indicators (NAME, DESCRIPTION) VALUES ("P/E", "Price-to-Earnings Ratio");
INSERT INTO indicators (NAME, DESCRIPTION) VALUES ("Debt/Eq", "Total Debt to Equity");

INSERT INTO assets (SYMBOL, NAME, COUNTRY, SECTOR_ID) VALUES ("US500", "S&P 500", 1, NULL);
INSERT INTO assets (SYMBOL, NAME, COUNTRY, SECTOR_ID) VALUES ("AAPL", "Aaple Inc.", 1, 1);
INSERT INTO assets (SYMBOL, NAME, COUNTRY, SECTOR_ID) VALUES ("MSFT", "Microsoft Corporation", 1, 1);
