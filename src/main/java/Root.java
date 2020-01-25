
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

public class Root
{
    private String date;

    private String bank;

    private int baseCurrency;

    private String baseCurrencyLit;

    private List<ExchangeRate> exchangeRate;

    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return this.date;
    }
    public void setBank(String bank){
        this.bank = bank;
    }
    public String getBank(){
        return this.bank;
    }
    public void setBaseCurrency(int baseCurrency){
        this.baseCurrency = baseCurrency;
    }
    public int getBaseCurrency(){
        return this.baseCurrency;
    }
    public void setBaseCurrencyLit(String baseCurrencyLit){
        this.baseCurrencyLit = baseCurrencyLit;
    }
    public String getBaseCurrencyLit(){
        return this.baseCurrencyLit;
    }
    public void setExchangeRate(List<ExchangeRate> exchangeRate){
        this.exchangeRate = exchangeRate;
    }
    public List<ExchangeRate> getExchangeRate(){
        return this.exchangeRate;
    }
    public static Root fill(JSONObject jsonobj){
        Root entity = new Root();
        if (jsonobj.containsKey("date")) {
            entity.setDate(jsonobj.getString("date"));
        }
        if (jsonobj.containsKey("bank")) {
            entity.setBank(jsonobj.getString("bank"));
        }
        if (jsonobj.containsKey("baseCurrency")) {
            entity.setBaseCurrency(jsonobj.getInt("baseCurrency"));
        }
        if (jsonobj.containsKey("baseCurrencyLit")) {
            entity.setBaseCurrencyLit(jsonobj.getString("baseCurrencyLit"));
        }
        if (jsonobj.containsKey("exchangeRate")) {
            entity.setExchangeRate(jsonobj.getJSONArray("exchangeRate"));
        }
        return entity;
    }
    public static List<Root> fillList(JSONArray jsonarray) {
        if (jsonarray == null || jsonarray.size() == 0)
            return null;
        List<Root> olist = new ArrayList<Root>();
        for (int i = 0; i < jsonarray.size(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }
}
