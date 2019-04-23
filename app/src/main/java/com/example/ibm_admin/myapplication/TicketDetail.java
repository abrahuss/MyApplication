
package com.example.ibm_admin.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TicketDetail {

    @SerializedName("ticketNumber")
    @Expose
    private String ticketNumber;
    @SerializedName("ownerGroup")
    @Expose
    private String ownerGroup;
    @SerializedName("ownerName")
    @Expose
    private String ownerName;
    @SerializedName("summary")
    @Expose
    private String summary;

    @SerializedName("severty")
    @Expose
    private String severty;

    public String getSeverty() {
        return severty;
    }

    public void setSeverty(String severty) {
        this.severty = severty;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getOwnerGroup() {
        return ownerGroup;
    }

    public void setOwnerGroup(String ownerGroup) {
        this.ownerGroup = ownerGroup;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
