package asia.duong.exportpdf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pakn_form")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class PaknForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String recipient;
    private String fullName;
    private String address;
    private String province;
    private String district;
    private String ward;
    private String sendMethod;
    private String paknType;
    private String subject;
    @Column(length = 5000)
    private String content;
    private String code;

    public PaknForm() {
    }

    public PaknForm(Long id, String recipient, String fullName, String address, String province, String district, String ward, String sendMethod, String paknType, String subject, String content, String code) {
        this.id = id;
        this.recipient = recipient;
        this.fullName = fullName;
        this.address = address;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.sendMethod = sendMethod;
        this.paknType = paknType;
        this.subject = subject;
        this.content = content;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getSendMethod() {
        return sendMethod;
    }

    public void setSendMethod(String sendMethod) {
        this.sendMethod = sendMethod;
    }

    public String getPaknType() {
        return paknType;
    }

    public void setPaknType(String paknType) {
        this.paknType = paknType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}