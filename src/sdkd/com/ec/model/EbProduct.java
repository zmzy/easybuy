package sdkd.com.ec.model;

/**
 * 商品实体类
 * Created by SDUST-132 on 2016/7/8.
 */
public class EbProduct {
    private Integer epId;
    private String epName;
    private String epDescription;
    private Double epPrice;
    private Integer epStock;
    private Integer epcId;
    private Integer epcChildId;
    private String epFileName;
    private Integer epDiscount;
    private Integer epViews;

    public EbProduct(){}

    public EbProduct(String epName, String epDescription, Double epPrice, Integer epStock, Integer epcId, Integer epcChildId, String epFileName, Integer epDiscount) {
        this.epName = epName;
        this.epDescription = epDescription;
        this.epPrice = epPrice;
        this.epStock = epStock;
        this.epcId = epcId;
        this.epcChildId = epcChildId;
        this.epFileName = epFileName;
        this.epDiscount = epDiscount;
    }

    public Integer getEpId() {
        return epId;
    }

    public void setEpId(Integer epId) {
        this.epId = epId;
    }

    public String getEpName() {
        return epName;
    }

    public void setEpName(String epName) {
        this.epName = epName;
    }

    public String getEpDescription() {
        return epDescription;
    }

    public void setEpDescription(String epDescription) {
        this.epDescription = epDescription;
    }

    public Double getEpPrice() {
        return epPrice;
    }

    public void setEpPrice(Double epPrice) {
        this.epPrice = epPrice;
    }

    public Integer getEpStock() {
        return epStock;
    }

    public void setEpStock(Integer epStock) {
        this.epStock = epStock;
    }

    public Integer getEpcId() {
        return epcId;
    }

    public void setEpcId(Integer epcId) {
        this.epcId = epcId;
    }

    public Integer getEpcChildId() {
        return epcChildId;
    }

    public void setEpcChildId(Integer epcChildId) {
        this.epcChildId = epcChildId;
    }

    public String getEpFileName() {
        return epFileName;
    }

    public void setEpFileName(String epFileName) {
        this.epFileName = epFileName;
    }

    public Integer getEpDiscount() {
        return epDiscount;
    }

    public void setEpDiscount(Integer epDiscount) {
        this.epDiscount = epDiscount;
    }

    public Integer getEpViews() {
        return epViews;
    }

    public void setEpViews(Integer epViews) {
        this.epViews = epViews;
    }

    @Override
    public String toString() {
        return "EbProduct{" +
                "epId=" + epId +
                ", epName='" + epName + '\'' +
                ", epDescription='" + epDescription + '\'' +
                ", epPrice=" + epPrice +
                ", epStock=" + epStock +
                ", epcId=" + epcId +
                ", epcChildId=" + epcChildId +
                ", epFileName='" + epFileName + '\'' +
                ", epDiscount=" + epDiscount +
                ", epViews=" + epViews +
                '}';
    }
}
