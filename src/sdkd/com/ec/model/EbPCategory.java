package sdkd.com.ec.model;

import java.io.Serializable;

/**
 * Created by SDUST-132 on 2016/7/7.
 */
public class EbPCategory implements Serializable {
    private Integer epcId;
    private String epcname;
    private Integer epcParentId;
    public EbPCategory(){}

    public EbPCategory(Integer epcId, String epcname, Integer epcParentId) {
        this.epcId = epcId;
        this.epcname = epcname;
        this.epcParentId = epcParentId;
    }

    public Integer getEpcId() {
        return epcId;
    }

    public void setEpcId(Integer epcId) {
        this.epcId = epcId;
    }

    public String getEpcname() {
        return epcname;
    }

    public void setEpcname(String epcname) {
        this.epcname = epcname;
    }

    public Integer getEpcParentId() {
        return epcParentId;
    }

    public void setEpcParentId(Integer epcParentId) {
        this.epcParentId = epcParentId;
    }

    @Override
    public String toString() {
        return "EbPCategory{" +
                "epcId=" + epcId +
                ", epcname='" + epcname + '\'' +
                ", epcParentId=" + epcParentId +
                '}';
    }
}
