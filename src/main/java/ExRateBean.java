import javax.persistence.*;

@Entity
@Table(name="ExRateBean")
public class ExRateBean {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    protected long id;

    @Column(name="date")
    protected String date;

    @Column(name="purchaserate")
    protected float purchaserate;

    @Column(name = "salerate")
    protected float salerate;

    public ExRateBean(){}

    public ExRateBean(String date, float purchaserate, float salerate){
        this.date = date;
        this.purchaserate = purchaserate;
        this.salerate = salerate;
    }

    public ExRateBean(long id, String date, float purchaserate, float salerate){
        this.id = id;
        this.date = date;
        this.purchaserate = purchaserate;
        this.salerate = salerate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPurchaserate() {
        return purchaserate;
    }

    public void setPurchaserate(float purchaserate) {
        this.purchaserate = purchaserate;
    }

    public float getSalerate() {
        return salerate;
    }

    public void setSalerate(float salerate) {
        this.salerate = salerate;
    }
}
