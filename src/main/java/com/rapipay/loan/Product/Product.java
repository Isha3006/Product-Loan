package com.rapipay.loan.Product;

//import com.rapipay.loan.Products.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "product_details") 

public class Product {
	
	//hibernate is ORM(object relation model) 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private BigDecimal principleAmount;
    private Integer tenure;
    private BigDecimal roi;
    private Boolean isActive;
    private String createdBy;
    private String createdOn;
    private String updatedBy;
    private String updatedOn;

    // constructor
    public Product() {
    }

    public Product( String productName, BigDecimal principleAmount, Integer tenure, BigDecimal roi, String createdBy,String updatedBy, String createdOn, String updatedOn) {
        this.productName = productName;
        this.principleAmount = principleAmount;
        this.tenure = tenure;
        this.roi = roi;
        this.isActive = true;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrincipleAmount() {
        return principleAmount;
    }

    public void setPrincipleAmount(BigDecimal principleAmount) {
        this.principleAmount = principleAmount;
    }

    public Integer getTenure() {
        return tenure;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }

    public BigDecimal getRoi() {
        return roi;
    }

    public void setRoi(BigDecimal roi) {
        this.roi = roi;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "products [productId=" + productId + ", productName=" + productName + ", principleAmount=" + principleAmount + ", tenure=" + tenure + ", roi=" + roi + ", isActive=" + isActive + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
    }

}
