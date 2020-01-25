import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRate
{
    private String baseCurrency;

    private String currency;

    private double saleRateNB;

    private double purchaseRateNB;

    public void setBaseCurrency(String baseCurrency){
        this.baseCurrency = baseCurrency;
    }
    public String getBaseCurrency(){
        return this.baseCurrency;
    }
    public void setCurrency(String currency){
        this.currency = currency;
    }
    public String getCurrency(){
        return this.currency;
    }
    public void setSaleRateNB(double saleRateNB){
        this.saleRateNB = saleRateNB;
    }
    public double getSaleRateNB(){
        return this.saleRateNB;
    }
    public void setPurchaseRateNB(double purchaseRateNB){
        this.purchaseRateNB = purchaseRateNB;
    }
    public double getPurchaseRateNB(){
        return this.purchaseRateNB;
    }
    public static ExchangeRate fill(JSONObject jsonobj){
        ExchangeRate entity = new ExchangeRate();
        if (jsonobj.containsKey("baseCurrency")) {
            entity.setBaseCurrency(jsonobj.getString("baseCurrency"));
        }
        if (jsonobj.containsKey("currency")) {
            entity.setCurrency(jsonobj.getString("currency"));
        }
        if (jsonobj.containsKey("saleRateNB")) {
            entity.setSaleRateNB(jsonobj.getDouble("saleRateNB"));
        }
        if (jsonobj.containsKey("purchaseRateNB")) {
            entity.setPurchaseRateNB(jsonobj.getDouble("purchaseRateNB"));
        }
        return entity;
    }
    public static List<ExchangeRate> fillList(JSONArray jsonarray) {
        if (jsonarray == null || jsonarray.size() == 0)
            return null;
        List<ExchangeRate> olist = new ArrayList<ExchangeRate>();
        for (int i = 0; i < jsonarray.size(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }
}

