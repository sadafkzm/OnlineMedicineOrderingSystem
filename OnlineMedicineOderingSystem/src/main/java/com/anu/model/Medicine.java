package com.anu.model;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private Long medicineId;

    @Column(name = "generic_name", nullable = false)
    private String genericName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "expiry_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Medicine(Long medicineId, String genericName, String description, String dosage, BigDecimal price,
			String manufacturer, Date expiryDate) {
		super();
		this.medicineId = medicineId;
		this.genericName = genericName;
		this.description = description;
		this.dosage = dosage;
		this.price = price;
		this.manufacturer = manufacturer;
		this.expiryDate = expiryDate;
	}


	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", genericName=" + genericName + ", description=" + description
				+ ", dosage=" + dosage + ", price=" + price + ", manufacturer=" + manufacturer + ", expiryDate="
				+ expiryDate + "]";
	}


	public Long getMedicineId() {
		return medicineId;
	}


	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}


	public String getGenericName() {
		return genericName;
	}


	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDosage() {
		return dosage;
	}


	public void setDosage(String dosage) {
		this.dosage = dosage;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

   
}
