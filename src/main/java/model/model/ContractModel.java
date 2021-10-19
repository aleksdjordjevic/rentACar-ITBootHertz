package model.model;

import java.util.Date;
import java.util.UUID;

public class ContractModel {

    UUID contract_id;    //contract_id -primary key, user_id-foreign key; car_id - foreign key;
    Date start_date;
    Date end_date;
    double total_price;
    boolean signed;
    boolean approved;

    public ContractModel() {
        this.contract_id = contract_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.total_price = total_price;
        this.signed = signed;
        this.approved = approved;
    }



    public UUID getContract_id() {
        return contract_id;
    }

    public void setContract_id(UUID contract_id) {
        this.contract_id = contract_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
