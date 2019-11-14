package symbols;

public class Symbol{

    enum AssetClass {
        FOREX, METALS, COINS, FUND, FUTURE, OPTION, STOCK;
    }

    AssetClass assetClass;
    String text;
    String root;
    String description;

    public Symbol(String text, String root, String description, AssetClass assetClass){
        this.text = text;
        this.root = root;
        this.assetClass = assetClass;
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AssetClass getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(AssetClass assetClass) {
        this.assetClass = assetClass;
    }
}